/*
 * File Name:T03_Use_BlockingQueue is created on 2020-05-06 18:59 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c13_interview.A1B2C3;

/**
 * @author Zhao Xiaoli
 * @Description : T04_Use_AtomicInteger
 * @date 2020-05-06 18:59
 * @since JDK 1.8
 */
public class T06_Use_Sync_Wait_Notify_BeginFromA extends T00_Base {

    private static volatile boolean t2Started = false;

    public static void main(String[] args) {
        Object o = new Object();
        new Thread(() -> {
            synchronized (o) {
                while (!t2Started) {
                    try {
                        o.wait();
                    } catch (Exception e) {

                    }
                }
                for (char c : aI) {
                    try {

                        System.out.print(c);
                        o.notify();
                        // 让出锁
                        o.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (o) {
                for (char c : aC) {
                    System.out.print(c);

                    t2Started = true;
                    try {
                        o.notify();
                        // 让出锁
                        o.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }, "t2").start();
    }
}
