package com.ylsislove.utils;

import com.ylsislove.servlet.research.paper.PaperCiteAutoUpdate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * TODO
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/22 18:38
 */
@WebServlet(value = "/updateStart.action")
public class UpdateStartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int type = Integer.parseInt(request.getParameter("type"));
        if (type == 0) {
            PaperCiteAutoUpdate.updateShutdown();
        } else {
            PaperCiteAutoUpdate.updateStart();
        }

    }
}
