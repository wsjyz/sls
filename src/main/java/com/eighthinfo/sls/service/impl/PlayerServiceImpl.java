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
                List<PlayerLevelSetting> levelList = playerLevelSettingDAO.getUserLevelSetting();
                Iterator<PlayerLevelSetting> iter = levelList.iterator();
                PlayerLevelSetting previousSetting = null;
                while(iter.hasNext()){
                    PlayerLevelSetting setting = iter.next();
                    if(experience > setting.getNeedExp()){
                        player.setCurrentTitle(setting.getLevelTitle());
                        if(previousSetting != null){
                            player.setCurrentExperience((experience.floatValue() - setting.getNeedExp())
                                    /(previousSetting.getNeedExp() - setting.getNeedExp()) *100);
                        }else{
                            if(experience >= setting.getNeedExp()){
                                player.setCurrentExperience(100);
                            }else{
                                player.setCurrentExperience(experience.floatValue()/setting.getNeedExp() *100);
                            }

                        }
                        break;
                    }else if(experience == setting.getNeedExp()){
                        if(previousSetting != null){
                            player.setCurrentTitle(setting.getLevelTitle());
                            player.setCurrentExperience(0);
                        }else{
                            player.setCurrentTitle(setting.getLevelTitle());
                            player.setCurrentExperience(100);
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
}
