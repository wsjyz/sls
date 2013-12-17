package com.eighthinfo.sls.utils;

import com.eighthinfo.sls.Constants;
import org.apache.commons.lang3.StringUtils;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dam on 13-12-17.
 */
public class StringUtil {

    public static Map<String, Integer> getWeightMap(String key, String weightStr) {
        Map<String, Integer> weightMap = new HashMap<String, Integer>();
        if (weightStr.indexOf(".") != -1&& StringUtils.isNotBlank(key)) {
            int backLength = weightStr.substring(weightStr.indexOf("."), weightStr.length()).length();
            int num = Integer.parseInt(StringUtils.rightPad("1", backLength, "0"));
            int weightNum = 0;
            if(backLength == 2){
                weightNum = Integer.parseInt(weightStr.substring(weightStr.lastIndexOf(".") + 1, weightStr.length()));
            }else{
                weightNum = Integer.parseInt(weightStr.substring(weightStr.lastIndexOf("0") + 1, weightStr.length()));
            }

            int otherWeightNum = num - weightNum;
            weightMap.put(Constants.NO_WIN_A_PRIZE_KEY, otherWeightNum);
            weightMap.put(key, weightNum);
        }
        return weightMap;
    }

    public static void main(String[] args) {
        Map<String,Integer> map = getWeightMap("a", "0.1");
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
