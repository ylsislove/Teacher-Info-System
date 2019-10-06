package com.ylsislove.servlet.research.paper;

import com.ylsislove.model.research.ScientificPaper;
import com.ylsislove.service.research.ScientificPaperService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 论文详情
 *
 * @author Apple_Coco
 * @version V1.0 2019/9/28 22:46
 */
@WebServlet(value = "/scientificPaperDetail.action")
public class ScientificPaperDetailServlet extends HttpServlet {

    private ScientificPaperService sService = new ScientificPaperService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        ScientificPaper scientificPaper = sService.selectScientificPaperById(id);
        request.setAttribute("paper", scientificPaper);
        // 请求转发
        request.getRequestDispatcher("/research/scientific-paper-detail.jsp").forward(request, response);

    }
}
