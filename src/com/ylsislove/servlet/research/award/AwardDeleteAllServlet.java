package com.ylsislove.servlet.research.award;

import com.ylsislove.service.research.AwardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 批量删除获奖条目
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/7 16:45
 */
@WebServlet(value = "/awardDeleteAll.action")
public class AwardDeleteAllServlet extends HttpServlet {

    private AwardService aService = new AwardService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String[] ids = request.getParameterValues("data");
        for (String id : ids) {
            boolean isSuccess = aService.delete(Integer.parseInt(id));
            if (!isSuccess) {
                System.out.println(id+"获奖条目删除失败");
                response.getWriter().print(id+"删除失败");
                return;
            }
        }
        System.out.println("获奖条目批量删除成功");
    }
}
