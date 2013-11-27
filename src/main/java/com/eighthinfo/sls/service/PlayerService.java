package com.eighthinfo.sls.service;


import com.eighthinfo.sls.model.Player;

/**
 * User: dam
 * Date: 13-11-23
 */
public interface PlayerService {

    /**
     * 根据userId获得玩家信息
     *
     * @param playerId
     * @return
     */
    Player getById(String playerId);

    void save(Player player);

}
