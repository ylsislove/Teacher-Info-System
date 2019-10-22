package com.ylsislove.service.research;

import com.ylsislove.dao.WosDao;

import java.sql.SQLException;

/**
 * TODO
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/22 18:01
 */
public class WosService {

    private WosDao wosDao = new WosDao();

    public String getUrl() {
        String url = null;
        try {
            url = wosDao.getUrl();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return url;
    }

    public void updateUrl(String url) {
        try {
            wosDao.updateUrl(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
