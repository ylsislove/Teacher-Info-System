package com.ylsislove.servlet.teaching;

import com.ylsislove.service.TeachingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Description 处理编辑教学管理条目的回显
 * @ClassName TeachingEditShowServlet
 * @Author Apple_Coco
 * @Date 2019/9/10 20:24
 * @Version V1.0
 */
@WebServlet(value = "/teachingEditShow.action")
public class TeachingEditShowServlet extends HttpServlet {

    private TeachingService tService = new TeachingService();
    private String[] typeName = {"", "本科课堂教学", "本科实验教学", "研究生课堂教学", "研究生实验教学"};

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        Map<String, Object> map = tService.selectTeachingById(id);
        request.setAttribute("map", map);

        // 设置条目类型
        int type = (int) map.get("type");
        request.setAttribute("type", type);

        // 设置条目名称
        request.setAttribute("name", typeName[type]);

        // 请求转发
        request.getRequestDispatcher("/admin/teaching-edit.jsp").forward(request, response);

    }
}
