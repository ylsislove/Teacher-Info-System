package com.ylsislove.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 与论文相关的操作类
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/20 1:27
 */
public class PaperUtil {

    /**
     * 根据DOI得到引用次数
     * @param doi 要查询论文的doi号
     * @return -1 网络异常
     *         -2 参数异常
     *      非负数 查询成功
     */
    public static int getNum(String doi) {
        String res = "";
        BufferedReader br = null;
        try {
            String cmd = "python " + Constant.GET_NUM_PATH + " " + doi;
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

        if ("-1".equals(res)) {
            return -1;

        } else if ("参数过少".equals(res)) {
            return -2;

        } else {
            return Integer.parseInt(res.replace(",", ""));
        }
    }

    /**
     * 根据DOI得到机构名称+论文题目+作者+作者机构
     * @param doi 要查询论文的doi号
     * @return -1 网络异常
     *         -2 参数异常
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

        if ("-1".equals(res)) {
            return "-1";

        } else if ("参数过少".equals(res)) {
            return "-2";

        } else {
            return res;
        }
    }

}
