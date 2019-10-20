package com.ylsislove.servlet.research.patent;

import com.alibaba.fastjson.JSON;
import com.ylsislove.model.research.Patent;
import com.ylsislove.service.research.PatentService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * 专利批量导入
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/9 16:21
 */
@WebServlet(value = "/patentUpload.action")
public class PatentUploadServlet extends HttpServlet {

    private PatentService pService = new PatentService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // 取得数据
        String json = request.getParameter("data");

        Map map = (Map) JSON.parseObject(json, Map.class).get("0");
        for (Object o : map.keySet()) {
            List list = (List)(map.get(o));
            int i = 0;
            for (Object o1 : list) {
                // 跳过第一轮的Excel表头
                if (++i == 1) {
                    continue;
                }
                Patent patent = new Patent();
                try {
                    BeanUtils.copyProperties(patent, o1);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                System.out.println("批量上传专利条目：" + patent);
                pService.addPatent(patent);
            }
        }

    }
}
