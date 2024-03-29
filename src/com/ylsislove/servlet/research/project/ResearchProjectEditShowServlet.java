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
 * @version V1.0 2019/10/7 0:25
 */
@WebServlet(value = "/researchProjectEditShow.action")
public class ResearchProjectEditShowServlet extends HttpServlet {

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
                String[] str = item.split("\\|");
                List<String> t = new ArrayList<>(3);
                t.add(str[0]);
                t.add(str.length > 1 ? str[1] : "");
                t.add(str.length > 2 ? str[2] : "");
                Member member = new Member(t.get(0), t.get(1), t.get(2));
                if ("null".equals(t.get(2))) {
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

        request.getRequestDispatcher("/research/research-project-edit.jsp").forward(request, response);

    }
}
