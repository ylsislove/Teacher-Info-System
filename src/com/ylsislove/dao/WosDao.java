package com.ylsislove.dao;

import com.ylsislove.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

/**
 * TODO
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/22 18:00
 */
public class WosDao {

    public String getUrl() throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from wos_url";
        return r.query(sql, new ScalarHandler<String>());
    }

    public void updateUrl(String url) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "update wos_url set url = ?";
        r.update(sql, url);
    }

}
