package com.eighthinfo.sls.model;

/**
 * Created by dam on 13-12-20.
 */
public class Room {

    private String roomId;

    private int playerCount;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }
}
