package com.ylsislove.servlet.postgraduate;

import com.ylsislove.model.dto.Page;
import com.ylsislove.model.User;
import com.ylsislove.service.PostgraduateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
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

        // 获取到模式以及关键词
        String mode = request.getParameter("mode");
        String keyword = request.getParameter("keyword");

        // 设置模式以及关键词
        request.setAttribute("mode", mode);
        request.setAttribute("keyword", keyword);

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

        // 判断是否是搜索模式
        if ("search".equals(mode) && !"".equals(keyword)) {
            if ("admin".equals(role)) {
                p = pService.getSearchKeyword(keyword, pageNo);
            }else {
                User user = (User) request.getSession().getAttribute("user");
                String userId = user.getUserId();
                p = pService.getSearchKeywordByUserId(keyword, userId, pageNo);
            }

        } else if ("admin".equals(role)) {
            p = pService.getPostgraduatePage(pageNo);

        } else {
            User user = (User) request.getSession().getAttribute("user");
            String userId = user.getUserId();
            p = pService.getPostgraduatePageByUserId(userId, pageNo);
        }
        request.setAttribute("page", p);


        // 把stuDetail的格式改成易于用户阅读的格式
        if (p != null) {
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
                        String[] str = item.split("\\|");
                        List<String> t = new ArrayList<>(5);
                        t.add(str[0]);
                        t.add(str.length > 1 ? str[1] : "");
                        t.add(str.length > 2 ? str[2] : "");
                        t.add(str.length > 3 ? str[3] : "");
                        t.add(str.length > 4 ? str[4] : "");
                        detail.append(t.get(1) + " ("+ t.get(3) +"，"+ t.get(0) +"年毕业，" + t.get(4) + ")；");
                    }
                    map.put("stuDetail", detail.toString());
                }
                detail = new StringBuilder();
            }
        }

        // 请求转发
        request.getRequestDispatcher("/admin/postgraduate-list.jsp").forward(request, response);
    }
}
