package com.ylsislove.servlet.research.award;

import com.ylsislove.service.research.AwardService;

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
 * @version V1.0 2019/10/7 16:44
 */
@WebServlet(value = "/awardDelete.action")
public class AwardDeleteServlet extends HttpServlet {

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
        boolean isSuccess = aService.delete(id);
        if (!isSuccess) {
            response.getWriter().print("获奖条目("+id+")删除失败");
        }
    }
}
