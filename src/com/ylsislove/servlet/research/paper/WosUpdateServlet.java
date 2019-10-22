package com.ylsislove.servlet.research.paper;

import com.ylsislove.service.research.WosService;

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
 * @version V1.0 2019/10/22 17:27
 */
@WebServlet(value = "/wosUpdate.action")
public class WosUpdateServlet extends HttpServlet {

    private WosService wosService = new WosService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String url = request.getParameter("url");
        wosService.updateUrl(url);
        System.out.println("Wos访问地址更新：" + url);

    }
}
