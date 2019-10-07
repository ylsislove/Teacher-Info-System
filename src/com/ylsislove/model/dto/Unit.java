package com.ylsislove.model.dto;

/**
 * 完成单位/参与单位等
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/7 0:51
 */
public class Unit {

    private String workUnit;

    public Unit() {
    }

    public Unit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "workUnit='" + workUnit + '\'' +
                '}';
    }
}
