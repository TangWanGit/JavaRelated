/*
 * File Name:T02_AtomicVsSyncVsLongAddr is created on 2020-04-21 17:06 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c4_atomicXXX;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author Zhao Xiaoli
 * @Description : T02_AtomicVsSyncVsLongAddr
 * @date 2020-04-21 17:06
 * @since JDK 1.8
 */
public class T02_AtomicVsSyncVsLongAddr {
    static int Thread_Count = 100;
    static int increment = 1000000;

    static AtomicLong count1 = new AtomicLong();
    static LongAdder count3 = new LongAdder();
    static long count2 = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[Thread_Count];

        for (int i = 0; i < Thread_Count; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < increment; j++) {
                    count1.incrementAndGet();
                }
            });
        }

        long start = System.currentTimeMillis();
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Atomic : " + count1.get() + " time " + (System.currentTimeMillis() - start));

        //-------------------

        Object lock = new Object();
        for (int i = 0; i < Thread_Count; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < increment; j++) {
                    synchronized (lock) {
                        count2++;
                    }
                }
            });
        }

        start = System.currentTimeMillis();
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Sync : " + count1.get() + " time " + (System.currentTimeMillis() - start));

        //--------------------

        for (int i = 0; i < Thread_Count; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < increment; j++) {
                    count3.increment();
                }
            });
        }

        start = System.currentTimeMillis();
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Long addr : " + count1.get() + " time " + (System.currentTimeMillis() - start));

    }

}
