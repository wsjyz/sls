package com.eighthinfo.sls.model;

import java.util.List;

/**
 * @author: Ivan Vigoss
 * Date: 13-11-21
 * Time: PM2:03
 */
public class Topic {
    private String topicId;
    private String title;
    private int level;
    private List<TopicItem> options;

    public List<TopicItem> getOptions() {
        return options;
    }

    public void setOptions(List<TopicItem> options) {
        this.options = options;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
