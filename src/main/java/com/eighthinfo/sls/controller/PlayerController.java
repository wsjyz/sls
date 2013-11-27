package com.eighthinfo.sls.controller;

import com.eighthinfo.sls.model.Player;
import com.eighthinfo.sls.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: dam
 * Date: 13-11-22
 */
@Controller
@RequestMapping(value = "/player")
public class PlayerController {

    @Autowired
    protected PlayerService playerService;

    /**
     * 获得用户信息，若用户未注册，则自动注册
     *
     * @param playerId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{playerId}", method = RequestMethod.GET)
    public Player get(@PathVariable String playerId) {
        Player player = playerService.getById(playerId);
        if (player == null) {//自动注册
            player = Player.newInstance(playerId);
            playerService.save(player);
        }
        return player;
    }


}
