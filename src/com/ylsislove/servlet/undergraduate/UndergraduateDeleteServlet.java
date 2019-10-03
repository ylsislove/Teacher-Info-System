package com.ylsislove.servlet.undergraduate;

import com.ylsislove.service.UndergraduateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 删除单个本科生管理条目信息
 * @ClassName UndergraduateDeleteServlet
 * @Author Apple_Coco
 * @Date 2019/9/8 3:46
 * @Version V1.0
 */
@WebServlet(value = "/undergraduateDelete.action")
public class UndergraduateDeleteServlet extends HttpServlet {

    private UndergraduateService unService = new UndergraduateService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int undergraduateId = Integer.parseInt(request.getParameter("undergraduateId"));
        boolean isSuccess = unService.delete(undergraduateId);
        if (!isSuccess) {
            response.getWriter().print("删除失败");
        }
    }
}
