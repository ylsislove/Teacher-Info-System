package com.ylsislove.servlet.research.award;

import com.ylsislove.model.dto.Winner;
import com.ylsislove.model.research.Award;
import com.ylsislove.service.research.AwardService;

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
 * @version V1.0 2019/9/30 0:03
 */
@WebServlet(value = "/awardDetail.action")
public class AwardDetailServlet extends HttpServlet {

    private AwardService aService = new AwardService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        Award award = aService.selectAwardById(id);
        request.setAttribute("award", award);

        // 回显获奖人详情
        String winnerDetail = award.getWinners();
        List<Winner> winnerList = new ArrayList<Winner>();
        if (winnerDetail == null) {
            winnerList.add(new Winner("", "", ""));
        }
        else {
            String[] items = winnerDetail.split(";");
            for (String item : items) {
                String[] str = item.split("\\|");
                List<String> t = new ArrayList<>(3);
                t.add(str[0]);
                t.add(str.length > 1 ? str[1] : "");
                t.add(str.length > 2 ? str[2] : "");
                Winner winner = new Winner(t.get(0), t.get(1), t.get(2));
                if ("null".equals(t.get(2))) {
                    winner.setUserId("");
                }
                winnerList.add(winner);
            }
        }
        request.setAttribute("winnerList", winnerList);

        // 请求转发
        request.getRequestDispatcher("/research/award-detail.jsp").forward(request, response);

    }
}
