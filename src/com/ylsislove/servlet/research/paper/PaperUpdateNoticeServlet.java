package com.ylsislove.servlet.research.paper;

import com.alibaba.fastjson.JSON;
import com.ylsislove.service.research.ScientificPaperService;
import com.ylsislove.utils.PaperUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 接收前端论文更新数据请求，返回更新数据
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/22 16:04
 */
@WebServlet(value = "/paperUpdateNotice.action")
public class PaperUpdateNoticeServlet extends HttpServlet {

    private ScientificPaperService paperService = new ScientificPaperService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Map<String, String> map = new HashMap<>(6);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if (PaperUtil.hasMsg()) {

            Map msg = PaperUtil.getMsg();
            String createTime = format.format(new Date(System.currentTimeMillis()));

            response.setStatus(200);
            if ("alerted".equals(msg.get("type")) ) {
                map.put("code", "-1");
                map.put("title", "【警报】网络异常");
                map.put("content", "DOI：" + msg.get("doi") + " 更新失败");
                map.put("date", createTime);
                map.put("totalCount", paperService.selectPaperCount()+"");
                map.put("updateCount", paperService.selectPaperRequireUpdateCount()+"");
                response.getWriter().write(JSON.toJSONString(map));

            } else {
                // 论文总数

                map.put("code", "0");
                map.put("title", "【通知】论文引用次数更新");
                map.put("content", "DOI：" + msg.get("doi") + " 论文引用次数已更新，" +
                        msg.get("oldCite") + "->" + msg.get("cite"));
                map.put("date", createTime);
                map.put("totalCount", paperService.selectPaperCount()+"");
                map.put("updateCount", paperService.selectPaperRequireUpdateCount()+"");
                response.getWriter().write(JSON.toJSONString(map));
            }

        } else {
            Map<String, String> m = new HashMap<>(3);
            m.put("code", "1");
            m.put("totalCount", paperService.selectPaperCount()+"");
            m.put("updateCount", paperService.selectPaperRequireUpdateCount()+"");
            response.getWriter().write(JSON.toJSONString(m));
        }

    }
}
