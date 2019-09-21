package com.ylsislove.dao;

import com.ylsislove.model.Course;
import com.ylsislove.model.User;
import com.ylsislove.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @Description 和课程相关的数据库操作
 * @ClassName CourseDao
 * @Author Apple_Coco
 * @Date 2019/9/7 22:25
 * @Version V1.0
 */
public class CourseDao {

    public void addCourse(Course c) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "insert into course(id, courseTime, courseName, courseAttr, courseTotalHours) values(?,?,?,?,?)";
        r.update(sql, c.getId(), c.getCourseTime(), c.getCourseName(), c.getCourseAttr(), c.getCourseTotalHours());
    }

    public Course selectCourse(Course c) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from course where courseTime = ? and courseName = ? and " +
                "courseAttr = ? and courseTotalHours = ?";
        return r.query(sql, new BeanHandler<Course>(Course.class), c.getCourseTime(), c.getCourseName(), c.getCourseAttr(), c.getCourseTotalHours());
    }

    public Course selectCourseById(String id) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from course where id = ?";
        return r.query(sql, new BeanHandler<Course>(Course.class), id);
    }

    public void delete(String courseId) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "delete from course where id = ?";
        r.update(sql, courseId);
    }

}
