package com.ylsislove.servlet.research.patent;

import com.ylsislove.model.User;
import com.ylsislove.model.dto.Page;
import com.ylsislove.service.research.PatentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TODO
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/6 15:03
 */
@WebServlet(value = "/patentList.action")
public class PatentListServlet extends HttpServlet {

    private PatentService pService = new PatentService();

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
            p = pService.getPatentPage(pageNo);

        } else {
            User user = (User) request.getSession().getAttribute("user");
            String userId = user.getUserId();
            p = pService.getPatentPageByUserId(userId, pageNo);
        }
        request.setAttribute("page", p);

        // 请求转发
        request.getRequestDispatcher("/research/patents-list.jsp").forward(request, response);

    }
}
