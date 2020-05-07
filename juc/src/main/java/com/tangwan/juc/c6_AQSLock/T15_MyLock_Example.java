/*
 * File Name:T14_MyLock is created on 2020-04-23 15:36 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c6_AQSLock;

import java.util.concurrent.locks.Lock;

/**
 * @author tangwan
 * @Description : T14_MyLock
 * @date 2020-04-23 15:36
 * @since JDK 1.8
 */
public class T15_MyLock_Example {
    public static int m;

    static Lock lock = new T14_MyLock();

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];

        for (int i = 0; i < threads.length; i++) {

            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    try {
                        lock.lock();
                        m++;
                    } finally {
                        lock.unlock();
                    }
                }
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(m);
    }
}
