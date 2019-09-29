package com.ylsislove.model;

/**
 * 奖项
 *
 * @author Apple_Coco
 * @version V1.0 2019/9/29 23:56
 */
public class Award {

    private int id;
    private String date;
    private String title;
    private String grade;
    private String level;
    private String unit;
    private String winners;
    private int type;

    public Award() {
    }

    public Award(int id, String date, String title, String grade, String level, String unit, String winners, int type) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.grade = grade;
        this.level = level;
        this.unit = unit;
        this.winners = winners;
        this.type = type;
    }

    public Award(String date, String title, String grade, String level, String unit, String winners, int type) {
        this.date = date;
        this.title = title;
        this.grade = grade;
        this.level = level;
        this.unit = unit;
        this.winners = winners;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getWinners() {
        return winners;
    }

    public void setWinners(String winners) {
        this.winners = winners;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Award{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                ", grade='" + grade + '\'' +
                ", level='" + level + '\'' +
                ", unit='" + unit + '\'' +
                ", winners='" + winners + '\'' +
                ", type=" + type +
                '}';
    }
}
