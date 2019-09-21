package com.ylsislove.servlet;

import com.alibaba.fastjson.JSON;
import com.ylsislove.model.Course;
import com.ylsislove.model.Teaching;
import com.ylsislove.service.CourseService;
import com.ylsislove.service.TeachingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * @Description 处理修改后的教学管理条目
 * @ClassName TeachingEditServlet
 * @Author Apple_Coco
 * @Date 2019/9/10 20:26
 * @Version V1.0
 */
@WebServlet(value = "/teachingEdit.action")
public class TeachingEditServlet extends HttpServlet {

    private CourseService cService = new CourseService();
    private TeachingService tService = new TeachingService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String json = request.getParameter("teachingData");
        Map map = JSON.parseObject(json, Map.class);

        int type = Integer.parseInt(request.getParameter("type"));
        int id = Integer.parseInt(request.getParameter("id"));
        String userId = (String)map.get("userId");

        // 填充课程
        Course course = new Course((String)map.get("courseTime"), (String)map.get("courseName"),
                (String)map.get("courseAttr"), Integer.parseInt((String)map.get("courseTotalHours")));

        // 查询原先的课程被引用次数
        String oldCourseId = request.getParameter("courseId");
        int courseCount = tService.getCourseCount(oldCourseId);

        // 查询课程是否已存在
        boolean isDelete = false;
        Course c = cService.getCourse(course);
        if (c == null) {
            // 课程不存在，且原先的课程被引用次数只有一次
            if (courseCount == 1) {
                // 在课程表中删除该课程信息
                isDelete = true;
            }

            // 保存新课程到数据库
            String courseId = UUID.randomUUID().toString().replaceAll("-","");
            course.setId(courseId);
            cService.addCourse(course);

        } else {
            // 课程存在，但和修改前的课程不一致
            if (!oldCourseId.equals(c.getId())) {
                if (courseCount == 1) {
                    // 若修改前的课程引用次数只有一次，则在课程表中删除该课程信息
                    isDelete = true;
                }
            }
            course = c;
        }

        // 计算班级数
        String classrooms = (String) map.get("classrooms");
        classrooms = classrooms.replaceAll(";|；|，", ",");
        int classNum = classrooms.split(",").length;

        // 填充教学管理条目
        int groupNum = 0;
        if (type == 2 || type == 4) {
            groupNum = Integer.parseInt((String)map.get("groupNum"));
        }
        Teaching teaching = new Teaching(id, userId, course.getId(), classrooms, classNum, Integer.parseInt((String)map.get("stuNum")),
                groupNum, Integer.parseInt((String)map.get("courseRealHours")), (String)map.get("isEnglish"), type);

        // 更新教学管理条目到数据库
        tService.updateTeaching(teaching);

        if (isDelete) {
            boolean isSuccess = cService.delete(oldCourseId);
            if (!isSuccess) {
                response.getWriter().print("课程("+oldCourseId+")删除失败");
            }
        }
    }
}
