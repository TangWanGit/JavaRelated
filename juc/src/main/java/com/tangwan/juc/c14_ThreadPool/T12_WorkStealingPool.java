/*
 * File Name:T12_WorkStealingPool is created on 2020-05-07 10:27 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c14_ThreadPool;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Zhao Xiaoli
 * @Description : T12_WorkStealingPool
 * @date 2020-05-07 10:27
 * @since JDK 1.8
 */
public class T12_WorkStealingPool {
    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newWorkStealingPool();
        System.out.println(Runtime.getRuntime().availableProcessors());

        executorService.execute(new R(1000));
        executorService.execute(new R(2000));
        executorService.execute(new R(2000));
        executorService.execute(new R(2000));
        executorService.execute(new R(2000));

        System.in.read();
    }

    static class R implements Runnable {

        int time;

        public R(int time) {
            this.time = time;
        }

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(time + " " + Thread.currentThread().getName());
        }
    }
}
