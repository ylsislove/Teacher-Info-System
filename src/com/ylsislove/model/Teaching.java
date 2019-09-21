package com.ylsislove.model;

/**
 * @Description 教学管理信息，应用于本科课堂教学，本科实验教学，研究生课堂教学，研究生实验教学
 * 属性包括条目id，授课教师工号，课程id，班级数，学生数，分组数，个人实际授课学时，是否英文授课
 * 教学类型（1本科课堂教学，2本科实验教学，3研究生课堂教学，4研究生实验教学）
 * @ClassName Teaching
 * @Author Apple_Coco
 * @Date 2019/9/7 14:27
 * @Version V1.0
 */
public class Teaching {

    private int id;
    private String userId;
    private String courseId;
    private String classrooms;
    private int classNum;
    private int stuNum;
    private int groupNum;
    private int courseRealHours;
    private String isEnglish;
    private int type;

    public Teaching() {
    }

    public Teaching(int id, String userId, String courseId, String classrooms, int classNum, int stuNum, int groupNum, int courseRealHours, String isEnglish, int type) {
        this.id = id;
        this.userId = userId;
        this.courseId = courseId;
        this.classrooms = classrooms;
        this.classNum = classNum;
        this.stuNum = stuNum;
        this.groupNum = groupNum;
        this.courseRealHours = courseRealHours;
        this.isEnglish = isEnglish;
        this.type = type;
    }

    public Teaching(String userId, String courseId, String classrooms, int classNum, int stuNum, int groupNum, int courseRealHours, String isEnglish, int type) {
        this.userId = userId;
        this.courseId = courseId;
        this.classrooms = classrooms;
        this.classNum = classNum;
        this.stuNum = stuNum;
        this.groupNum = groupNum;
        this.courseRealHours = courseRealHours;
        this.isEnglish = isEnglish;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(String classrooms) {
        this.classrooms = classrooms;
    }

    public int getClassNum() {
        return classNum;
    }

    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }

    public int getStuNum() {
        return stuNum;
    }

    public void setStuNum(int stuNum) {
        this.stuNum = stuNum;
    }

    public int getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(int groupNum) {
        this.groupNum = groupNum;
    }

    public int getCourseRealHours() {
        return courseRealHours;
    }

    public void setCourseRealHours(int courseRealHours) {
        this.courseRealHours = courseRealHours;
    }

    public String getIsEnglish() {
        return isEnglish;
    }

    public void setIsEnglish(String isEnglish) {
        this.isEnglish = isEnglish;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Teaching{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", classrooms='" + classrooms + '\'' +
                ", classNum=" + classNum +
                ", stuNum=" + stuNum +
                ", groupNum=" + groupNum +
                ", courseRealHours=" + courseRealHours +
                ", isEnglish='" + isEnglish + '\'' +
                ", type=" + type +
                '}';
    }
}
