package com.ylsislove.servlet;

import com.ylsislove.model.experience.AbroadExperience;
import com.ylsislove.model.experience.EduExperience;
import com.ylsislove.model.User;
import com.ylsislove.model.experience.WorkExperience;
import com.ylsislove.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 在编辑界面回显经历
 * @ClassName ExperienceEditShowServlet
 * @Author Apple_Coco
 * @Date 2019/9/19 18:46
 * @Version V1.0
 */
@WebServlet(value = "/experienceEditShow.action")
public class ExperienceEditShowServlet extends HttpServlet {

    private UserService uService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // 获取当前用户
        User user = (User) request.getSession().getAttribute("user");
        // 获取经历类别
        int type = Integer.parseInt(request.getParameter("type"));

        // 回显教育经历
        if (type == 1) {
            String eduString = uService.selectEduExperienceByUserId(user.getUserId());
            List<EduExperience> eduList = new ArrayList<EduExperience>();
            if (eduString == null) {
                eduList.add(new EduExperience("", "", "", "", ""));
            }
            else {
                String[] items = eduString.split(";");
                for (String item : items) {
                    String[] str = item.split("&");
                    EduExperience eduExperience = new EduExperience(str[0], str[1], str[2], str[3], str[4]);
                    if ("blank".equals(str[3])) {
                        eduExperience.setMajorName("");
                    }
                    if ("blank".equals(str[4])) {
                        eduExperience.setTutorName("");
                    }
                    eduList.add(eduExperience);
                }
            }
            request.setAttribute("eduList", eduList);
            request.getRequestDispatcher("/teacher/experience-edu-edit.jsp").forward(request, response);

        }
        // 回显留学经历
        else if (type == 2) {
            String abroadString = uService.selectAbroadExperienceByUserId(user.getUserId());
            List<AbroadExperience> abroadList = new ArrayList<AbroadExperience>();
            if (abroadString == null) {
                abroadList.add(new AbroadExperience("", "", "", "", ""));
            }
            else {
                String[] items = abroadString.split(";");
                for (String item : items) {
                    String[] str = item.split("&");
                    AbroadExperience abroadExperience = new AbroadExperience(str[0], str[1], str[2], str[3], str[4]);
                    if ("blank".equals(str[3])) {
                        abroadExperience.setMajorName("");
                    }
                    if ("blank".equals(str[4])) {
                        abroadExperience.setTutorName("");
                    }
                    abroadList.add(abroadExperience);
                }
            }
            request.setAttribute("abroadList", abroadList);
            request.getRequestDispatcher("/teacher/experience-abroad-edit.jsp").forward(request, response);

        }
        // 回显工作经历
        else if (type == 3) {
            String workString = uService.selectWorkExperienceByUserId(user.getUserId());
            List<WorkExperience> workList = new ArrayList<WorkExperience>();
            if (workString == null) {
                workList.add(new WorkExperience("", "", "", ""));
            }
            else {
                String[] items = workString.split(";");
                for (String item : items) {
                    String[] str = item.split("&");
                    WorkExperience workExperience = new WorkExperience(str[0], str[1], str[2], str[3]);
                    if ("blank".equals(str[3])) {
                        workExperience.setWorkName("");
                    }
                    workList.add(workExperience);
                }
            }
            request.setAttribute("workList", workList);
            request.getRequestDispatcher("/teacher/experience-work-edit.jsp").forward(request, response);
        }

    }
}
