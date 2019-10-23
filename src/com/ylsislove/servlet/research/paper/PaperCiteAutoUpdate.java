package com.ylsislove.servlet.research.paper;

import com.ylsislove.service.research.ScientificPaperService;
import com.ylsislove.utils.DateUtil;
import com.ylsislove.utils.PaperUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * TODO
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/22 18:28
 */
public class PaperCiteAutoUpdate {

    private static ScientificPaperService sService = new ScientificPaperService();

    private static ScheduledThreadPoolExecutor stp = null;

    private static class MyTask implements Runnable {
        @Override
        public void run() {
            // 查询待更新的论文的doi号
            Map<String, Object> paper = sService.selectPaperRequireUpdate();

            if (paper != null) {
                Map<String, String> map = new HashMap<>();
                String doi = (String) paper.get("doiNum");
                int oldCite = (int) paper.get("citeNum");
                // 查询引用次数
                int cite = PaperUtil.getNum(doi);

                // 网络异常
                if (cite == -1) {
                    map.put("type", "alerted");
                    map.put("doi", doi);

                } else {
                    sService.updatePaperCite(doi, cite, DateUtil.getTimes());
                    map.put("type", "notice");
                    map.put("doi", doi);
                    map.put("oldCite", ""+oldCite);
                    map.put("cite", ""+cite);
                    map.put("updateTime", DateUtil.getTimes());
                }
                // 放入消息队列中
                PaperUtil.putMsg(map);

            } else {
                System.out.println(DateUtil.getTimes() + "：没有待更新的论文");
            }
        }
    }

    public static void updateStart() {
        stp = new ScheduledThreadPoolExecutor(5);
        MyTask mytask = new MyTask();
        stp.scheduleAtFixedRate(mytask, 1, 30, TimeUnit.SECONDS);
    }

    public static void updateShutdown() {
        stp.shutdown();
        stp = null;
    }

    public static boolean isTaskRunning() {
        return stp != null;
    }

}
