package com.ylsislove.servlet.teaching;

import com.alibaba.fastjson.JSON;
import com.ylsislove.model.Course;
import com.ylsislove.model.Teaching;
import com.ylsislove.model.User;
import com.ylsislove.service.CourseService;
import com.ylsislove.service.TeachingService;
import com.ylsislove.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 教学管理批量导入
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/9 16:29
 */
@WebServlet(value = "/teachingUpload.action")
public class TeachingUploadServlet extends HttpServlet {

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

        // 获取教学管理类型
        int type = Integer.parseInt(request.getParameter("type"));

        // 获取前端数据
        String json = request.getParameter("data");
        StringBuilder msg = new StringBuilder();

        // 解析并导入
        Map map = (Map) JSON.parseObject(json, Map.class).get("0");
        for (Object o : map.keySet()) {
            List list = (List)(map.get(o));
            int i = 0;
            for (Object o1 : list) {
                // 跳过第一轮的Excel表头
                if (++i == 1) {
                    continue;
                }
                Teaching teaching = new Teaching();
                Course course = new Course();
                try {
                    BeanUtils.copyProperties(teaching, o1);
                    BeanUtils.copyProperties(course, o1);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }

                // 查询教师信息是否存在
                User user = uService.selectById(teaching.getUserId());
                if (user == null) {
                    msg.append(teaching.getUserId() + ", ");
                    continue;
                }

                // 查询课程是否已存在
                Course c = cService.getCourse(course);
                if (c == null) {
                    // 课程不存在，保存课程到数据库
                    String courseId = UUID.randomUUID().toString().replaceAll("-","");
                    course.setId(courseId);
                    cService.addCourse(course);
                    teaching.setCourseId(courseId);
                } else {
                    teaching.setCourseId(c.getId());
                }

                // 计算班级数
                String classrooms = teaching.getClassrooms();
                classrooms = classrooms.replaceAll(";|；|，", ",");
                int classNum = classrooms.split(",").length;
                teaching.setClassNum(classNum);

                // 填充类型
                teaching.setType(type);

                // 保存教学管理条目到数据库
                tService.addTeaching(teaching);
                System.out.println("添加教学管理条目：" + teaching);
            }
        }
        if (!"".equals(msg.toString())) {
            response.getWriter().print("导入失败, 工号" + msg.toString() + "教师信息不存在");
        }

    }
}
