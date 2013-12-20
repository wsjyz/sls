package com.eighthinfo.sls.model;

/**
 * Created by dam on 13-12-19.
 */
public class UserPrize extends AbstractModel{

    private String nickName;

    private Double rmb;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Double getRmb() {
        return rmb;
    }

    public void setRmb(Double rmb) {
        this.rmb = rmb;
    }
}
