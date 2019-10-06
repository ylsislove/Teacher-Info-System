package com.ylsislove.dao;

import com.ylsislove.model.research.ResearchProject;
import com.ylsislove.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * TODO
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/6 13:51
 */
public class ResearchProjectDao {

    public List getProjectPage(int type, int pageNo, int pageSize) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from project where type = ? limit ?, ?";
        return r.query(sql, new BeanListHandler<ResearchProject>(ResearchProject.class), type, (pageNo-1)*pageSize, pageSize);
    }

    public ResearchProject selectProjectPageById(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from project where id = ?";
        return r.query(sql, new BeanHandler<ResearchProject>(ResearchProject.class), id);
    }

    public int selectProjectCount(int type) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select count(*) from project where type = ?";
        return r.query(sql, new ScalarHandler<Long>(), type).intValue();
    }

}
