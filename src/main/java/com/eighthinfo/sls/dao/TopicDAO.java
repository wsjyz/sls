package com.eighthinfo.sls.dao;

import com.eighthinfo.sls.model.Topic;

import java.util.List;

/**
 * @author: Ivan Vigoss
 * Date: 13-11-21
 * Time: PM2:09
 */
public interface TopicDAO {

    List<Topic> loadRandomTopicList(int level, int limit);
}
