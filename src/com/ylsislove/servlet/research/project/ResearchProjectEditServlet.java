package com.ylsislove.servlet.research.project;

import com.ylsislove.model.research.ResearchProject;
import com.ylsislove.service.research.ResearchProjectService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * TODO
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/7 0:25
 */
@WebServlet(value = "/researchProjectEdit.action")
public class ResearchProjectEditServlet extends HttpServlet {

    private ResearchProjectService rService = new ResearchProjectService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // 填充基本信息
        ResearchProject project = new ResearchProject();
        try {
            BeanUtils.copyProperties(project, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        // 获取到项目成员信息
        int memberSum = Integer.parseInt(request.getParameter("memberSum"));
        int index = 1;
        StringBuilder memberDetail = new StringBuilder();

        while (memberSum > 0 && index < 100) {
            if (request.getParameter("memberName" + index) == null) {
                index ++;
                continue;
            }
            memberDetail.append(request.getParameter("memberName" + index) + "&");
            memberDetail.append(request.getParameter("isOurTeacher" + index) + "&");
            memberDetail.append("".equals(request.getParameter("userId" + index)) ? "blank" : request.getParameter("userId" + index));
            memberDetail.append(";");
            index ++;
        }
        project.setMembers(memberDetail.toString());

        // 获取到参与单位信息
        int workUnitSum = Integer.parseInt(request.getParameter("workUnitSum"));
        index = 1;
        StringBuilder workUnitDetail = new StringBuilder();

        while (workUnitSum > 0 && index < 100) {
            if (request.getParameter("workUnit" + index) != null) {
                workUnitDetail.append(request.getParameter("workUnit" + index) + ";");
            }
            index ++;
        }
        project.setWorkUnits(workUnitDetail.toString());


        // 将数据更新到数据库中
        rService.updateResearchProject(project);
//        System.out.println(project);

    }
}
