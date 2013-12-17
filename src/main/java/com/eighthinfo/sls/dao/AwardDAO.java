package com.eighthinfo.sls.dao;

import com.eighthinfo.sls.model.Award;

import java.util.List;

/**
 * @author: Ivan Vigoss
 * Date: 13-11-21
 * Time: PM2:10
 */
public interface AwardDAO {

    List<Award> loadAwardListByLevel(int level);

    /**
     * 获取奖品的中奖率
     * @return
     */
    String getAwardRateOfWin(String awardId);
}
