package com.ylsislove.model.research;

/**
 * 地大分区表
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/15 15:47
 */
public class SubArea {

    private int id;
    private String name;
    private String level;

    public SubArea() {
    }

    public SubArea(int id, String name, String level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    public SubArea(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "SubArea{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
