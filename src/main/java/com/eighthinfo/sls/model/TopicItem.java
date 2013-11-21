package com.eighthinfo.sls.model;

/**
 * @author: Ivan Vigoss
 * Date: 13-11-21
 * Time: PM2:04
 */
public class TopicItem {
    private String itemId;
    private String topicId;
    private String content;
    private int right;//0 false,1 true
    private int index;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }
}
