package com.eighthinfo.sls.service;

import com.eighthinfo.sls.model.Hall;
import com.eighthinfo.sls.model.Room;

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

    public List<Room> getRoomList();
}
