/*
 * File Name:T01_UseWaitAndNofity is created on 2020-10-12 16:58 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c17_producer_and_consumer;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Zhao Xiaoli
 * @Description : T01_UseWaitAndNofity
 * @date 2020-10-12 16:58
 * @since JDK 1.8
 */
public class T01_UseWaitAndNofity {
    private static Object lock = new Object();
    private static int repository = 0;
    private static Random random = new Random();

    public static boolean isEmpty() {
        return repository == 0;
    }

    public static boolean isFull() {
        return repository == 10;
    }

    private static ThreadPoolExecutor executor =
        new ThreadPoolExecutor(5, 5, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(),
            new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) {
        executor.execute(new Consumer());
        executor.execute(new Producer());

        executor.execute(new Consumer());
        executor.execute(new Producer());

        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();

    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    while (isEmpty()) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " consumer : " + (repository--));
                    lock.notify();
                }
            }
        }
    }

    static class Producer implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    while (isFull()) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " producer : " + (++repository));
                    lock.notify();
                }
            }
        }
    }
}
