package com.ylsislove.dao;

import com.ylsislove.model.ScientificPaper;
import com.ylsislove.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author Apple_Coco
 * @version V1.0 2019/9/28 21:53
 */
public class ScientificPaperDao {

    public List getScientificPaperPage(int type, int pageNo, int pageSize) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from paper where type = ? limit ?, ?";
        return r.query(sql, new BeanListHandler<ScientificPaper>(ScientificPaper.class), type, (pageNo-1)*pageSize, pageSize);
    }

    public ScientificPaper selectScientificPaperPageById(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from paper where id = ?";
        return r.query(sql, new BeanHandler<ScientificPaper>(ScientificPaper.class), id);
    }

    public int selectScientificPaperCount(int type) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select count(*) from paper where type = ?";
        return r.query(sql, new ScalarHandler<Long>(), type).intValue();
    }

}
