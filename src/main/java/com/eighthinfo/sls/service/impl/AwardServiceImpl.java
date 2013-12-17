package com.eighthinfo.sls.service.impl;

import com.eighthinfo.sls.Constants;
import com.eighthinfo.sls.dao.AwardDAO;
import com.eighthinfo.sls.model.Award;
import com.eighthinfo.sls.service.AwardService;
import com.eighthinfo.sls.utils.Lottery;
import com.eighthinfo.sls.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * User: dam
 * Date: 13-11-23
 */
@Service("AwardService")
public class AwardServiceImpl implements AwardService {

    @Autowired
    private AwardDAO awardDAO;

    @Override
    public List<Award> loadAwardListByLevel(int level) {
        return awardDAO.loadAwardListByLevel(level);
    }

    public boolean winAprize(String playerId,String awardId){
        boolean win = false;
        String rate = awardDAO.getAwardRateOfWin(awardId);
        Lottery lottery = new Lottery();
        Map<String,Integer> map = StringUtil.getWeightMap(awardId,rate);
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            lottery.addAward(entry.getKey(),entry.getValue());
        }
        if(!lottery.getAward().equals(Constants.NO_WIN_A_PRIZE_KEY)){
            win = true;
        }
        return win;
    }
}
