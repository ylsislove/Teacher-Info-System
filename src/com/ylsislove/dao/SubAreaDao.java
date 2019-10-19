package com.ylsislove.dao;

import com.ylsislove.model.research.SubArea;
import com.ylsislove.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;

/**
 * TODO
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/15 18:06
 */
public class SubAreaDao {

    public void addSubArea(SubArea subArea) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "insert into cug_paper_subarea(name, level) values(?,?)";
        r.update(sql, subArea.getName(), subArea.getLevel());
    }

    public SubArea selectSubArea(String name) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from cug_paper_subarea where name = ?";
        return r.query(sql, new BeanHandler<SubArea>(SubArea.class), name);
    }

    public boolean isSubAreaExist(String name) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from cug_paper_subarea where name = ?";
        SubArea subArea = r.query(sql, new BeanHandler<SubArea>(SubArea.class), name);
        return subArea != null;
    }

    public void updateSubArea(SubArea subArea) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "update cug_paper_subarea set level = ? " +
                "where name = ?";
        r.update(sql, subArea.getLevel(), subArea.getName());
    }

    public void deleteAll() throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "delete from cug_paper_subarea";
        r.update(sql);
    }

}
