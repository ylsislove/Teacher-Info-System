package com.ylsislove.model.dto;

/**
 * TODO
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/7 0:57
 */
public class Inventor {

    private String inventorName;
    private String inventorUnit;
    private String isOurTeacher;
    private String userId;

    public Inventor() {
    }

    public Inventor(String inventorName, String inventorUnit, String isOurTeacher, String userId) {
        this.inventorName = inventorName;
        this.inventorUnit = inventorUnit;
        this.isOurTeacher = isOurTeacher;
        this.userId = userId;
    }

    public String getInventorName() {
        return inventorName;
    }

    public void setInventorName(String inventorName) {
        this.inventorName = inventorName;
    }

    public String getInventorUnit() {
        return inventorUnit;
    }

    public void setInventorUnit(String inventorUnit) {
        this.inventorUnit = inventorUnit;
    }

    public String getIsOurTeacher() {
        return isOurTeacher;
    }

    public void setIsOurTeacher(String isOurTeacher) {
        this.isOurTeacher = isOurTeacher;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Inventor{" +
                "inventorName='" + inventorName + '\'' +
                ", inventorUnit='" + inventorUnit + '\'' +
                ", isOurTeacher='" + isOurTeacher + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
