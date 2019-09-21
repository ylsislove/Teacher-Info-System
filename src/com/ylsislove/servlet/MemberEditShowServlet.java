package com.ylsislove.servlet;

import com.ylsislove.model.User;
import com.ylsislove.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 处理编辑教师详情页面的回显
 * @ClassName MemberEditShowServlet
 * @Author Apple_Coco
 * @Date 2019/9/10 0:38
 * @Version V1.0
 */
@WebServlet(value = "/memberEditShow.action")
public class MemberEditShowServlet extends HttpServlet {

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
        request.setAttribute("user", user);
        request.getRequestDispatcher("/admin/member-edit.jsp").forward(request, response);
    }
}
