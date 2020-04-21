/*
 * File Name:FineCoarseLock is created on 2020-04-21 16:56 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c3_lockOptimization;

import java.util.concurrent.TimeUnit;

/**
 * @author Zhao Xiaoli
 * @Description : FineCoarseLock
 * synchronized优化
 * 同步代码块中的语句越少越好
 * 比较m1和m2
 * @date 2020-04-21 16:56
 * @since JDK 1.8
 */
public class FineCoarseLock {
    int count = 0;

    synchronized void m1() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 业务逻辑中只有下面这句需要sync，这时不应该给整个方法上锁
        for (int i = 0; i < 1000; i++) {
            count++;
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void m2() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //业务逻辑中只有下面这句需要sync，这时不应该给整个方法上锁
        //采用细粒度的锁，可以使线程争用时间变短，从而提高效率
        synchronized (this) {
            for (int i = 0; i < 1000; i++) {
                count++;
            }
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FineCoarseLock lock = new FineCoarseLock();
        Thread t1 = new Thread(lock::m1);
        Thread t2 = new Thread(lock::m2);

        long start = System.currentTimeMillis();
        t1.start();
        t1.join();

        System.out.println("t1" + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        t2.start();
        t2.join();
        System.out.println("t2" + (System.currentTimeMillis() - start));
    }
}
