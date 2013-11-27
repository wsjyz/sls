package com.eighthinfo.sls.service.impl;

import com.eighthinfo.sls.dao.TopicDAO;
import com.eighthinfo.sls.model.Topic;
import com.eighthinfo.sls.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
