package com.ylsislove.servlet.research.patent;

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
 * @version V1.0 2019/10/7 16:45
 */
@WebServlet(value = "/patentDelete.action")
public class PatentDeleteServlet extends HttpServlet {

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
        boolean isSuccess = pService.delete(id);
        if (!isSuccess) {
            response.getWriter().print("专利条目("+id+")删除失败");
        }
    }
}
