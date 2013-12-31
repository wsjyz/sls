package com.eighthinfo.sls.dao;

import com.eighthinfo.sls.model.Player;

/**
 * User: dam
 * Date: 13-11-23
 */
public interface PlayerDAO {

    void save(Player player);

    Player get(String userId);

}
