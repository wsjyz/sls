package com.eighthinfo.sls.model;

import com.eighthinfo.sls.utils.ChineseNameGenerator;

/**
 * 玩家信息
 *
 * @author: Ivan Vigoss
 * Date: 13-11-20
 * Time: PM9:05
 */
public class Player {

    private String playerId;

    private String nickName;

    private int male;
    /**
     * 真实姓名
     */
    private String peopleName;

    private String qq;

    private String phone;

    private String email;

    private String address;
    /**
     * 排名
     */
    private int ranking;

    /**
     * 经验值
     */
    private long experience;
    /**
     *当前进度百分比
     */
    private float currentExpRate;
    /**
     *当前级别名称
     */
    private String currentTitle;
    /**
     *下一等级需要经验值
     */
    private long nextExp;

    public long getNextExp() {
        return nextExp;
    }

    public void setNextExp(long nextExp) {
        this.nextExp = nextExp;
    }

    public String getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public float getCurrentExpRate() {
        return currentExpRate;
    }

    public void setCurrentExpRate(float currentExpRate) {
        this.currentExpRate = currentExpRate;
    }

    public String getCurrentTitle() {
        return currentTitle;
    }

    public void setCurrentTitle(String currentTitle) {
        this.currentTitle = currentTitle;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getMale() {
        return male;
    }

    public void setMale(int male) {
        this.male = male;
    }

    public long getExperience() {
        return experience;
    }

    public void setExperience(long experience) {
        this.experience = experience;
    }

    public static Player newInstance(String playerId) {
        Player player = new Player();
        player.setPlayerId(playerId);
        player.setMale(1);
        player.setNickName(ChineseNameGenerator.getChinaName());
        return player;
    }
}
