package com.ylsislove.servlet.research.award;

import com.alibaba.fastjson.JSON;
import com.ylsislove.model.User;
import com.ylsislove.model.research.Award;
import com.ylsislove.service.research.AwardService;

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
 * @version V1.0 2019/10/20 15:18
 */
@WebServlet(value = "/awardExport.action")
public class AwardExportServlet extends HttpServlet {

    private AwardService aService = new AwardService();

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
            List<Award> allProject = aService.selectAwardList(type);
            Map<String, Object> data = new HashMap<>();
            data.put("code", 0);
            data.put("msg", "");
            data.put("count", aService.selectAwardCount(type));
            Object json = JSON.toJSON(allProject);
            data.put("data", json);
            response.getWriter().write(JSON.toJSONString(data));

        } else {
            User user = (User) request.getSession().getAttribute("user");
            List<Award> allProject = aService.selectAwardListByUserId(user.getUserId(), type);
            Map<String, Object> data = new HashMap<>();
            data.put("code", 0);
            data.put("msg", "");
            data.put("count", aService.selectAwardCountByUserId(user.getUserId(), type));
            Object json = JSON.toJSON(allProject);
            data.put("data", json);
            response.getWriter().write(JSON.toJSONString(data));
        }

//        if ("admin".equals(role)) {
//            List<Award> allProject = aService.selectAwardList(type, page, limit);
//            Map<String, Object> data = new HashMap<>();
//            data.put("code", 0);
//            data.put("msg", "");
//            data.put("count", aService.selectAwardCount(type));
//            Object json = JSON.toJSON(allProject);
//            data.put("data", json);
//            response.getWriter().write(JSON.toJSONString(data));
//
//        } else {
//            User user = (User) request.getSession().getAttribute("user");
//            List<Award> allProject = aService.selectAwardListByUserId(user.getUserId(), type, page, limit);
//            Map<String, Object> data = new HashMap<>();
//            data.put("code", 0);
//            data.put("msg", "");
//            data.put("count", aService.selectAwardCountByUserId(user.getUserId(), type));
//            Object json = JSON.toJSON(allProject);
//            data.put("data", json);
//            response.getWriter().write(JSON.toJSONString(data));
//        }

    }
}
