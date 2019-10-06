package com.ylsislove.servlet.research.patent;

import com.ylsislove.model.research.Patent;
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
 * @version V1.0 2019/10/6 15:04
 */
@WebServlet(value = "/patentDetail.action")
public class PatentDetailServlet extends HttpServlet {

    private PatentService pService = new PatentService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        Patent patent = pService.selectPatentById(id);
        request.setAttribute("patent", patent);
        // 请求转发
        request.getRequestDispatcher("/research/patent-detail.jsp").forward(request, response);

    }
}
