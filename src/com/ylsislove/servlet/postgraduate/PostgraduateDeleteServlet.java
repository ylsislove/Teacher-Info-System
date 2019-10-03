package com.ylsislove.servlet.postgraduate;

import com.ylsislove.service.PostgraduateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 删除单个研究生管理条目信息
 * @ClassName PostgraduateDeleteServlet
 * @Author Apple_Coco
 * @Date 2019/9/8 12:45
 * @Version V1.0
 */
@WebServlet(value = "/postgraduateDelete.action")
public class PostgraduateDeleteServlet extends HttpServlet {

    private PostgraduateService pService = new PostgraduateService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int postgraduateId = Integer.parseInt(request.getParameter("postgraduateId"));
        boolean isSuccess = pService.delete(postgraduateId);
        if (!isSuccess) {
            response.getWriter().print("研究生管理条目("+postgraduateId+")删除失败");
        }
    }
}
