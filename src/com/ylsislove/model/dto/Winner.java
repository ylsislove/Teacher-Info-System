package com.ylsislove.model.dto;

/**
 * 获奖人
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/7 0:55
 */
public class Winner {

    private String winnerName;
    private String isOurTeacher;
    private String userId;

    public Winner() {
    }

    public Winner(String winnerName, String isOurTeacher, String userId) {
        this.winnerName = winnerName;
        this.isOurTeacher = isOurTeacher;
        this.userId = userId;
    }

    public String getWinnerName() {
        return winnerName;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
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
        return "Winner{" +
                "winnerName='" + winnerName + '\'' +
                ", isOurTeacher='" + isOurTeacher + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
