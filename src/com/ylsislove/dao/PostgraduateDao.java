package com.ylsislove.dao;

import com.ylsislove.model.Postgraduate;
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
 * @Description 和研究生管理相关的数据库操作
 * @ClassName PostgraduateDao
 * @Author Apple_Coco
 * @Date 2019/9/8 12:36
 * @Version V1.0
 */
public class PostgraduateDao {

    public void addPostgraduate(Postgraduate p) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "insert into postgraduate(academicDate, userId, stuNum, stuDetail) values(?,?,?,?)";
        r.update(sql, p.getacademicDate(), p.getUserId(), p.getStuNum(), p.getStuDetail());
    }

    public List<Map<String, Object>> getPostgraduatePage(int pageNo, int pageSize) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select p.id, p.academicDate, u.userId, u.username, p.stuNum, p.stuDetail " +
                "from user u, postgraduate p where p.userId = u.userId " +
                "order by u.username, p.academicDate limit ?, ?";
        return r.query(sql, new MapListHandler(), (pageNo-1)*pageSize, pageSize);
    }

    public List<Map<String, Object>> getPostgraduatePageByUserId(String userId, int pageNo, int pageSize) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select p.id, p.academicDate, u.userId, u.username, p.stuNum, p.stuDetail " +
                "from user u, postgraduate p where p.userId = ? and p.userId = u.userId " +
                "order by p.academicDate limit ?, ?";
        return r.query(sql, new MapListHandler(), userId, (pageNo-1)*pageSize, pageSize);
    }

    public int selectPostgraduateCount() throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select count(*) from postgraduate";
        return r.query(sql, new ScalarHandler<Long>()).intValue();
    }

    public int selectPostgraduateCountByUserId(String userId) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select count(*) from postgraduate where userId = ?";
        return r.query(sql, new ScalarHandler<Long>(), userId).intValue();
    }

    public Map<String, Object> selectPostgraduateById(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select p.id, p.academicDate, u.userId, u.username, " +
                "p.stuNum, p.stuDetail from user u, postgraduate p " +
                "where p.id = ? and u.userId = p.userId";
        return r.query(sql, new MapHandler(), id);
    }

    public void updatePostgraduate(Postgraduate p) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "update postgraduate set academicDate = ?, stuNum = ?, stuDetail = ? where id = ?";
        r.update(sql, p.getacademicDate(), p.getStuNum(), p.getStuDetail(), p.getId());
    }

    public void delete(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "delete from postgraduate where id = ?";
        r.update(sql, id);
    }

    public List getPostgraduateByUserId(String userId) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from postgraduate where userId = ?";
        return r.query(sql, new BeanListHandler<Postgraduate>(Postgraduate.class), userId);
    }

    /**
     * 管理员搜索模式
     */
    public int getSearchCount(String keyword) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select count(*) from user u, postgraduate p " +
                "where p.userId = u.userId and " +
                "(u.userId like ? or u.username like ? or p.academicDate like ?)";
        return r.query(sql, new ScalarHandler<Long>(),
                "%"+keyword+"%", "%"+keyword+"%", "%"+keyword+"%").intValue();
    }

    public List<Map<String, Object>> selectSearchKeyword(String keyword, int pageNo, int pageSize) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select p.id, p.academicDate, u.userId, u.username, p.stuNum, p.stuDetail "+
                "from user u, postgraduate p " +
                "where p.userId = u.userId and " +
                "(u.userId like ? or u.username like ? or p.academicDate like ?)" +
                "limit ?, ?";
        return r.query(sql, new MapListHandler(),
                "%"+keyword+"%", "%"+keyword+"%", "%"+keyword+"%",
                (pageNo-1)*pageSize, pageSize);
    }

    /**
     * 普通用户搜索模式
     */
    public int getSearchCountByUserId(String keyword, String userId) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select count(*) from user u, postgraduate p " +
                "where p.userId = u.userId and u.userId = ? and " +
                "(u.userId like ? or u.username like ? or p.academicDate like ?)";
        return r.query(sql, new ScalarHandler<Long>(), userId,
                "%"+keyword+"%", "%"+keyword+"%", "%"+keyword+"%").intValue();
    }

    public List<Map<String, Object>> selectSearchKeywordByUserId(String keyword, String userId, int pageNo, int pageSize) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select p.id, p.academicDate, u.userId, u.username, p.stuNum, p.stuDetail "+
                "from user u, postgraduate p " +
                "where p.userId = u.userId and u.userId = ? and " +
                "(u.userId like ? or u.username like ? or p.academicDate like ?)" +
                "limit ?, ?";
        return r.query(sql, new MapListHandler(), userId,
                "%"+keyword+"%", "%"+keyword+"%", "%"+keyword+"%",
                (pageNo-1)*pageSize, pageSize);
    }
}
