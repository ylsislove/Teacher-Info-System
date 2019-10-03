package com.ylsislove.servlet.teaching;

import com.ylsislove.service.CourseService;
import com.ylsislove.service.TeachingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 批量删除教学条目信息
 * @ClassName TeachingDeleteAllServlet
 * @Author Apple_Coco
 * @Date 2019/9/8 1:47
 * @Version V1.0
 */
@WebServlet(value = "/teachingDeleteAll.action")
public class TeachingDeleteAllServlet extends HttpServlet {

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
        String[] tData = request.getParameterValues("tData");
        List<String> courseIds = new ArrayList<String>();
        for (String teaching : tData) {

            String[] s = teaching.split("&");
            int teachingId = Integer.parseInt(s[0]);
            courseIds.add(s[1]);

            boolean isSuccess = tService.delete(teachingId);
            if (!isSuccess) {
                System.out.println(teachingId+"删除失败");
                response.getWriter().print("教学管理条目("+teachingId+")删除失败");
                return;
            }
        }

        // 检查删除的课程是否还有被其他教学管理条目所引用
        for (String id : courseIds) {
            int courseCount = tService.getCourseCount(id);
            if (courseCount == 0) {
                // 在课程表中删除该课程信息
                boolean isSuccess = cService.delete(id);
                if (!isSuccess) {
                    response.getWriter().print("课程("+id+")删除失败");
                    return;
                }
            }
        }
        System.out.println("批量删除成功");
    }
}
