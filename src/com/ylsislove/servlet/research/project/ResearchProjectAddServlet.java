package com.ylsislove.servlet.research.project;

import com.ylsislove.model.User;
import com.ylsislove.model.research.ResearchProject;
import com.ylsislove.service.UserService;
import com.ylsislove.service.research.ResearchProjectService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * TODO
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/6 19:25
 */
@WebServlet(value = "/researchProjectAdd.action")
public class ResearchProjectAddServlet extends HttpServlet {

    private ResearchProjectService rService = new ResearchProjectService();
    private UserService uService = new UserService();

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
            memberDetail.append(request.getParameter("memberName" + index) + "|");
            memberDetail.append(request.getParameter("isOurTeacher" + index) + "|");
            // 如果是我院教师的话，且管理员没有指定工号的话，查询其中文名，自动关联其教师工号
            if ("是".equals(request.getParameter("isOurTeacher" + index)) &&
                    "".equals(request.getParameter("userId" + index))) {
                User user = uService.searchUserIdByName(request.getParameter("memberName" + index));
                if (user == null) {
                    memberDetail.append("null");
                } else {
                    memberDetail.append(user.getUserId());
                }
            } else {
                memberDetail.append("".equals(request.getParameter("userId" + index)) ? "null" : request.getParameter("userId" + index));
            }
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


        // 将数据保存到数据库中
        rService.addResearchProject(project);
//        System.out.println(project);

    }
}
