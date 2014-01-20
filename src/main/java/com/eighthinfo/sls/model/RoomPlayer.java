package com.eighthinfo.sls.model;

/**
 * Created with IntelliJ IDEA.
 * User: dam
 * Date: 13-11-18
 * Time: 下午9:48
 */
public class RoomPlayer extends AbstractModel{

    private String id;

    private String playerId;

    private String roomId;

    private String nickName;
    //此字段虽然在player中已经有了，但是为了提高查询速度，且该字段不会经常变，所以当做冗余字段来使用
    private int male;

    private int seatNo;

    private String awardId;

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public int getMale() {
        return male;
    }

    public void setMale(int male) {
        this.male = male;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
