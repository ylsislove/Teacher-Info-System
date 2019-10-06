package com.ylsislove.servlet.research.project;

import com.ylsislove.model.research.ResearchProject;
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
 * @version V1.0 2019/10/6 14:48
 */
@WebServlet(value = "/researchProjectDetail.action")
public class ResearchProjectDetailServlet extends HttpServlet {

    private ResearchProjectService rService = new ResearchProjectService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        ResearchProject project = rService.selectResearchProjectById(id);
        request.setAttribute("project", project);
        // 请求转发
        request.getRequestDispatcher("/research/research-project-detail.jsp").forward(request, response);

    }
}
