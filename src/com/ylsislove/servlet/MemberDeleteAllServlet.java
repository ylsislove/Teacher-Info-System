package com.ylsislove.servlet;

import com.ylsislove.model.Postgraduate;
import com.ylsislove.model.Teaching;
import com.ylsislove.model.Undergraduate;
import com.ylsislove.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Description 批量删除教师信息
 * @ClassName MemberDeleteAllServlet
 * @Author Apple_Coco
 * @Date 2019/9/6 19:59
 * @Version V1.0
 */
@WebServlet(value = "/memberDeleteAll.action")
public class MemberDeleteAllServlet extends HttpServlet {

    private UserService uService = new UserService();
    private TeachingService tService = new TeachingService();
    private CourseService cService = new CourseService();
    private UndergraduateService unService = new UndergraduateService();
    private PostgraduateService pService = new PostgraduateService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String[] ids = request.getParameterValues("uData");
        int deleteMode = Integer.parseInt(request.getParameter("deleteMode"));

        // 普通删除模式
        if (deleteMode == 0) {
            for (String userId : ids) {
                boolean isSuccess = uService.delete(userId);
                if (!isSuccess) {
                    System.out.println(userId+"删除失败");
                    response.getWriter().print(userId+"删除失败，请先删除与该教师关联的其他信息");
                    return;
                }
            }
            System.out.println("批量删除成功");

        } else {
            // 级联删除模式
            for (String userId : ids) {
                // 首先删除与该教师关联的教学管理条目
                List list = tService.getTeachingByUserId(userId);
                for (Object o : list) {
                    Teaching teaching = (Teaching) o;
                    String courseId = teaching.getCourseId();

                    boolean isSuccess = tService.delete(teaching.getId());
                    if (!isSuccess) {
                        response.getWriter().print("教学管理条目("+teaching.getId()+")删除失败");
                        return;
                    }

                    // 检查删除的课程是否还有被其他教学管理条目所引用
                    int courseCount = tService.getCourseCount(courseId);
                    if (courseCount == 0) {
                        // 在课程表中删除该课程信息
                        isSuccess = cService.delete(courseId);
                        if (!isSuccess) {
                            response.getWriter().print("课程("+courseId+")删除失败");
                            return;
                        }
                    }
                }

                // 然后删除与该教师关联的本科管理条目
                list = unService.getUndergraduateByUserId(userId);
                for (Object o : list) {
                    Undergraduate undergraduate = (Undergraduate) o;
                    boolean isSuccess = unService.delete(undergraduate.getId());
                    if (!isSuccess) {
                        response.getWriter().print("本科管理条目("+undergraduate.getId()+")删除失败");
                        return;
                    }
                }

                // 然后删除与该教师关联的研究生管理条目
                list = pService.getPostgraduateByUserId(userId);
                for (Object o : list) {
                    Postgraduate postgraduate = (Postgraduate) o;
                    boolean isSuccess = pService.delete(postgraduate.getId());
                    if (!isSuccess) {
                        response.getWriter().print("研究生管理条目("+postgraduate.getId()+")删除失败");
                        return;
                    }
                }

                // 最后删除该教师的基本信息
                boolean isSuccess = uService.delete(userId);
                if (!isSuccess) {
                    System.out.println(userId+"级联删除失败");
                    response.getWriter().print("级联删除失败，请联系管理员解决");
                    return;
                }
            }
            System.out.println("级联批量删除成功");
        }
    }
}
