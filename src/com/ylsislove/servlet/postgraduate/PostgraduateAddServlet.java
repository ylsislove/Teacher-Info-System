package com.ylsislove.servlet.postgraduate;

import com.alibaba.fastjson.JSON;
import com.ylsislove.model.Postgraduate;
import com.ylsislove.model.User;
import com.ylsislove.service.PostgraduateService;
import com.ylsislove.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Description 添加研究生管理条目信息
 * @ClassName PostgraduateAddServlet
 * @Author Apple_Coco
 * @Date 2019/9/8 12:44
 * @Version V1.0
 */
@WebServlet(value = "/postgraduateAdd.action")
public class PostgraduateAddServlet extends HttpServlet {

    private UserService uService = new UserService();
    private PostgraduateService pService = new PostgraduateService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String userId = request.getParameter("userId");
        String username = request.getParameter("username");

        User user = uService.selectById(userId);
        if (user == null) {
            response.getWriter().print("教师信息不存在，请先添加教师信息");
            return;
        } else if (!"".equals(username) && !user.getUsername().equals(username)) {
            response.getWriter().print("教师工号与姓名不拼配，请重新确认");
            return;
        }

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
        Postgraduate postgraduate = new Postgraduate(academicDate, userId, sum, stuDetail.toString());

        // 保存教学管理条目到数据库
        pService.addPostgraduate(postgraduate);
    }
}
