package com.ylsislove.servlet.postgraduate;

import com.ylsislove.model.dto.Student;
import com.ylsislove.service.PostgraduateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description 处理编辑研究生指导条目的回显
 * @ClassName PostgraduateEditShowServlet
 * @Author Apple_Coco
 * @Date 2019/9/10 2:13
 * @Version V1.0
 */
@WebServlet(value = "/postgraduateEditShow.action")
public class PostgraduateEditShowServlet extends HttpServlet {

    private PostgraduateService pService = new PostgraduateService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        Map<String, Object> map = pService.selectPostgraduateById(id);
        request.setAttribute("map", map);

        // 回显研究生详情
        String stuDetail = (String) map.get("stuDetail");
        List<Student> stuList = new ArrayList<Student>();
        if (stuDetail == null) {
            stuList.add(new Student("", "", "", "", ""));
        }
        else {
            String[] items = stuDetail.split(";");
            for (String item : items) {
                String[] str = item.split("\\|");
                List<String> t = new ArrayList<>(5);
                t.add(str[0]);
                t.add(str.length > 1 ? str[1] : "");
                t.add(str.length > 2 ? str[2] : "");
                t.add(str.length > 3 ? str[3] : "");
                t.add(str.length > 4 ? str[4] : "");
                Student student = new Student(t.get(0), t.get(1), t.get(2), t.get(3), t.get(4));
                stuList.add(student);
            }
        }
        request.setAttribute("stuList", stuList);

        request.getRequestDispatcher("/admin/postgraduate-edit.jsp").forward(request, response);
    }
}
