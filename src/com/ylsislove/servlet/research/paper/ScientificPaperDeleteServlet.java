package com.ylsislove.servlet.research.paper;

import com.ylsislove.service.research.ScientificPaperService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 论文条目删除
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/7 16:42
 */
@WebServlet(value = "/scientificPaperDelete.action")
public class ScientificPaperDeleteServlet extends HttpServlet {

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
        boolean isSuccess = sService.delete(id);
        if (!isSuccess) {
            response.getWriter().print("论文条目("+id+")删除失败");
        }

    }
}
