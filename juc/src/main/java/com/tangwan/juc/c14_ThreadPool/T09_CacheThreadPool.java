/*
 * File Name:T09_CacheThreadPool is created on 2020-05-07 09:52 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c14_ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Zhao Xiaoli
 * @Description : T09_CacheThreadPool
 * @date 2020-05-07 09:52
 * @since JDK 1.8
 */
public class T09_CacheThreadPool {
    public static void main(String[] args) throws InterruptedException {
        // 线程可变化的线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 初始化时，pool size = 0
        System.out.println(executorService);

        for (int i = 0; i < 2; i++) {
            executorService.execute(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
        // 运行了两个线程，pool size = 2，active threads = 2， completed tasks = 0
        System.out.println(executorService);

        TimeUnit.SECONDS.sleep(5);

        // 两个线程运行结束，pool size = 2，active threads = 0， completed tasks = 2
        System.out.println(executorService);

        TimeUnit.SECONDS.sleep(70);

        // 过了很长时间，线程被回收，pool size = 0，active threads = 0， completed tasks = 2
        System.out.println(executorService);
    }
}
