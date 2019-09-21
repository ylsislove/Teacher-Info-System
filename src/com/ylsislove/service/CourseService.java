package com.ylsislove.service;

import com.ylsislove.dao.CourseDao;
import com.ylsislove.model.Course;

import java.sql.SQLException;

/**
 * @Description 和课程相关的API接口
 * @ClassName CourseService
 * @Author Apple_Coco
 * @Date 2019/9/7 22:32
 * @Version V1.0
 */
public class CourseService {

    private CourseDao cDao = new CourseDao();

    public void addCourse(Course course) {
        try {
            cDao.addCourse(course);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Course getCourse(Course course) {
        Course c = null;
        try {
            c = cDao.selectCourse(course);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public Course getCourseById(String id) {
        Course c = null;
        try {
            c = cDao.selectCourseById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public boolean delete(String courseId) {
        try {
            cDao.delete(courseId);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
