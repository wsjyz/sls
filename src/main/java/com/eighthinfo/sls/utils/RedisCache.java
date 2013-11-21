package com.eighthinfo.sls.utils;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import redis.clients.jedis.JedisCommands;

/**
 * @author: Ivan Vigoss
 * Date: 13-11-21
 * Time: PM2:33
 */
public class RedisCache {

    private static JedisCommands jedis = ApplicationContextWrapper.context.getBean(JedisCommands.class);
    private final static String DATE_FORMAT = "yyyy-MM-dd hh:mm:ss.S";

    public static <T> void saveObject(String key, T value) {
        String json = JSON.toJSONStringWithDateFormat(value, DATE_FORMAT);
        jedis.set(key, json);
    }

    public static <T> T getObject(String key, Class<T> type) {
        String json = jedis.get(key);
        if (StringUtils.isNotEmpty(json)) {
            return JSON.parseObject(json, type);
        }
        return null;
    }

}
