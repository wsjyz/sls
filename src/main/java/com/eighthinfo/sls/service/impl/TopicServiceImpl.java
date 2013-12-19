package com.eighthinfo.sls.service.impl;

import com.eighthinfo.sls.dao.TopicDAO;
import com.eighthinfo.sls.model.Topic;
import com.eighthinfo.sls.model.TopicItem;
import com.eighthinfo.sls.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: dam
 * Date: 13-11-23
 */
@Service("TopicService")
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicDAO topicDAO;

    @Override
    public List<Topic> loadRandomTopicList(int level, int limit) {
        return topicDAO.loadRandomTopicList(level, limit);
    }

    public int importTopic(List<Map<String, String>> list){
        List<Topic> topicList = new ArrayList<Topic>();
        for(Map<String, String> map:list){
            Topic topic = new Topic();
            topic.setTitle(map.get("title"));
            Double level = Double.parseDouble(map.get("level"));
            topic.setLevel(level.intValue());
            topic.setTags(map.get("tags"));
            List<TopicItem> itemList = new ArrayList<TopicItem>();
            int rightAnswer = ((Double)Double.parseDouble(map.get("right_answer"))).intValue();
            for(int i = 1; i <= 4;i ++){
                TopicItem item = new TopicItem();
                item.setContent(map.get("content_"+i));
                item.setIndex(i);
                if(i == rightAnswer){
                    item.setRight(1);
                }else{
                    item.setRight(0);
                }
                itemList.add(item);
            }
            topic.setOptions(itemList);
            topicList.add(topic);
        }
        return topicDAO.saveBatch(topicList);
    }
}
