package com.ylsislove.dao;

import com.ylsislove.model.research.Award;
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
 * @version V1.0 2019/9/29 23:58
 */
public class AwardDao {

    public void addAward(Award award) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "insert into award(date, title, grade, level, unit, winners, type) " +
                "values(?,?,?,?,?,?,?)";
        r.update(sql, award.getDate(), award.getTitle(), award.getGrade(), award.getLevel(),
                award.getUnit(), award.getWinners(), award.getType());
    }

    public void updateAward(Award award) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "update award set date = ?, title = ?, grade = ?, level = ?, unit = ?, " +
                "winners = ?, type = ? where id = ?";
        r.update(sql, award.getDate(), award.getTitle(), award.getGrade(), award.getLevel(),
                award.getUnit(), award.getWinners(), award.getType(), award.getId());
    }

    public List getAwardPage(int type, int pageNo, int pageSize) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from award where type = ? limit ?, ?";
        return r.query(sql, new BeanListHandler<Award>(Award.class), type, (pageNo-1)*pageSize, pageSize);
    }

    public Award selectAwardById(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from award where id = ?";
        return r.query(sql, new BeanHandler<Award>(Award.class), id);
    }

    public int selectAwardCount(int type) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select count(*) from award where type = ?";
        return r.query(sql, new ScalarHandler<Long>(), type).intValue();
    }

    public void delete(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "delete from award where id = ?";
        r.update(sql, id);
    }

}
