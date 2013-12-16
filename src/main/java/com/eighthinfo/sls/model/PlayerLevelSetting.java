package com.eighthinfo.sls.model;

/**
 * Created by dam on 13-12-16.
 */
public class PlayerLevelSetting extends AbstractModel{

    private String levelId;
    private String levelTitle;
    private long needExp;

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public String getLevelTitle() {
        return levelTitle;
    }

    public void setLevelTitle(String levelTitle) {
        this.levelTitle = levelTitle;
    }

    public long getNeedExp() {
        return needExp;
    }

    public void setNeedExp(long needExp) {
        this.needExp = needExp;
    }
}
