package com.ylsislove.servlet;

import com.ylsislove.service.UserService;
import com.ylsislove.service.research.AwardService;
import com.ylsislove.service.research.PatentService;
import com.ylsislove.service.research.ResearchProjectService;
import com.ylsislove.service.research.ScientificPaperService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/24 21:32
 */
@WebServlet(value = "/welcome.action")
public class WelcomeServlet extends HttpServlet {

    private UserService userService = new UserService();
    private ScientificPaperService paperService = new ScientificPaperService();
    private ResearchProjectService projectService = new ResearchProjectService();
    private AwardService awardService = new AwardService();
    private PatentService patentService = new PatentService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Map<String, String> map = new HashMap<>(8);
        // 获得教师数
        map.put("user", userService.selectUserCount()+"");
        // 获得科研论文数
        map.put("paper1", paperService.selectPaperCount(1)+"");
        // 获得教学论文数
        map.put("paper2", paperService.selectPaperCount(2)+"");
        // 获得科研项目数
        map.put("project1", projectService.selectProjectCount(1)+"");
        // 获得教学项目数
        map.put("project2", projectService.selectProjectCount(2)+"");
        // 获得科研奖项数
        map.put("award1", awardService.selectAwardCount(1)+"");
        // 获得教学奖项数
        map.put("award2", awardService.selectAwardCount(2)+"");
        // 获得专利数
        map.put("patent", patentService.selectPatentCount()+"");

        request.setAttribute("map", map);
        request.getRequestDispatcher("/admin/welcome.jsp").forward(request, response);
    }
}
