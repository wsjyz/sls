package com.eighthinfo.sls.service;

import com.eighthinfo.sls.model.Hall;
import com.eighthinfo.sls.model.Room;
import com.eighthinfo.sls.model.RoomPlayer;

import java.util.List;

/**
 * User: dam
 * Date: 13-12-11
 */
public interface HallService {
    /**
     * 查找负载最小的大厅
     * @return
     */
    Hall getIdleHall();

    /**
     * 获取大厅列表
     * @return
     */
    List<Hall> getHallList();
    /**
     * manage
     * 返回某个awardId下的所有房间排名信息
     * @param awardId
     * @return
     */
    List<Room> getRoomList(String awardId);

    /**
     * manage
     * 返回roomId下的玩家信息
     * @param roomId
     * @return
     */
    List<RoomPlayer> findRoomById(String roomId);
}
