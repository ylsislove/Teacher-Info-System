package com.ylsislove.servlet;

import com.ylsislove.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description TODO
 * @ClassName LogoutServlet
 * @Author Apple_Coco
 * @Date 2019/9/5 21:29
 * @Version V1.0
 */
@WebServlet(value = "/logout.action")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            request.getSession().removeAttribute("user");
        }
        User admin = (User) request.getSession().getAttribute("admin");
        if (admin != null) {
            request.getSession().removeAttribute("admin");
        }
        response.sendRedirect("/login.jsp");
    }
}
