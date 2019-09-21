package com.ylsislove.servlet;

import com.alibaba.fastjson.JSON;
import com.ylsislove.model.User;
import com.ylsislove.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Description 添加单个教师信息
 * @ClassName MemberAddServlet
 * @Author Apple_Coco
 * @Date 2019/9/6 21:00
 * @Version V1.0
 */
@WebServlet(value = "/memberAdd.action")
public class MemberAddServlet extends HttpServlet {

    private UserService uService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        User user = new User();
        String json = request.getParameter("userData");
        try {
            BeanUtils.copyProperties(user, JSON.parseObject(json, Map.class));
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        user.setPassword(user.getUserId());
        if (!uService.addUser(user)) {
            response.getWriter().print("工号重复");
        }
    }
}
