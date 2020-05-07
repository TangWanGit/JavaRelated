/*
 * File Name:T04_HelloThreadPool is created on 2020-05-06 19:44 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c14_ThreadPool;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Zhao Xiaoli
 * @Description : T04_HelloThreadPool
 * @date 2020-05-06 19:44
 * @since JDK 1.8
 */
public class T04_HelloThreadPool {
    static class Task implements Runnable {

        private int i;

        public Task(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " Task " + i);
            try {
                // 阻塞占用线程
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "Task{" + "i=" + i + '}';
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor =
            new ThreadPoolExecutor(2, 4, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(4),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 8; i++) {
            threadPoolExecutor.execute(new Task(i));
        }

        System.out.println(threadPoolExecutor.getQueue());

        threadPoolExecutor.execute(new Task(100));

        System.out.println(threadPoolExecutor.getQueue());

        threadPoolExecutor.shutdown();
    }
}
