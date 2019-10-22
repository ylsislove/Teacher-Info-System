package com.ylsislove.servlet.member;

import com.alibaba.fastjson.JSON;
import com.ylsislove.model.User;
import com.ylsislove.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/10 2:26
 */
@WebServlet(value = "/memberExport.action")
public class MemberExportServlet extends HttpServlet {

    private UserService uService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String role = request.getParameter("role");

        if ("admin".equals(role)) {
            List<User> allUser = uService.selectUserList();
            Map<String, Object> data = new HashMap<>();
            data.put("code", 0);
            data.put("msg", "");
            data.put("count", uService.selectUserCount());
            Object json = JSON.toJSON(allUser);
            data.put("data", json);
            response.getWriter().write(JSON.toJSONString(data));

        } else {
            User user = (User) request.getSession().getAttribute("user");
            List<User> allUser = new ArrayList<>(1);
            allUser.add(user);
            Map<String, Object> data = new HashMap<>();
            data.put("code", 0);
            data.put("msg", "");
            data.put("count", 1);
            Object json = JSON.toJSON(allUser);
            data.put("data", json);
            response.getWriter().write(JSON.toJSONString(data));
        }

    }

}
