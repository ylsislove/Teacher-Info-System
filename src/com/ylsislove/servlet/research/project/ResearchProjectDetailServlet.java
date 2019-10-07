package com.ylsislove.servlet.research.project;

import com.ylsislove.model.dto.Member;
import com.ylsislove.model.dto.Unit;
import com.ylsislove.model.research.ResearchProject;
import com.ylsislove.service.research.ResearchProjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/6 14:48
 */
@WebServlet(value = "/researchProjectDetail.action")
public class ResearchProjectDetailServlet extends HttpServlet {

    private ResearchProjectService rService = new ResearchProjectService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        ResearchProject project = rService.selectResearchProjectById(id);
        request.setAttribute("project", project);

        // 回显项目成员详情
        String memberDetail = project.getMembers();
        List<Member> memberList = new ArrayList<Member>();
        if (memberDetail == null) {
            memberList.add(new Member("", "", ""));
        }
        else {
            String[] items = memberDetail.split(";");
            for (String item : items) {
                String[] str = item.split("&");
                Member member = new Member(str[0], str[1], str[2]);
                if ("blank".equals(str[2])) {
                    member.setUserId("");
                }
                memberList.add(member);
            }
        }
        request.setAttribute("memberList", memberList);

        // 回显参与单位详情
        String unitDetail = project.getWorkUnits();
        List<Unit> unitList = new ArrayList<Unit>();
        if (unitDetail == null) {
            unitList.add(new Unit(""));
        }
        else {
            String[] items = unitDetail.split(";");
            for (String item : items) {
                Unit unit = new Unit(item);
                unitList.add(unit);
            }
        }
        request.setAttribute("unitList", unitList);

        // 请求转发
        request.getRequestDispatcher("/research/research-project-detail.jsp").forward(request, response);

    }
}
