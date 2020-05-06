/*
 * File Name:T02_CopyOnWriteList is created on 2020-05-06 16:27 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c12_concurrentTools;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import com.tangwan.juc.ComputeTimeTest;

/**
 * @author Zhao Xiaoli
 * @Description : T02_CopyOnWriteList
 * <p>
 * 写时复制容器 copy on write
 * 多线程环境下，写时效率低，读时效率高
 * 适合写少读多的环境
 * @date 2020-05-06 16:27
 * @since JDK 1.8
 */
public class T02_CopyOnWriteList {
    public static void main(String[] args) {
        List<String> lists = new CopyOnWriteArrayList<>();
        Thread[] threads = new Thread[100];

        Random random = new Random();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1_000; j++) {
                    lists.add("a" + random.nextInt(10_000));
                }
            });
        }

        ComputeTimeTest.runAndComputeTime(threads, lists);
    }
}
