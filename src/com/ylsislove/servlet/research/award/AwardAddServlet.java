package com.ylsislove.servlet.research.award;

import com.ylsislove.model.research.Award;
import com.ylsislove.service.research.AwardService;
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
 * @version V1.0 2019/10/6 19:25
 */
@WebServlet(value = "/awardAdd.action")
public class AwardAddServlet extends HttpServlet {

    private AwardService aService = new AwardService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // 填充基本信息
        Award award = new Award();
        try {
            BeanUtils.copyProperties(award, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        // 获取到获奖人信息
        int winnerSum = Integer.parseInt(request.getParameter("winnerSum"));
        int index = 1;
        StringBuilder winnerDetail = new StringBuilder();

        while (winnerSum > 0 && index < 100) {
            if (request.getParameter("winnerName" + index) == null) {
                index ++;
                continue;
            }
            winnerDetail.append(request.getParameter("winnerName" + index) + "&");
            winnerDetail.append(request.getParameter("isOurTeacher" + index) + "&");
            // TODO 如果是我院教师的话，查询其中文名，若查询结果只有一个，自动关联其教师工号

            winnerDetail.append("".equals(request.getParameter("userId" + index)) ? "blank" : request.getParameter("userId" + index));
            winnerDetail.append(";");
            index ++;
        }
        award.setWinners(winnerDetail.toString());

        // 将数据保存到数据库中
        aService.addAward(award);
//        System.out.println(award);

    }
}
