package com.eighthinfo.sls.service;

import com.eighthinfo.sls.model.Award;
import com.eighthinfo.sls.model.UserPrize;

import java.util.List;

/**
 * User: dam
 * Date: 13-11-23
 */
public interface AwardService {

    List<Award> loadAwardListByLevel(int level);

    boolean winAprize(String playerId,String awardId);

    /**
     *获取排行榜
     * @return
     */
    public List<UserPrize> getPlayerPrizeList();
}
