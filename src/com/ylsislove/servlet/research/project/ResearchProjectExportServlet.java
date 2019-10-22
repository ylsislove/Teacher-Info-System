package com.ylsislove.servlet.research.project;

import com.alibaba.fastjson.JSON;
import com.ylsislove.model.User;
import com.ylsislove.model.research.ResearchProject;
import com.ylsislove.model.research.ScientificPaper;
import com.ylsislove.service.research.ResearchProjectService;
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
 * @version V1.0 2019/10/20 13:47
 */
@WebServlet(value = "/researchProjectExport.action")
public class ResearchProjectExportServlet extends HttpServlet {

    private ResearchProjectService rService = new ResearchProjectService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int type = Integer.parseInt(request.getParameter("type"));
        String role = request.getParameter("role");

        if ("admin".equals(role)) {
            List<ResearchProject> allProject = rService.selectProjectList(type);
            Map<String, Object> data = new HashMap<>();
            data.put("code", 0);
            data.put("msg", "");
            data.put("count", rService.selectProjectCount(type));
            Object json = JSON.toJSON(allProject);
            data.put("data", json);
            response.getWriter().write(JSON.toJSONString(data));

        } else {
            User user = (User) request.getSession().getAttribute("user");
            List<ResearchProject> allProject = rService.selectProjectListByUserId(user.getUserId(), type);
            Map<String, Object> data = new HashMap<>();
            data.put("code", 0);
            data.put("msg", "");
            data.put("count", rService.selectProjectCountByUserId(user.getUserId(), type));
            Object json = JSON.toJSON(allProject);
            data.put("data", json);
            response.getWriter().write(JSON.toJSONString(data));
        }

//        if ("admin".equals(role)) {
//            List<ResearchProject> allProject = rService.selectProjectList(type, page, limit);
//            Map<String, Object> data = new HashMap<>();
//            data.put("code", 0);
//            data.put("msg", "");
//            data.put("count", rService.selectProjectCount(type));
//            Object json = JSON.toJSON(allProject);
//            data.put("data", json);
//            response.getWriter().write(JSON.toJSONString(data));
//
//        } else {
//            User user = (User) request.getSession().getAttribute("user");
//            List<ResearchProject> allProject = rService.selectProjectListByUserId(user.getUserId(), type, page, limit);
//            Map<String, Object> data = new HashMap<>();
//            data.put("code", 0);
//            data.put("msg", "");
//            data.put("count", rService.selectProjectCountByUserId(user.getUserId(), type));
//            Object json = JSON.toJSON(allProject);
//            data.put("data", json);
//            response.getWriter().write(JSON.toJSONString(data));
//        }
    }
}
