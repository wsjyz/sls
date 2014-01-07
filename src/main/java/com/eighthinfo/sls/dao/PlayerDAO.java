package com.eighthinfo.sls.dao;

import com.eighthinfo.sls.model.Player;

/**
 * User: dam
 * Date: 13-11-23
 */
public interface PlayerDAO {

    void save(Player player);

    Player get(String userId);

    /**
     *更新用户经验值
     * @param playerId
     * @param exp
     */
    int updateExp(String playerId,long exp);
}
