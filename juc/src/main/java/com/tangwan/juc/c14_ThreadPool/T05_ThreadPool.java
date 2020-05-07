/*
 * File Name:T05_ThreadPool is created on 2020-05-07 09:14 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c14_ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author tangwan
 * @Description : T05_ThreadPool
 * @date 2020-05-07 09:14
 * @since JDK 1.8
 */
public class T05_ThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 6; i++) {
            executorService.execute(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }

        System.out.println(executorService);

        executorService.shutdown();

        System.out.println(executorService.isTerminated());
        System.out.println(executorService.isShutdown());
        System.out.println(executorService);

        TimeUnit.SECONDS.sleep(5);

        System.out.println(executorService.isTerminated());
        System.out.println(executorService.isShutdown());
        System.out.println(executorService);
    }
}
