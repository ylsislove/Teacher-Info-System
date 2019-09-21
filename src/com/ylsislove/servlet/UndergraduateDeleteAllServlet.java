package com.ylsislove.servlet;

import com.ylsislove.service.UndergraduateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 批量删除本科生管理条目信息
 * @ClassName UndergraduateDeleteAllServlet
 * @Author Apple_Coco
 * @Date 2019/9/8 3:47
 * @Version V1.0
 */
@WebServlet(value = "/undergraduateDeleteAll.action")
public class UndergraduateDeleteAllServlet extends HttpServlet {

    private UndergraduateService unService = new UndergraduateService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String[] ids = request.getParameterValues("unData");
        for (String id : ids) {
            boolean isSuccess = unService.delete(Integer.parseInt(id));
            if (!isSuccess) {
                System.out.println(id+"删除失败");
                response.getWriter().print(id+"删除失败");
                return;
            }
        }
        System.out.println("批量删除成功");
    }
}
