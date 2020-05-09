/*
 * File Name:T01_ConcurrentMap is created on 2020-05-06 09:31 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c12_concurrentTools;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

import com.tangwan.juc.StopWatcher;

/**
 * @author tangwan
 * @Description : T01_ConcurrentMap
 * http://blog.csdn.net/sunxianghuang/article/details/52221913
 * http://www.educity.cn/java/498061.html
 * 阅读concurrentskiplistmap
 * @date 2020-05-06 09:31
 * @since JDK 1.8
 */
public class T01_ConcurrentMap {
    /**
     * 某次运行结果：
     * consuming : 731
     * 99994
     * true
     * ------------------------------
     * consuming : 1983
     * 99993
     * true
     * ------------------------------
     * consuming : 859
     * 99996
     * true
     * ------------------------------
     * consuming : 441
     * 181910
     * false
     * ------------------------------
     * consuming : 761
     * 99997
     * true
     * ------------------------------
     * <p>
     * 根据以上结果可看出：
     * 1. 线程安全的map，速度最快的是ConcurrentHashMap > Collections.synchronizedMap(new HashMap<>()) > Hashtable
     * 2. 线程安全且排序的map，ConcurrentSkipListMap，速度比较慢，但有排序功能
     * 3. 线程不安全的map，HashMap，运行速度也是很快
     *
     * @param args
     */
    public static void main(String[] args) {
        int initCapacity = 1 << 5;
        test(new ConcurrentHashMap<>(initCapacity));
        //高并发并且排序
        test(new ConcurrentSkipListMap<>());
        test(new Hashtable<>());
        test(new HashMap<>(initCapacity));
        test(Collections.synchronizedMap(new HashMap<>(initCapacity)));
    }

    public static void test(Map<String, String> map) {
        AtomicLong repeat = new AtomicLong();

        Random r = new Random();
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);

        StopWatcher watcher = new StopWatcher();
        watcher.start();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10_000; j++) {
                    String s = map.putIfAbsent("a" + r.nextInt(100_000), "a" + r.nextInt(100_000));
                    if (s != null) {
                        repeat.incrementAndGet();
                    }
                }
                latch.countDown();
            });
        }

        Arrays.stream(threads).forEach(Thread::start);

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        watcher.end();
        watcher.finish();

        System.out.println(map.size());
        // map的size和重复键的总数是对的，证明concurrenthashmap是线程安全的
        System.out.println((map.size() + repeat.get()) == 10_000_00);
        System.out.println("------------------------------");
    }
}
