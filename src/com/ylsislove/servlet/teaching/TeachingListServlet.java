package com.ylsislove.servlet.teaching;

import com.ylsislove.model.dto.Page;
import com.ylsislove.model.User;
import com.ylsislove.service.TeachingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 展示教学管理条目
 * @ClassName TeachingListServlet
 * @Author Apple_Coco
 * @Date 2019/9/7 20:42
 * @Version V1.0
 */
@WebServlet(value = "/teachingList.action")
public class TeachingListServlet extends HttpServlet {

    private TeachingService tService = new TeachingService();
    private String[] typeName = {"", "本科课堂教学", "本科实验教学", "研究生课堂教学", "研究生实验教学"};

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
        // 获得条目类型
        int type = Integer.parseInt(request.getParameter("type"));
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
        // 设置条目类型
        request.setAttribute("type", type);
        // 设置条目名称
        request.setAttribute("name", typeName[type]);

        // 从数据库中取得条目数据并设置
        Page p = null;

        // 判断是否是搜索模式
        if ("search".equals(mode) && !"".equals(keyword)) {
            if ("admin".equals(role)) {
                p = tService.getSearchKeyword(keyword, type, pageNo);
            }else {
                User user = (User) request.getSession().getAttribute("user");
                String userId = user.getUserId();
                p = tService.getSearchKeywordByUserId(keyword, type, userId, pageNo);
            }

        } else if ("admin".equals(role)) {
            p = tService.getTeachingPage(type, pageNo);

        } else {
            User user = (User) request.getSession().getAttribute("user");
            String userId = user.getUserId();
            p = tService.getTeachingPageByUserId(userId, type, pageNo);
        }
        request.setAttribute("page", p);

        // 请求转发
        request.getRequestDispatcher("/admin/teaching-list.jsp").forward(request, response);

    }

}
