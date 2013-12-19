package com.eighthinfo.sls.service;

import com.eighthinfo.sls.model.Topic;

import java.util.List;
import java.util.Map;

/**
 * User: dam
 * Date: 13-11-23
 */
public interface TopicService {

    List<Topic> loadRandomTopicList(int level, int limit);

    public int importTopic(List<Map<String, String>> list);
}
