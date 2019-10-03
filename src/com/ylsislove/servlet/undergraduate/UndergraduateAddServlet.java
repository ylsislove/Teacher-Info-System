package com.ylsislove.servlet.undergraduate;

import com.alibaba.fastjson.JSON;
import com.ylsislove.model.Undergraduate;
import com.ylsislove.model.User;
import com.ylsislove.service.UndergraduateService;
import com.ylsislove.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Description 添加本科生管理条目
 * @ClassName UndergraduateAddServlet
 * @Author Apple_Coco
 * @Date 2019/9/8 3:44
 * @Version V1.0
 */
@WebServlet(value = "/undergraduateAdd.action")
public class UndergraduateAddServlet extends HttpServlet {

    private UserService uService = new UserService();
    private UndergraduateService unService = new UndergraduateService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String json = request.getParameter("undergraduateData");
        Map map = JSON.parseObject(json, Map.class);

        int type = Integer.parseInt(request.getParameter("type"));
        String userId = (String) map.get("userId");
        String username = (String) map.get("username");

        User user = uService.selectById(userId);
        if (user == null) {
            response.getWriter().print("教师信息不存在，请先添加教师信息");
            return;
        } else if (!"".equals(username) && !user.getUsername().equals(username)) {
            response.getWriter().print("教师工号与姓名不拼配，请重新确认");
            return;
        }

        // 计算学生人数
        String stuName = (String) map.get("stuName");
        stuName = stuName.replaceAll(";|；|，", ",");
        int stuNum = stuName.split(",").length;
        stuName = stuName.replaceAll(",", ", ");

        // 填充本科管理条目
        int weekNum = 0;
        if (type == 1) {
            weekNum = Integer.parseInt((String)map.get("weekNum"));
        }
        Undergraduate undergraduate = new Undergraduate(userId,
                (String)map.get("time"), stuName, stuNum, weekNum, type);

        // 保存本科管理条目到数据库
        unService.addUndergraduate(undergraduate);
    }
}
