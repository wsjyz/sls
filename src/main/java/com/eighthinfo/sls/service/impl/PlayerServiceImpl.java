package com.eighthinfo.sls.service.impl;

import com.eighthinfo.sls.dao.PlayerDAO;
import com.eighthinfo.sls.dao.PlayerLevelSettingDAO;
import com.eighthinfo.sls.model.Player;
import com.eighthinfo.sls.model.PlayerLevelSetting;
import com.eighthinfo.sls.service.PlayerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * User: dam
 * Date: 13-11-23
 */
@Service("PlayerService")
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerDAO playerDAO;
    @Autowired
    private PlayerLevelSettingDAO playerLevelSettingDAO;

    @Override
    public Player getById(String playerId) {
        if(StringUtils.isNotBlank(playerId)){
            Player player = playerDAO.get(playerId);
            if(player != null){
                Long experience = player.getExperience();
                List<PlayerLevelSetting> levelList = playerLevelSettingDAO.getUserLevelSetting(); //倒序
                Iterator<PlayerLevelSetting> iter = levelList.iterator();
                PlayerLevelSetting previousSetting = null;
                while(iter.hasNext()){
                    PlayerLevelSetting setting = iter.next();
                    if(experience > setting.getNeedExp()){ //反向查找的
                        player.setCurrentTitle(setting.getLevelTitle());
                        if(previousSetting != null){
                            player.setCurrentExpRate((experience.floatValue() - setting.getNeedExp())
                                    / (previousSetting.getNeedExp() - setting.getNeedExp()) * 100);
                            player.setNextExp(previousSetting.getNeedExp());
                        }else{
                            if(experience >= setting.getNeedExp()){ //如果超过或等于最大级别
                                player.setCurrentExpRate(100);
                            }else{//如果小于最大级别
                                player.setCurrentExpRate(experience.floatValue() / setting.getNeedExp() * 100);
                            }
                            player.setNextExp(setting.getNeedExp());
                        }
                        break;
                    }else if(experience == setting.getNeedExp()){
                        if(previousSetting != null){
                            player.setCurrentTitle(setting.getLevelTitle());
                            player.setCurrentExpRate(0);
                            player.setNextExp(previousSetting.getNeedExp());
                        }else{
                            player.setCurrentTitle(setting.getLevelTitle());
                            player.setCurrentExpRate(100);
                            player.setNextExp(setting.getNeedExp());
                        }
                        break;
                    }else{
                        previousSetting = setting;
                    }
                }
            }

            return player;
        }

        return null;
    }

    @Override
    public void save(Player player) {
        playerDAO.save(player);
    }

    @Override
    public int updateExp(String playerId, long exp) {
        return playerDAO.updateExp(playerId,exp);
    }
}
