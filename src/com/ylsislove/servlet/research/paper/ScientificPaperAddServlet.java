package com.ylsislove.servlet.research.paper;

import com.ylsislove.model.research.ScientificPaper;
import com.ylsislove.service.research.ScientificPaperService;
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
 * 接收表单信息
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/6 19:15
 */
@WebServlet(value = "/scientificPaperAdd.action")
public class ScientificPaperAddServlet extends HttpServlet {

    private ScientificPaperService sService = new ScientificPaperService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // 填充基本信息
        ScientificPaper paper = new ScientificPaper();
        try {
            BeanUtils.copyProperties(paper, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        // 获取到作者信息
        int authorSum = Integer.parseInt(request.getParameter("authorSum"));
        int index = 1;
        StringBuilder authorDetail = new StringBuilder();

        while (authorSum > 0 && index < 100) {
            if (request.getParameter("authorName" + index) == null) {
                index ++;
                continue;
            }
            authorDetail.append(request.getParameter("authorName" + index) + "&");
            authorDetail.append(request.getParameter("mask" + index) + "&");
            authorDetail.append(request.getParameter("isOurTeacher" + index) + "&");
            // TODO 如果是我院教师的话，查询其英文名，若查询结果只有一个，自动关联其教师工号

            authorDetail.append("".equals(request.getParameter("userId" + index)) ? "blank" : request.getParameter("userId" + index));
            authorDetail.append(";");
            index ++;
        }
        paper.setAuthors(authorDetail.toString());

        // 获取到完成单位信息
        int workUnitSum = Integer.parseInt(request.getParameter("workUnitSum"));
        index = 1;
        StringBuilder workUnitDetail = new StringBuilder();

        while (workUnitSum > 0 && index < 100) {
            if (request.getParameter("workUnit" + index) != null) {
                workUnitDetail.append(request.getParameter("workUnit" + index) + ";");
            }
            index ++;
        }
        paper.setWorkUnits(workUnitDetail.toString());

        // TODO 自动获取到论文分区


        // TODO 自动获取到引用次数


        // 将数据保存到数据库中
        sService.addScientificPaper(paper);
//        System.out.println(paper);

    }
}
