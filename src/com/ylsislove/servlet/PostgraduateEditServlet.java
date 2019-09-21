package com.ylsislove.servlet;

import com.ylsislove.model.Postgraduate;
import com.ylsislove.service.PostgraduateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 处理修改后的研究生管理条目
 * @ClassName PostgraduateEditServlet
 * @Author Apple_Coco
 * @Date 2019/9/10 0:42
 * @Version V1.0
 */
@WebServlet(value = "/postgraduateEdit.action")
public class PostgraduateEditServlet extends HttpServlet {

    private PostgraduateService pService = new PostgraduateService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // 获取当前编辑的id号
        int id = Integer.parseInt(request.getParameter("stuId"));

        // 获取userId
        String userId = request.getParameter("userId");

        // 获取入学年份
        int academicDate = Integer.parseInt(request.getParameter("academicDate"));

        // 获取到条目数量
        int sum = Integer.parseInt(request.getParameter("sum"));
        int index = 1;
        StringBuilder stuDetail = new StringBuilder();

        int sumT = sum;
        // 保存研究生指导信息
        while (sumT > 0 && index < 100) {
            if (request.getParameter("graduationDate" + index) == null) {
                index ++;
                continue;
            }
            stuDetail.append(request.getParameter("graduationDate" + index) + "&");
            stuDetail.append(request.getParameter("stuName" + index) + "&");
            stuDetail.append(request.getParameter("stuId" + index) + "&");
            stuDetail.append(request.getParameter("stuType" + index) + "&");
            stuDetail.append(request.getParameter("isFirstTutor" + index));
            stuDetail.append(";");
            index ++;
            sumT --;
        }

        // 填充研究生管理条目
        Postgraduate postgraduate = new Postgraduate(id, academicDate, userId, sum, stuDetail.toString());

        // 更新研究生管理条目
        pService.updatePostgraduate(postgraduate);
    }
}
