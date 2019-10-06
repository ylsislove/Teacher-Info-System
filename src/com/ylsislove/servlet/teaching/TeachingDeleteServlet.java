package com.ylsislove.servlet.teaching;

import com.ylsislove.service.CourseService;
import com.ylsislove.service.TeachingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 删除单个教师的信息
 * @ClassName TeachingDeleteServlet
 * @Author Apple_Coco
 * @Date 2019/9/7 23:33
 * @Version V1.0
 */
@WebServlet(value = "/teachingDelete.action")
public class TeachingDeleteServlet extends HttpServlet {

    private TeachingService tService = new TeachingService();
    private CourseService cService = new CourseService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int teachingId = Integer.parseInt(request.getParameter("teachingId"));
        String courseId = request.getParameter("courseId");
        boolean isSuccess = tService.delete(teachingId);
        if (!isSuccess) {
            response.getWriter().print("教学管理条目("+teachingId+")删除失败");
            return;
        }

        // 检查删除的课程是否还有被其他教学管理条目所引用
        int courseCount = tService.getCourseCount(courseId);
        if (courseCount == 0) {
            // 在课程表中删除该课程信息
            isSuccess = cService.delete(courseId);
            if (!isSuccess) {
                response.getWriter().print("课程("+courseId+")删除失败");
            }
        }
    }
}
