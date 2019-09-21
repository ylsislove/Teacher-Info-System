package com.ylsislove.servlet;

import com.ylsislove.model.User;
import com.ylsislove.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description TODO
 * @ClassName ExperienceEditServlet
 * @Author Apple_Coco
 * @Date 2019/9/20 23:00
 * @Version V1.0
 */
@WebServlet(value = "/experienceEdit.action")
public class ExperienceEditServlet extends HttpServlet {

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
        // 获取到条目数量
        int sum = Integer.parseInt(request.getParameter("sum"));
        int index = 1;
        StringBuilder experience = new StringBuilder();

        // 保存教育经历
        if (type == 1) {
            while (sum > 0 && index < 100) {
                if (request.getParameter("academicDate" + index) == null) {
                    index ++;
                    continue;
                }
                experience.append(request.getParameter("academicDate" + index) + "&");
                experience.append(request.getParameter("graduationDate" + index) + "&");
                experience.append(request.getParameter("schoolName" + index) + "&");
                experience.append("".equals(request.getParameter("majorName" + index)) ? "blank&" : request.getParameter("majorName" + index) + "&");
                experience.append("".equals(request.getParameter("tutorName" + index)) ? "blank" : request.getParameter("tutorName" + index));
                experience.append(";");
                index ++;
                sum --;
            }
            uService.updateEduExperience(experience.toString(), user.getUserId());

        }
        // 保存出国经历
        else if (type == 2) {
            while (sum > 0 && index < 100) {
                if (request.getParameter("abroadDate" + index) == null) {
                    index ++;
                    continue;
                }
                experience.append(request.getParameter("abroadDate" + index) + "&");
                experience.append(request.getParameter("backDate" + index) + "&");
                experience.append(request.getParameter("departmentName" + index) + "&");
                experience.append("".equals(request.getParameter("majorName" + index)) ? "blank&" : request.getParameter("majorName" + index) + "&");
                experience.append("".equals(request.getParameter("tutorName" + index)) ? "blank" : request.getParameter("tutorName" + index));
                experience.append(";");
                index ++;
                sum --;
            }
            uService.updateAbroadExperience(experience.toString(), user.getUserId());

        }
        // 保存工作经历
        else if (type == 3) {
            while (sum > 0 && index < 100) {
                if (request.getParameter("workDate" + index) == null) {
                    index ++;
                    continue;
                }
                experience.append(request.getParameter("workDate" + index) + "&");
                experience.append(request.getParameter("leaveDate" + index) + "&");
                experience.append(request.getParameter("departmentName" + index) + "&");
                experience.append("".equals(request.getParameter("workName" + index)) ? "blank" : request.getParameter("workName" + index));
                experience.append(";");
                index ++;
                sum --;
            }
            uService.updateWorkExperience(experience.toString(), user.getUserId());
        }

    }
}
