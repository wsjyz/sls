package com.eighthinfo.sls.controller;

import com.eighthinfo.sls.model.Award;
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
    public boolean getAwardList(@PathVariable String awardId,@PathVariable String playerId){
        return awardService.winAprize(playerId,awardId);
    }
}
