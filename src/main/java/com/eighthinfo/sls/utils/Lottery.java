package com.eighthinfo.sls.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 *  简单抽奖算法
 *  生成一个列表，分成几个区间，然后随机从100取出一个数，看落在哪个区间。
 *  算法时间复杂度：预处理O(MN)，随机数生成O(1)，空间复杂度O(MN)，其中N代表物品种类，M则由最低概率决定。
 *  注意：在web集群环境中，极大并发下可能有问题，未验证
 * Created by dam on 13-12-17.
 */
public class Lottery {

    private static final int DEFAULT_WEIGHT = 100;

    private final Random random = new Random();

    private final SortedMap<Integer, String> awards = new ConcurrentSkipListMap<Integer, String>();

    private AtomicInteger maxWeight = new AtomicInteger(0);

    public void addAward(String awardId,int weight){
        maxWeight.addAndGet(weight);
        awards.put(maxWeight.intValue(), awardId);
    }

    public String getAward(){
        int result = random.nextInt(maxWeight.intValue()) + 1;
        String awardId = null;
        for(Map.Entry<Integer, String> entry : awards.entrySet()){
            if(entry.getKey() > result){
                awardId = entry.getValue();
                break;
            }
        }
        return awardId;
    }

    public static void main(String[] args){
        final Lottery lottery = new Lottery();
        lottery.addAward("no",98);
        lottery.addAward("ipad",2);
        // 测试构建的结果
        final Map<String, AtomicLong> stats = new HashMap<String, AtomicLong>();
        stats.put("no", new AtomicLong());
        stats.put("ipad", new AtomicLong());
        final AtomicLong fail = new AtomicLong();
        final AtomicLong totalCost = new AtomicLong();
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        for (int i = 0; i <= 1000000; i++) {
            executorService.execute(new Runnable() {

                @Override
                public void run() {
                    long t = System.currentTimeMillis();
                    String getNode = lottery.getAward();
                    totalCost.addAndGet(System.currentTimeMillis() - t);
                    AtomicLong stat = stats.get(getNode);
                    if (stat != null) {
                        stat.incrementAndGet();
                    } else {
                        fail.incrementAndGet();
                    }
                }
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 输出测试结果
        System.out.println(stats);
        System.out.println(fail);
        System.out.println(totalCost);
        System.exit(0);
    }
}
