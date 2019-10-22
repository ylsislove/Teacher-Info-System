package com.ylsislove.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/22 20:48
 */
public class DateUtil {

    public static String getTimes() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return format.format(date);
    }

}
