package com.ylsislove.servlet.postgraduate;

import com.ylsislove.service.PostgraduateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 批量删除研究生管理条目信息
 * @ClassName PostgraduateDeleteAllServlet
 * @Author Apple_Coco
 * @Date 2019/9/8 12:45
 * @Version V1.0
 */
@WebServlet(value = "/postgraduateDeleteAll.action")
public class PostgraduateDeleteAllServlet extends HttpServlet {

    private PostgraduateService pService = new PostgraduateService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String[] ids = request.getParameterValues("pData");
        for (String id : ids) {
            boolean isSuccess = pService.delete(Integer.parseInt(id));
            if (!isSuccess) {
                System.out.println(id+"删除失败");
                response.getWriter().print(id+"删除失败");
                return;
            }
        }
        System.out.println("批量删除成功");
    }
}
