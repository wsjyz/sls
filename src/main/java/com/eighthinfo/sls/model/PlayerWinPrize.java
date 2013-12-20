package com.eighthinfo.sls.model;

import java.sql.Timestamp;

/**
 * Created by dam on 13-12-19.
 */
public class PlayerWinPrize extends AbstractModel {

    private String playerWinPrizeId;

    private String playerId;

    private String awardId;

    private Long price;

    private String optTime;


    public String getPlayerWinPrizeId() {
        return playerWinPrizeId;
    }

    public void setPlayerWinPrizeId(String playerWinPrizeId) {
        this.playerWinPrizeId = playerWinPrizeId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getOptTime() {
        return optTime;
    }

    public void setOptTime(String optTime) {
        this.optTime = optTime;
    }
}
