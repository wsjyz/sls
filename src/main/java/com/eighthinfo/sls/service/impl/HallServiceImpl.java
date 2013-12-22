package com.eighthinfo.sls.service.impl;

import com.eighthinfo.sls.model.Hall;
import com.eighthinfo.sls.model.Room;
import com.eighthinfo.sls.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Date: 13-12-11
 */
@Service("HallService")
public class HallServiceImpl implements HallService {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public Hall getIdleHall() {
        Set<String> hallSet = redisTemplate.boundZSetOps("hallSet").range(0,-1);

        Iterator<String> itea = hallSet.iterator();

        if(itea.hasNext()){
            String hallStr = itea.next();
            String[] arr = hallStr.split(":");
            Hall hall = new Hall();
            hall.setHost(arr[0]);
            hall.setPort(Integer.parseInt(arr[1]));
            return hall;
        }

        return null;
    }

    @Override
    public List<Hall> getHallList() {
        List<Hall> hallList = new ArrayList<Hall>();
        Set<ZSetOperations.TypedTuple<String>> hallSet = redisTemplate.boundZSetOps("hallSet").rangeWithScores(0,-1);
        Iterator<ZSetOperations.TypedTuple<String>> itor = hallSet.iterator();
        while (itor.hasNext()){
            ZSetOperations.TypedTuple<String> typedTuple = itor.next();
            String hallStr = typedTuple.getValue();
            if(hallStr.indexOf(":") != -1){
                String[] hallArr = hallStr.split(":");
                Hall hall = new Hall();
                hall.setHost(hallArr[0]);
                hall.setPort(Integer.parseInt(hallArr[1]));
                hall.setPlayerCounts(typedTuple.getScore().intValue());
                hallList.add(hall);
            }

        }
        return hallList;
    }

    public List<Room> getRoomList(){
        List<Room> roomList = new ArrayList<Room>();

        //Set<ZSetOperations.TypedTuple<String>> hallSet = redisTemplate.boundZSetOps("hallSet").rangeWithScores(0,-1);
        return roomList;
    }
}
