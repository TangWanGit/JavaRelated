/*
 * File Name:T06_HoldLock is created on 2020-08-30 15:11 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c0_basic;

/**
 * @author Zhao Xiaoli
 * @Description : T06_HoldLock
 * @date 2020-08-30 15:11
 * @since JDK 1.8
 */
public class T06_HoldLock {
    private final static Object o = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new HoldLock());
        Thread thread2 = new Thread(new HoldLock());
        Thread thread3 = new Thread(new HoldLock());

        thread1.start();
        thread2.start();
        thread3.start();
    }

    public static class HoldLock implements Runnable {
        @Override
        public void run() {
            synchronized (o) {
                System.out.println(Thread.currentThread().getName() + " get the lock.");
                try {
                    Thread.sleep(1000 * 60 * 60);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
