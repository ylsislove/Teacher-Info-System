package com.ylsislove.servlet.undergraduate;

import com.ylsislove.model.dto.Page;
import com.ylsislove.model.User;
import com.ylsislove.service.UndergraduateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 展示本科生管理条目
 * @ClassName UndergraduateListServlet
 * @Author Apple_Coco
 * @Date 2019/9/8 3:43
 * @Version V1.0
 */
@WebServlet(value = "/undergraduateList.action")
public class UndergraduateListServlet extends HttpServlet {

    private UndergraduateService unService = new UndergraduateService();
    private String[] typeName = {"", "本科生产实习", "本科毕业论文"};

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
                p = unService.getSearchKeyword(keyword, type, pageNo);
            }else {
                User user = (User) request.getSession().getAttribute("user");
                String userId = user.getUserId();
                p = unService.getSearchKeywordByUserId(keyword, type, userId, pageNo);
            }

        } else if ("admin".equals(role)) {
            p = unService.getUndergraduatePage(type, pageNo);

        } else {
            User user = (User) request.getSession().getAttribute("user");
            String userId = user.getUserId();
            p = unService.getUndergraduatePageByUserId(userId, type, pageNo);
        }
        request.setAttribute("page", p);

        // 请求转发
        request.getRequestDispatcher("/admin/undergraduate-list.jsp").forward(request, response);
    }

}
