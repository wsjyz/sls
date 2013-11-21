package com.eighthinfo.sls.model;

/**
 * @author: Ivan Vigoss
 * Date: 13-11-20
 * Time: PM9:05
 */
public class User {

    private String userId;

    private String userName;

    private int male;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getMale() {
        return male;
    }

    public void setMale(int male) {
        this.male = male;
    }
}
