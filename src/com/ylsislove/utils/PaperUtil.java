package com.ylsislove.utils;

import com.ylsislove.service.research.WosService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 与论文相关的操作类
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/20 1:27
 */
public class PaperUtil {

    private static WosService wosService = new WosService();
    private static List<Map> list = new ArrayList<>(5);

    public static Map getMsg() {
        Map msg = null;
        if (list.size() > 0) {
            msg = list.remove(0);
        }
        return msg;
    }

    public static void putMsg(Map msg) {
        if (list.size() > 5) {
            list.remove(0);
        }
        list.add(msg);
    }

    public static boolean hasMsg() {
        return list.size() != 0;
    }

    /**
     * 根据DOI得到引用次数
     * @param doi 要查询论文的doi号
     * @return -1 网络异常
     *      非负数 查询成功
     */
    public static int getNum(String doi) {
        String res = "";
        BufferedReader br = null;
        try {
            String url = wosService.getUrl();
            System.out.println(wosService.getUrl());
            String cmd = "python " + Constant.GET_NUM_PATH + " " + doi + " " + url;
            // 执行dos命令并获取输出结果
            Process proc = Runtime.getRuntime().exec(cmd);
            br = new BufferedReader(new InputStreamReader(proc.getInputStream(), "GBK"));

            String line;
            while ((line = br.readLine()) != null) {
                res = line;
            }
            proc.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return Integer.parseInt(res.replace(",", ""));
    }

    /**
     * 根据DOI得到机构名称+论文题目+作者+作者机构
     * @param doi 要查询论文的doi号
     * @return -1 网络异常
     *      非负数 查询成功
     */
    public static String getInfo(String doi) {
        String res = "";
        BufferedReader br = null;
        try {
            String cmd = "python " + Constant.GET_INFO_PATH + " " + doi;
            // 执行dos命令并获取输出结果
            Process proc = Runtime.getRuntime().exec(cmd);
            br = new BufferedReader(new InputStreamReader(proc.getInputStream(), "GBK"));

            String line;
            while ((line = br.readLine()) != null) {
                res = line;
            }
            proc.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return res;
    }

}
