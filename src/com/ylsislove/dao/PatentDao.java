package com.ylsislove.dao;

import com.ylsislove.model.research.Patent;
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
public class PatentDao {

    public void addPatent(Patent patent) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "insert into patent(applicationDate, authorizationDate, patentId, " +
                "patentType, level, title, inventors) values(?,?,?,?,?,?,?)";
        r.update(sql, patent.getApplicationDate(), patent.getAuthorizationDate(), patent.getPatentId(),
                patent.getPatentType(), patent.getLevel(), patent.getTitle(), patent.getInventors());
    }

    public void updatePatent(Patent patent) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "update patent set applicationDate = ?, authorizationDate = ?, patentId = ?, " +
                "patentType = ?, level = ?, title = ?, inventors = ? where id = ?";
        r.update(sql, patent.getApplicationDate(), patent.getAuthorizationDate(), patent.getPatentId(),
                patent.getPatentType(), patent.getLevel(), patent.getTitle(), patent.getInventors(),
                patent.getId());
    }

    public List getPatentPage(int pageNo, int pageSize) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from patent limit ?, ?";
        return r.query(sql, new BeanListHandler<Patent>(Patent.class), (pageNo-1)*pageSize, pageSize);
    }

    public Patent selectPatentById(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from patent where id = ?";
        return r.query(sql, new BeanHandler<Patent>(Patent.class), id);
    }

    public int selectPatentCount() throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select count(*) from patent";
        return r.query(sql, new ScalarHandler<Long>()).intValue();
    }

    public void delete(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "delete from patent where id = ?";
        r.update(sql, id);
    }

    public List getPatentPageByUserId(String userId, int pageNo, int pageSize) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from patent where inventors like ? limit ?, ?";
        return r.query(sql, new BeanListHandler<Patent>(Patent.class), "%"+userId+"%", (pageNo-1)*pageSize, pageSize);
    }

    public int selectPatentCountByUserId(String userId) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select count(*) from patent where inventors like ?";
        return r.query(sql, new ScalarHandler<Long>(), "%"+userId+"%").intValue();
    }

}
