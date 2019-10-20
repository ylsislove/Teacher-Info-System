package com.ylsislove.servlet.research.paper;

import com.alibaba.fastjson.JSON;
import com.ylsislove.model.User;
import com.ylsislove.model.research.ScientificPaper;
import com.ylsislove.service.research.ScientificPaperService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/15 13:47
 */
@WebServlet(value = "/scientificPaperExport.action")
public class ScientificPaperExportServlet extends HttpServlet {

    private ScientificPaperService sService = new ScientificPaperService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        int type = Integer.parseInt(request.getParameter("type"));
        String role = request.getParameter("role");

        if ("admin".equals(role)) {
            List<ScientificPaper> allPaper = sService.selectPaperList(type, page, limit);
            Map<String, Object> data = new HashMap<>();
            data.put("code", 0);
            data.put("msg", "");
            data.put("count", sService.selectPaperCount(type));
            Object json = JSON.toJSON(allPaper);
            data.put("data", json);
            response.getWriter().write(JSON.toJSONString(data));

        } else {
            User user = (User) request.getSession().getAttribute("user");
            List<ScientificPaper> allPaper = sService.selectPaperListByUserId(user.getUserId(), type, page, limit);
            Map<String, Object> data = new HashMap<>();
            data.put("code", 0);
            data.put("msg", "");
            data.put("count", sService.selectPaperCountByUserId(user.getUserId(), type));
            Object json = JSON.toJSON(allPaper);
            data.put("data", json);
            response.getWriter().write(JSON.toJSONString(data));
        }
    }
}
