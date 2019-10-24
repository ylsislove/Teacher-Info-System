package com.ylsislove.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 解决所有直接跳转jsp异常的现象
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/24 21:56
 */
@WebServlet(value = "/main.action")
public class MainServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String page = request.getParameter("page");

        switch (page) {
            case "member-add":
                request.getRequestDispatcher("/admin/member-add.jsp").forward(request, response);
                break;
            case "member-upload":
                request.getRequestDispatcher("/admin/member-upload.jsp").forward(request, response);
                break;
            case "teaching-add":
                request.getRequestDispatcher("/admin/teaching-add.jsp").forward(request, response);
                break;
            case "teaching-upload":
                request.getRequestDispatcher("/admin/teaching-upload.jsp").forward(request, response);
                break;
            case "undergraduate-add":
                request.getRequestDispatcher("/admin/undergraduate-add.jsp").forward(request, response);
                break;
            case "undergraduate-upload":
                request.getRequestDispatcher("/admin/undergraduate-upload.jsp").forward(request, response);
                break;
            case "postgraduate-add":
                request.getRequestDispatcher("/admin/postgraduate-add.jsp").forward(request, response);
                break;
            case "postgraduate-upload":
                request.getRequestDispatcher("/admin/postgraduate-upload.jsp").forward(request, response);
                break;
            case "award-add":
                request.getRequestDispatcher("/research/award-add.jsp").forward(request, response);
                break;
            case "awards-upload":
                request.getRequestDispatcher("/research/awards-upload.jsp").forward(request, response);
                break;
            case "patent-add":
                request.getRequestDispatcher("/research/patent-add.jsp").forward(request, response);
                break;
            case "patents-upload":
                request.getRequestDispatcher("/research/patents-upload.jsp").forward(request, response);
                break;
            case "research-project-add":
                request.getRequestDispatcher("/research/research-project-add.jsp").forward(request, response);
                break;
            case "research-project-upload":
                request.getRequestDispatcher("/research/research-project-upload.jsp").forward(request, response);
                break;
            case "scientific-paper-add":
                request.getRequestDispatcher("/research/scientific-paper-add.jsp").forward(request, response);
                break;
            case "scientific-paper-upload":
                request.getRequestDispatcher("/research/scientific-paper-upload.jsp").forward(request, response);
                break;
            case "spaper-update-msg":
                request.getRequestDispatcher("/research/spaper-update-msg.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("/login.jsp").forward(request, response);
                break;
        }

    }
}
