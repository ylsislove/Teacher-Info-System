package com.ylsislove.servlet.member;

import com.ylsislove.model.dto.Page;
import com.ylsislove.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 展示教师列表
 * @ClassName MemberListServlet
 * @Author Apple_Coco
 * @Date 2019/9/5 23:53
 * @Version V1.0
 */
@WebServlet(value = "/memberList.action")
public class MemberListServlet extends HttpServlet {

    private UserService uService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int pageNo = 1;
        if (request.getParameter("pageNo") != null) {
            pageNo = Integer.parseInt(request.getParameter("pageNo"));
            if (pageNo < 1) {
                pageNo = 1;
            }
        }
        Page p = null;
        if ("search".equals(request.getParameter("mode"))) {
            String keyword = request.getParameter("keyword");
            p = uService.getSearchUserPage(keyword, pageNo);

        } else {
            p = uService.getUserPage(pageNo);
        }
        request.setAttribute("page", p);
        request.getRequestDispatcher("/admin/member-list.jsp").forward(request, response);
    }
}
