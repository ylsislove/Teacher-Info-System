package com.ylsislove.servlet.research.patent;

import com.alibaba.fastjson.JSON;
import com.ylsislove.model.User;
import com.ylsislove.model.research.Patent;
import com.ylsislove.service.research.PatentService;

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
 * @version V1.0 2019/10/20 15:26
 */
@WebServlet(value = "/patentExport.action")
public class PatentExportServlet extends HttpServlet {

    private PatentService pService = new PatentService();

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
        String role = request.getParameter("role");

        if ("admin".equals(role)) {
            List<Patent> allProject = pService.selectPatentList(page, limit);
            Map<String, Object> data = new HashMap<>();
            data.put("code", 0);
            data.put("msg", "");
            data.put("count", pService.selectPatentCount());
            Object json = JSON.toJSON(allProject);
            data.put("data", json);
            response.getWriter().write(JSON.toJSONString(data));

        } else {
            User user = (User) request.getSession().getAttribute("user");
            List<Patent> allProject = pService.selectPatentListByUserId(user.getUserId(), page, limit);
            Map<String, Object> data = new HashMap<>();
            data.put("code", 0);
            data.put("msg", "");
            data.put("count", pService.selectPatentCountByUserId(user.getUserId()));
            Object json = JSON.toJSON(allProject);
            data.put("data", json);
            response.getWriter().write(JSON.toJSONString(data));
        }

    }
}
