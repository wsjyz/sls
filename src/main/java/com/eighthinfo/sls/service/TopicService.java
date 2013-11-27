package com.eighthinfo.sls.service;

import com.eighthinfo.sls.model.Topic;

import java.util.List;

/**
 * User: dam
 * Date: 13-11-23
 */
public interface TopicService {

    List<Topic> loadRandomTopicList(int level, int limit);

}
