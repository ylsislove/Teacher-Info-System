package com.ylsislove.model;

/**
 * @Description 研究生详情
 * @ClassName Student
 * @Author Apple_Coco
 * @Date 2019/9/21 14:10
 * @Version V1.0
 */

public class Student {

    private String graduationDate;
    private String stuName;
    private String stuId;
    private String stuType;
    private String isFirstTutor;

    public Student() {
    }

    public Student(String graduationDate, String stuName, String stuId, String stuType, String isFirstTutor) {
        this.graduationDate = graduationDate;
        this.stuName = stuName;
        this.stuId = stuId;
        this.stuType = stuType;
        this.isFirstTutor = isFirstTutor;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuType() {
        return stuType;
    }

    public void setStuType(String stuType) {
        this.stuType = stuType;
    }

    public String getIsFirstTutor() {
        return isFirstTutor;
    }

    public void setIsFirstTutor(String isFirstTutor) {
        this.isFirstTutor = isFirstTutor;
    }

    @Override
    public String toString() {
        return "Student{" +
                "graduationDate='" + graduationDate + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuId='" + stuId + '\'' +
                ", stuType='" + stuType + '\'' +
                ", isFirstTutor='" + isFirstTutor + '\'' +
                '}';
    }
}
