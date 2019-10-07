package com.ylsislove.dao;

import com.ylsislove.model.Undergraduate;
import com.ylsislove.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Description 和本科生管理相关的数据库操作
 * @ClassName UndergraduateDao
 * @Author Apple_Coco
 * @Date 2019/9/8 3:54
 * @Version V1.0
 */
public class UndergraduateDao {

    public void addUndergraduate(Undergraduate u) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "insert into undergraduate(userId, time, stuNum, " +
                "stuName, weekNum, type) values(?,?,?,?,?,?)";
        r.update(sql, u.getUserId(), u.getTime(), u.getStuNum(),
                u.getStuName(), u.getWeekNum(), u.getType());
    }

    public List<Map<String, Object>> getUndergraduatePage(int type, int pageNo, int pageSize) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select un.id, u.userId, u.username, " +
                "un.time, un.stuNum, un.stuName, un.weekNum " +
                "from user u, undergraduate un " +
                "where un.type = ? and un.userId = u.userId limit ?, ?";
        return r.query(sql, new MapListHandler(), type, (pageNo-1)*pageSize, pageSize);
    }

    public List<Map<String, Object>> getUndergraduatePageByUserId(String userId, int type, int pageNo, int pageSize) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select un.id, u.userId, u.username, " +
                "un.time, un.stuNum, un.stuName, un.weekNum " +
                "from user u, undergraduate un " +
                "where un.userId = ? and un.type = ? and un.userId = u.userId limit ?, ?";
        return r.query(sql, new MapListHandler(), userId, type, (pageNo-1)*pageSize, pageSize);
    }

    public int selectUndergraduateCount(int type) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select count(*) from undergraduate where type = ?";
        return r.query(sql, new ScalarHandler<Long>(), type).intValue();
    }

    public int selectUndergraduateCountByUserId(String userId, int type) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select count(*) from undergraduate where userId = ? and type = ?";
        return r.query(sql, new ScalarHandler<Long>(), userId, type).intValue();
    }

    public Map<String, Object> selectUndergraduateById(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select un.id, u.userId, u.username, " +
                "un.time, un.stuNum, un.stuName, un.weekNum, un.type " +
                "from user u, undergraduate un " +
                "where un.id = ? and u.userId = un.userId";
        return r.query(sql, new MapHandler(), id);
    }

    public void updateUndergraduate(Undergraduate u) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "update undergraduate set time = ?, stuName = ?, stuNum = ?, weekNum = ? where id = ?";
        r.update(sql, u.getTime(), u.getStuName(), u.getStuNum(), u.getWeekNum(), u.getId());
    }

    public void delete(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "delete from undergraduate where id = ?";
        r.update(sql, id);
    }

    public List getUndergraduateByUserId(String userId) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from undergraduate where userId = ?";
        return r.query(sql, new BeanListHandler<Undergraduate>(Undergraduate.class), userId);
    }

    /**
     * 管理员搜索模式
     */
    public int getSearchCount(String keyword, int type) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select count(*) from user u, undergraduate un " +
                "where un.type = ? and un.userId = u.userId and " +
                "(u.userId like ? or u.username like ? or un.time like ? or " +
                "un.stuName like ?)";
        return r.query(sql, new ScalarHandler<Long>(), type,
                "%"+keyword+"%", "%"+keyword+"%",
                "%"+keyword+"%", "%"+keyword+"%").intValue();
    }

    public List<Map<String, Object>> selectSearchKeyword(String keyword, int type, int pageNo, int pageSize) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select un.id, u.userId, u.username, " +
                "un.time, un.stuNum, un.stuName, un.weekNum " +
                "from user u, undergraduate un " +
                "where un.type = ? and un.userId = u.userId and " +
                "(u.userId like ? or u.username like ? or un.time like ? or " +
                "un.stuName like ?) " +
                "limit ?, ?";
        return r.query(sql, new MapListHandler(), type,
                "%"+keyword+"%", "%"+keyword+"%", "%"+keyword+"%",
                "%"+keyword+"%",
                (pageNo-1)*pageSize, pageSize);
    }

    /**
     * 普通用户搜索模式
     */
    public int getSearchCountByUserId(String keyword, int type, String userId) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select count(*) from user u, undergraduate un " +
                "where un.type = ? and u.userId = ? and un.userId = u.userId and " +
                "(u.userId like ? or u.username like ? or un.time like ? or " +
                "un.stuName like ?)";
        return r.query(sql, new ScalarHandler<Long>(), type, userId,
                "%"+keyword+"%", "%"+keyword+"%",
                "%"+keyword+"%", "%"+keyword+"%").intValue();
    }

    public List<Map<String, Object>> selectSearchKeywordByUserId(String keyword, int type, String userId, int pageNo, int pageSize) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select un.id, u.userId, u.username, " +
                "un.time, un.stuNum, un.stuName, un.weekNum " +
                "from user u, undergraduate un " +
                "where un.type = ? and u.userId = ? and un.userId = u.userId and " +
                "(u.userId like ? or u.username like ? or un.time like ? or " +
                "un.stuName like ?) " +
                "limit ?, ?";
        return r.query(sql, new MapListHandler(), type, userId,
                "%"+keyword+"%", "%"+keyword+"%", "%"+keyword+"%",
                "%"+keyword+"%",
                (pageNo-1)*pageSize, pageSize);
    }

}
