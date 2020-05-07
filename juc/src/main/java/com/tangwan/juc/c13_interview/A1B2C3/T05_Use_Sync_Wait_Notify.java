/*
 * File Name:T03_Use_BlockingQueue is created on 2020-05-06 18:59 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c13_interview.A1B2C3;

/**
 * @author tangwan
 * @Description : T04_Use_AtomicInteger
 * @date 2020-05-06 18:59
 * @since JDK 1.8
 */
public class T05_Use_Sync_Wait_Notify extends T00_Base {

    public static void main(String[] args) {
        Object o = new Object();
        new Thread(() -> {
            synchronized (o) {
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
