package com.ylsislove.servlet;

import com.alibaba.fastjson.JSON;
import com.ylsislove.model.Undergraduate;
import com.ylsislove.service.UndergraduateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Description 处理修改后的本科生管理条目
 * @ClassName UndergraduateEditServlet
 * @Author Apple_Coco
 * @Date 2019/9/10 23:47
 * @Version V1.0
 */
@WebServlet(value = "/undergraduateEdit.action")
public class UndergraduateEditServlet extends HttpServlet {

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
        int id = Integer.parseInt(request.getParameter("id"));
        String userId = (String)map.get("userId");

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
        Undergraduate undergraduate = new Undergraduate(id, userId,
                (String)map.get("time"), stuName, stuNum, weekNum, type);

        // 更新教学管理条目到数据库
        unService.updateUndergraduate(undergraduate);
    }
}
