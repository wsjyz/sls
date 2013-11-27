package com.eighthinfo.sls.service.impl;

import com.eighthinfo.sls.dao.PlayerDAO;
import com.eighthinfo.sls.model.Player;
import com.eighthinfo.sls.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: dam
 * Date: 13-11-23
 */
@Service("PlayerService")
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerDAO playerDAO;

    @Override
    public Player getById(String playerId) {
        return playerDAO.get(playerId);
    }

    @Override
    public void save(Player player) {
        playerDAO.save(player);
    }
}
