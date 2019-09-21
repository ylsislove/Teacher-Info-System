package com.ylsislove.servlet;

import com.alibaba.fastjson.JSON;
import com.ylsislove.model.Course;
import com.ylsislove.model.Teaching;
import com.ylsislove.model.User;
import com.ylsislove.service.CourseService;
import com.ylsislove.service.TeachingService;
import com.ylsislove.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * @Description 添加教学管理条目
 * @ClassName TeachingAddServlet
 * @Author Apple_Coco
 * @Date 2019/9/7 18:56
 * @Version V1.0
 */
@WebServlet(value = "/teachingAdd.action")
public class TeachingAddServlet extends HttpServlet {

    private UserService uService = new UserService();
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
        String userId = (String) map.get("userId");
        String username = (String) map.get("username");

        User user = uService.selectById(userId);
        if (user == null) {
            response.getWriter().print("教师信息不存在，请先添加教师信息");
            return;
        } else if (!"".equals(username) && !user.getUsername().equals(username)) {
            response.getWriter().print("教师工号与姓名不拼配，请重新确认");
            return;
        }

        // 填充课程
        Course course = new Course((String)map.get("courseTime"), (String)map.get("courseName"),
                (String)map.get("courseAttr"), Integer.parseInt((String)map.get("courseTotalHours")));

        // 查询课程是否已存在
        Course c = cService.getCourse(course);
        if (c == null) {
            // 课程不存在，保存课程到数据库
            String courseId = UUID.randomUUID().toString().replaceAll("-","");
            course.setId(courseId);
            cService.addCourse(course);
        } else {
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
        Teaching teaching = new Teaching(userId, course.getId(), classrooms, classNum, Integer.parseInt((String)map.get("stuNum")),
                groupNum, Integer.parseInt((String)map.get("courseRealHours")), (String)map.get("isEnglish"), type);

        // 保存教学管理条目到数据库
        tService.addTeaching(teaching);

    }
}
