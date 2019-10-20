package com.ylsislove.servlet.research.paper;

import com.alibaba.fastjson.JSON;
import com.ylsislove.model.research.SubArea;
import com.ylsislove.service.research.SubAreaService;
import com.ylsislove.utils.Constant;
import com.ylsislove.utils.PaperUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * TODO
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/20 0:43
 */
@WebServlet(value = "/scientificPaperSearch.action")
public class ScientificPaperSearchServlet extends HttpServlet {

    private SubAreaService sService = new SubAreaService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String doi = request.getParameter("doi");
        String res = PaperUtil.getInfo(doi);
//        int res = 9999;
        System.out.println(res);
        switch (res) {
            case "-1":
                response.setStatus(1000);
                response.getWriter().write("网络异常");
                break;
            case "-2":
                response.setStatus(1001);
                response.getWriter().write("请求的参数异常");
                break;
            default:
                response.setStatus(200);
                String[] split = res.split("%");
                List<String> list = new ArrayList<>();
                list.add(split.length > 0 ? split[0] : "");
                list.add(split.length > 1 ? split[1] : "");
                list.add(split.length > 2 ? split[2] : "");
                list.add(split.length > 3 ? split[3] : "");
                list.add(split.length > 4 ? split[4] : "");
                Map<String, Object> map = new HashMap<>(5);
                // 封装期刊全称，论文标题，工作单位
                map.put("journalFullName", list.get(0));
                map.put("title", list.get(2));
                map.put("workUnits", list.get(3));
                // 封装引用次数
                int citeNum = 0;
                try {
                    citeNum = Integer.parseInt(list.get(4).replace(",",""));
                } catch (Exception e) {
                    citeNum = 0;
                }
                map.put("citeNum", citeNum);
                // 封装作者
                String[] str = list.get(1).split(";");
                List<String> authors = new ArrayList<>(Arrays.asList(str));
                map.put("authors", authors);
                // 根据期刊全称得到论文分区
                SubArea subArea = sService.selectSubArea(list.get(0));
                map.put("subarea", subArea == null ? "" : subArea.getLevel());

                response.getWriter().print(JSON.toJSON(map));
                break;
        }
    }
}
