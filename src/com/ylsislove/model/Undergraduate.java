package com.ylsislove.model;

/**
 * @Description 本科生管理信息，应用于本科生产实习和本科毕业论文
 * 属性包括条目id，教师工号，时间，学生总数，学生姓名，实习周数
 * 管理类型（1本科生产实习，2本科毕业论文）
 * @ClassName Undergraduate
 * @Author Apple_Coco
 * @Date 2019/9/8 3:48
 * @Version V1.0
 */
public class Undergraduate {

    private int id;
    private String userId;
    private String time;
    private String stuName;
    private int stuNum;
    private int weekNum;
    private int type;

    public Undergraduate() {
    }

    public Undergraduate(int id, String userId, String time, String stuName, int stuNum, int weekNum, int type) {
        this.id = id;
        this.userId = userId;
        this.time = time;
        this.stuNum = stuNum;
        this.stuName = stuName;
        this.weekNum = weekNum;
        this.type = type;
    }

    public Undergraduate(String userId, String time, String stuName, int stuNum, int weekNum, int type) {
        this.userId = userId;
        this.time = time;
        this.stuNum = stuNum;
        this.stuName = stuName;
        this.weekNum = weekNum;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getStuNum() {
        return stuNum;
    }

    public void setStuNum(int stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(int weekNum) {
        this.weekNum = weekNum;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Undergraduate{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", time='" + time + '\'' +
                ", stuNum=" + stuNum +
                ", stuName='" + stuName + '\'' +
                ", weekNum=" + weekNum +
                ", type=" + type +
                '}';
    }
}
