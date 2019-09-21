package com.ylsislove.dao;

import com.ylsislove.model.Teaching;
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
 * @Description 和教学管理相关的数据库操作
 * @ClassName TeachingDao
 * @Author Apple_Coco
 * @Date 2019/9/7 14:32
 * @Version V1.0
 */
public class TeachingDao {

    public void addTeaching(Teaching t) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "insert into teaching(userId, courseId, classrooms, classNum, stuNum, groupNum, " +
                "courseRealHours, isEnglish, type) values(?,?,?,?,?,?,?,?,?)";
        r.update(sql, t.getUserId(), t.getCourseId(), t.getClassrooms(), t.getClassNum(), t.getStuNum(),
                t.getGroupNum(), t.getCourseRealHours(), t.getIsEnglish(), t.getType());
    }

    public List<Map<String, Object>> getTeachingPage(int type, int pageNo, int pageSize) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select t.id, u.userId, u.username, t.courseId, " +
                "c.courseTime, c.courseName, c.courseAttr, c.courseTotalHours, " +
                "t.courseRealHours, t.classrooms, t.classNum, t.stuNum, t.groupNum, t.isEnglish " +
                "from user u, course c, teaching t " +
                "where t.type = ? and u.userId = t.userId and c.id = t.courseId limit ?, ?";
        return r.query(sql, new MapListHandler(), type, (pageNo-1)*pageSize, pageSize);
    }

    public List<Map<String, Object>> getTeachingPageByUserId(String userId, int type, int pageNo, int pageSize) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select t.id, u.userId, u.username, t.courseId, " +
                "c.courseTime, c.courseName, c.courseAttr, c.courseTotalHours, " +
                "t.courseRealHours, t.classrooms, t.classNum, t.stuNum, t.groupNum, t.isEnglish " +
                "from user u, course c, teaching t " +
                "where t.userId = ? and t.type = ? and u.userId = t.userId and c.id = t.courseId limit ?, ?";
        return r.query(sql, new MapListHandler(), userId, type, (pageNo-1)*pageSize, pageSize);
    }

    public int selectTeachingCount(int type) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select count(*) from teaching where type = ?";
        return r.query(sql, new ScalarHandler<Long>(), type).intValue();
    }

    public int selectTeachingCountByUserId(String userId, int type) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select count(*) from teaching where userId = ? and type = ?";
        return r.query(sql, new ScalarHandler<Long>(), userId, type).intValue();
    }

    public Map<String, Object> selectTeachingById(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select t.id, u.userId, u.username, t.courseId, " +
                "c.courseTime, c.courseName, c.courseAttr, c.courseTotalHours, " +
                "t.courseRealHours, t.classrooms, t.classNum, t.stuNum, t.groupNum, t.isEnglish, t.type " +
                "from user u, course c, teaching t " +
                "where t.id = ? and u.userId = t.userId and c.id = t.courseId";
        return r.query(sql, new MapHandler(), id);
    }

    public void updateTeaching(Teaching p) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "update teaching set courseId = ?, classrooms = ?, classNum = ?, stuNum = ?, groupNum = ?, " +
                "courseRealHours = ?, isEnglish = ? where id = ?";
        r.update(sql, p.getCourseId(), p.getClassrooms(), p.getClassNum(), p.getStuNum(),
                p.getGroupNum(), p.getCourseRealHours(), p.getIsEnglish(), p.getId());
    }

    public void delete(int teachingId) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "delete from teaching where id = ?";
        r.update(sql, teachingId);
    }

    public int selectCourseCount(String courseId) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select count(*) from teaching where courseId = ?";
        return r.query(sql, new ScalarHandler<Long>(), courseId).intValue();
    }

    public List getTeachingByUserId(String userId) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from teaching where userId = ?";
        return r.query(sql, new BeanListHandler<Teaching>(Teaching.class), userId);
    }

}
