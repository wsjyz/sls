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
    public List<UserPrize> getPlayerPrizeList(int count);
    /**
     * 查询玩家获得的奖品
     * @param playerId
     * @param counts :指定显示的数量
     * @return
     */
    List<Award> getPlayerPrizePrice(String playerId, int counts);
}
