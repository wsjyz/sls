package com.eighthinfo.sls.controller;

import com.eighthinfo.sls.model.Award;
import com.eighthinfo.sls.model.UserPrize;
import com.eighthinfo.sls.service.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * User: dam
 * Date: 13-11-22
 */
@Controller
@RequestMapping(value = "/award")
public class AwardController {

    @Autowired
    private AwardService awardService;

    @ResponseBody
    @RequestMapping(value = {"/list/{level}"})
    public List<Award> getAwardList(@PathVariable int level){
        return awardService.loadAwardListByLevel(level);
    }

    @ResponseBody
    @RequestMapping(value = {"/win/{awardId}/{playerId}"})
    public boolean winAprize(@PathVariable String awardId,@PathVariable String playerId){
        return awardService.winAprize(playerId,awardId);
    }

    /**
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {"/get-ranking-list"})
    public List<UserPrize> getPlayerPrizeList(){
        return awardService.getPlayerPrizeList();
    }

    /**
     *
     * @param playerId
     * @param counts
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {"/get-player-prize-list/{playerId}/{counts}"})
    public List<Award> getPlayerPrizePrice(@PathVariable String playerId, @PathVariable int counts){
        return awardService.getPlayerPrizePrice(playerId,counts);
    }
}
