package com.ylsislove.model;

/**
 * @Description 课程信息，包括课程id，授课时间，课程名称，课程性质，课程总学时
 * @ClassName Course
 * @Author Apple_Coco
 * @Date 2019/9/7 14:11
 * @Version V1.0
 */
public class Course {

    private String id;
    private String courseTime;
    private String courseName;
    private String courseAttr;
    private int courseTotalHours;

    public Course() {
    }

    public Course(String id, String courseTime, String courseName, String courseAttr, int courseTotalHours) {
        this.id = id;
        this.courseTime = courseTime;
        this.courseName = courseName;
        this.courseAttr = courseAttr;
        this.courseTotalHours = courseTotalHours;
    }

    public Course(String courseTime, String courseName, String courseAttr, int courseTotalHours) {
        this.courseTime = courseTime;
        this.courseName = courseName;
        this.courseAttr = courseAttr;
        this.courseTotalHours = courseTotalHours;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseAttr() {
        return courseAttr;
    }

    public void setCourseAttr(String courseAttr) {
        this.courseAttr = courseAttr;
    }

    public int getCourseTotalHours() {
        return courseTotalHours;
    }

    public void setCourseTotalHours(int courseTotalHours) {
        this.courseTotalHours = courseTotalHours;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", courseTime='" + courseTime + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseAttr='" + courseAttr + '\'' +
                ", courseTotalHours=" + courseTotalHours +
                '}';
    }
}
