package com.ylsislove.servlet.research.patent;

import com.ylsislove.model.dto.Inventor;
import com.ylsislove.model.research.Patent;
import com.ylsislove.service.research.PatentService;

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
 * @version V1.0 2019/10/6 15:04
 */
@WebServlet(value = "/patentDetail.action")
public class PatentDetailServlet extends HttpServlet {

    private PatentService pService = new PatentService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        Patent patent = pService.selectPatentById(id);
        request.setAttribute("patent", patent);

        // 回显发明人详情
        String inventorDetail = patent.getInventors();
        List<Inventor> inventorList = new ArrayList<Inventor>();
        if (inventorDetail == null) {
            inventorList.add(new Inventor("", "", "", ""));
        }
        else {
            String[] items = inventorDetail.split(";");
            for (String item : items) {
                String[] str = item.split("\\|");
                List<String> t = new ArrayList<>(4);
                t.add(str[0]);
                t.add(str.length > 1 ? str[1] : "");
                t.add(str.length > 2 ? str[2] : "");
                t.add(str.length > 3 ? str[3] : "");
                Inventor inventor = new Inventor(t.get(0), t.get(1), t.get(2), t.get(3));
                if ("null".equals(t.get(1))) {
                    inventor.setInventorUnit("");
                }
                if ("null".equals(t.get(3))) {
                    inventor.setUserId("");
                }
                inventorList.add(inventor);
            }
        }
        request.setAttribute("inventorList", inventorList);

        // 请求转发
        request.getRequestDispatcher("/research/patent-detail.jsp").forward(request, response);

    }
}
