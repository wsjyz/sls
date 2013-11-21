package com.eighthinfo.sls.model;

/**
 * @author: Ivan Vigoss
 * Date: 13-11-21
 * Time: PM1:57
 */
public class Room {
    private String roomId;
    private String roomName;
    private String bgHref;
    private int remain;
    private int total;
    private String detailHref;
    private String description;

    public String getBgHref() {
        return bgHref;
    }

    public void setBgHref(String bgHref) {
        this.bgHref = bgHref;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetailHref() {
        return detailHref;
    }

    public void setDetailHref(String detailHref) {
        this.detailHref = detailHref;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
