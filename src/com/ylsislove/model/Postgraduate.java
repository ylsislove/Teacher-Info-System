package com.ylsislove.model;

/**
 * @Description 本科生管理信息，包括条目id，教师工号，学生人数，研究生详情
 * @ClassName PostgraduateDao
 * @Author Apple_Coco
 * @Date 2019/9/8 12:29
 * @Version V1.0
 */
public class Postgraduate {

    private int id;
    private int academicDate;
    private String userId;
    private int stuNum;
    private String stuDetail;

    public Postgraduate() {
    }

    public Postgraduate(int id, int academicDate, String userId, int stuNum, String stuDetail) {
        this.id = id;
        this.academicDate = academicDate;
        this.userId = userId;
        this.stuNum = stuNum;
        this.stuDetail = stuDetail;
    }

    public Postgraduate(int academicDate, String userId, int stuNum, String stuDetail) {
        this.academicDate = academicDate;
        this.userId = userId;
        this.stuNum = stuNum;
        this.stuDetail = stuDetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getacademicDate() {
        return academicDate;
    }

    public void setacademicDate(int academicDate) {
        this.academicDate = academicDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getStuNum() {
        return stuNum;
    }

    public void setStuNum(int stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuDetail() {
        return stuDetail;
    }

    public void setStuDetail(String stuDetail) {
        this.stuDetail = stuDetail;
    }

    @Override
    public String toString() {
        return "Postgraduate{" +
                "id=" + id +
                ", academicDate=" + academicDate +
                ", userId='" + userId + '\'' +
                ", stuNum=" + stuNum +
                ", stuDetail='" + stuDetail + '\'' +
                '}';
    }
}
