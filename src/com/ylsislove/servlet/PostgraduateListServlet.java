package com.ylsislove.servlet;

import com.ylsislove.model.Page;
import com.ylsislove.model.User;
import com.ylsislove.service.PostgraduateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Description 展示研究生管理列表
 * @ClassName PostgraduateListServlet
 * @Author Apple_Coco
 * @Date 2019/9/8 12:44
 * @Version V1.0
 */
@WebServlet(value = "/postgraduateList.action")
public class PostgraduateListServlet extends HttpServlet {

    private PostgraduateService pService = new PostgraduateService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // 获得访问角色
        String role = request.getParameter("role");

        // 获得当前页码
        int pageNo = 1;
        if (request.getParameter("pageNo") != null) {
            pageNo = Integer.parseInt(request.getParameter("pageNo"));
            if (pageNo < 1) {
                pageNo = 1;
            }
        }

        // 设置访问角色
        request.setAttribute("role", role);

        // 从数据库中取得条目数据并设置
        Page p = null;
        if ("admin".equals(role)) {
            p = pService.getPostgraduatePage(pageNo);

        } else {
            User user = (User) request.getSession().getAttribute("user");
            String userId = user.getUserId();
            p = pService.getPostgraduatePageByUserId(userId, pageNo);
        }
        request.setAttribute("page", p);

        // 把stuDetail的格式改成易于用户阅读的格式
        StringBuilder detail = new StringBuilder();
        List<Map<String, Object>> mapList = p.getMapList();
        for (Map<String, Object> map : mapList) {
            String stuDetail = (String) map.get("stuDetail");
            if ("".equals(stuDetail)) {
                continue;
            }
            else {
                String[] items = stuDetail.split(";");
                for (String item : items) {
                    String[] str = item.split("&");
                    detail.append(str[1] + " ("+ str[3] +"，"+ str[0] +"年毕业，" + str[4] + ")；");
                }
                map.put("stuDetail", detail.toString());
            }
            detail = new StringBuilder();
        }

        // 请求转发
        request.getRequestDispatcher("/admin/postgraduate-list.jsp").forward(request, response);
    }
}
