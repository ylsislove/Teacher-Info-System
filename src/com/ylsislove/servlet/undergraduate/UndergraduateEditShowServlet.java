package com.ylsislove.servlet.undergraduate;

import com.ylsislove.service.UndergraduateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Description 处理编辑本科生管理条目的回显
 * @ClassName UndergraduateEditShowServlet
 * @Author Apple_Coco
 * @Date 2019/9/10 23:22
 * @Version V1.0
 */
@WebServlet(value = "/undergraduateEditShow.action")
public class UndergraduateEditShowServlet extends HttpServlet {

    private UndergraduateService unService = new UndergraduateService();
    private String[] typeName = {"", "本科生产实习", "本科毕业论文"};

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        Map<String, Object> map = unService.selectUndergraduateById(id);
        request.setAttribute("map", map);

        // 设置条目类型
        int type = (int) map.get("type");
        request.setAttribute("type", type);

        // 设置条目名称
        request.setAttribute("name", typeName[type]);

        // 请求转发
        request.getRequestDispatcher("/admin/undergraduate-edit.jsp").forward(request, response);

    }
}
