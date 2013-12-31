package com.eighthinfo.sls.service.impl;

import com.eighthinfo.sls.Constants;
import com.eighthinfo.sls.dao.AwardDAO;
import com.eighthinfo.sls.dao.PlayerDAO;
import com.eighthinfo.sls.model.Award;
import com.eighthinfo.sls.model.Player;
import com.eighthinfo.sls.model.PlayerWinPrize;
import com.eighthinfo.sls.model.UserPrize;
import com.eighthinfo.sls.service.AwardService;
import com.eighthinfo.sls.utils.Lottery;
import com.eighthinfo.sls.utils.StringUtil;
import com.eighthinfo.sls.utils.UUIDGen;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: dam
 * Date: 13-11-23
 */
@Service("AwardService")
public class AwardServiceImpl implements AwardService {

    @Autowired
    private AwardDAO awardDAO;
    @Autowired
    private PlayerDAO playerDAO;
    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate<String, String> redisTemplate;

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
            lottery.addAward(entry.getKey(), entry.getValue());
        }
        String winAward = lottery.getAward();
        if(StringUtils.isNotBlank(winAward) && !winAward.equals(Constants.NO_WIN_A_PRIZE_KEY)){
            //保存获奖记录
            PlayerWinPrize playerWinPrize = new PlayerWinPrize();
            playerWinPrize.setPlayerWinPrizeId(UUIDGen.genShortPK());
            playerWinPrize.setAwardId(awardId);
            playerWinPrize.setPlayerId(playerId);
            Award award = awardDAO.getAward(awardId);
            playerWinPrize.setPrice(award.getPrice());
            playerWinPrize.setAwardName(award.getAwardName());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentTime = sdf.format(new Date());
            playerWinPrize.setOptTime(currentTime);
            awardDAO.savePlayerWinPrize(playerWinPrize);
             //查询玩家信息
            Player player = playerDAO.get(playerId);
            //得到玩家的总奖金
            int price = awardDAO.getPlayerPrizeTotalPrice(playerId);
            //更新排行榜
            redisTemplate.boundZSetOps("userWinPrizeList").add(player.getNickName(),price);
            AtomicInteger remain = new AtomicInteger(award.getRemain());
            award.setRemain(remain.decrementAndGet());
            awardDAO.saveAward(award);
            win = true;
        }
        return win;
    }

    public List<UserPrize> getPlayerPrizeList(int count){
        List<UserPrize> prizeList = new ArrayList<UserPrize>();
        Set<ZSetOperations.TypedTuple<String>> set = redisTemplate.boundZSetOps("userWinPrizeList").reverseRangeWithScores(0, count);
        Iterator<ZSetOperations.TypedTuple<String>> itor = set.iterator();
        while(itor.hasNext()){
            ZSetOperations.TypedTuple<String> typedTuple = itor.next();
            UserPrize userPrize = new UserPrize();
            userPrize.setNickName(typedTuple.getValue());
            userPrize.setRmb(typedTuple.getScore());
            prizeList.add(userPrize);
        }
        return prizeList;
    }

    @Override
    public List<Award> getPlayerPrizePrice(String playerId, int counts) {
        return awardDAO.getPlayerPrizePrice(playerId,counts);
    }
}
