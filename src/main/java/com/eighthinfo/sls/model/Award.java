package com.eighthinfo.sls.model;

/**
 * 奖品
 *
 * @author: Ivan Vigoss
 * Date: 13-11-21
 * Time: PM1:57
 */
public class Award {
    private String awardId;
    /**
     * 难度
     */
    private int level;
    private String awardName;
    private String bgHref;
    private int remain;
    private int total;
    private String detailHref;
    private String description;
    private long price;

    public String getBgHref() {
        return bgHref;
    }

    public void setBgHref(String bgHref) {
        this.bgHref = bgHref;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetailHref() {
        return detailHref;
    }

    public void setDetailHref(String detailHref) {
        this.detailHref = detailHref;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
