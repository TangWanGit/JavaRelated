/*
 * File Name:T15_MyRejectedHandler is created on 2020-05-07 15:16 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c14_ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author tangwan
 * @Description : T15_MyRejectedHandler
 * @date 2020-05-07 15:16
 * @since JDK 1.8
 */
public class T15_MyRejectedHandler {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(4, 4, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(6),
            Executors.defaultThreadFactory(), new MyHandler());

        for (int i = 0; i < 20; i++) {
            int finalI = i;
            executorService.submit(() -> {
                System.out.println(finalI);
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown();
    }

    static class MyHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            //log("r rejected")
            //save r kafka mysql redis
            //try 3 times
            if (executor.getQueue().size() < 10000) {
                //try put again();
            }
            System.out.println("reject");
        }
    }

}
