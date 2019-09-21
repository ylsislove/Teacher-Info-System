package com.ylsislove.servlet;

import com.ylsislove.model.EduExperience;
import com.ylsislove.model.User;
import com.ylsislove.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 从管理员界面显示教师信息的首页
 * @ClassName TeacherIndexServlet
 * @Author Apple_Coco
 * @Date 2019/9/5 21:47
 * @Version V1.0
 */
@WebServlet(value = "/teacherIndex.action")
public class TeacherIndexServlet extends HttpServlet {

    private UserService uService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String userId = request.getParameter("userId");
        User user = uService.selectById(userId);
        request.getSession().setAttribute("user", user);

        request.getRequestDispatcher("/teacher/index.jsp").forward(request, response);
    }
}
