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
 * @Description 处理用户登录
 * @ClassName LoginServlet
 * @Author Apple_Coco
 * @Date 2019/9/5 17:15
 * @Version V1.0
 */
@WebServlet(value = "/login.action")
public class LoginServlet extends HttpServlet {

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
        String password = request.getParameter("password");

        User user = uService.login(userId, password);
        if (user == null) {
            request.setAttribute("failMsg", "工号或密码错误，请重新输入！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            if (user.getIsadmin() == 1){
                request.getSession().setAttribute("admin", user);
                request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
            } else{
                request.getSession().setAttribute("user", user);
                request.getRequestDispatcher("/teacher/index.jsp").forward(request, response);
            }
        }
    }
}
