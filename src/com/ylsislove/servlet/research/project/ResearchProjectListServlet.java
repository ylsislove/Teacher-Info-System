package com.ylsislove.servlet.research.project;

import com.ylsislove.model.dto.Page;
import com.ylsislove.service.research.ResearchProjectService;

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
 * @version V1.0 2019/10/4 1:12
 */
@WebServlet(value = "/researchProjectList.action")
public class ResearchProjectListServlet extends HttpServlet {

    private ResearchProjectService rService = new ResearchProjectService();
    private String[] typeName = {"", "科研项目", "教学项目"};

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
        if ("admin".equals(role)) {
            p = rService.getProjectPage(type, pageNo);
        }
        request.setAttribute("page", p);

        // 请求转发
        request.getRequestDispatcher("/research/research-project-list.jsp").forward(request, response);

    }
}
