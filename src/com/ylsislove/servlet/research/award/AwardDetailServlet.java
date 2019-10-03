package com.ylsislove.servlet.research.award;

import com.ylsislove.model.Award;
import com.ylsislove.service.AwardService;

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
 * @version V1.0 2019/9/30 0:03
 */
@WebServlet(value = "/awardDetail.action")
public class AwardDetailServlet extends HttpServlet {

    private AwardService aService = new AwardService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        Award award = aService.selectAwardById(id);
        request.setAttribute("award", award);
        // 请求转发
        request.getRequestDispatcher("/research/award-detail.jsp").forward(request, response);

    }
}
