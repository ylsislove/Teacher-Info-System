package com.ylsislove.servlet.research.paper;

import com.ylsislove.model.dto.Author;
import com.ylsislove.model.dto.Unit;
import com.ylsislove.model.research.ScientificPaper;
import com.ylsislove.service.research.ScientificPaperService;

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
 * @version V1.0 2019/10/7 0:24
 */
@WebServlet(value = "/scientificPaperEditShow.action")
public class ScientificPaperEditShowServlet extends HttpServlet {

    private ScientificPaperService sService = new ScientificPaperService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        ScientificPaper paper = sService.selectScientificPaperById(id);
        request.setAttribute("paper", paper);

        // 回显作者详情
        String authorDetail = paper.getAuthors();
        List<Author> authorList = new ArrayList<Author>();
        if (authorDetail == null) {
            authorList.add(new Author("", "", "", ""));
        }
        else {
            String[] items = authorDetail.split(";");
            for (String item : items) {
                String[] str = item.split("&");
                Author author = new Author(str[0], str[1], str[2], str[3]);
                if ("blank".equals(str[3])) {
                    author.setUserId("");
                }
                authorList.add(author);
            }
        }
        request.setAttribute("authorList", authorList);

        // 回显完成单位详情
        String unitDetail = paper.getWorkUnits();
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

        request.getRequestDispatcher("/research/scientific-paper-edit.jsp").forward(request, response);

    }
}
