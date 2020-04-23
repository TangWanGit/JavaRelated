/*
 * File Name:T03_ReentrantLock_TryLock is created on 2020-04-23 10:19 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c6_AQSLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Zhao Xiaoli
 * @Description : T03_ReentrantLock_TryLock
 * <p>
 * 使用ReentrantLock还可以调用lockInterruptibly方法，可以对线程interrupt方法做出响应，
 * 在一个线程等待锁的过程中，可以被打断
 * @date 2020-04-23 10:19
 * @since JDK 1.8
 */
public class T05_ReentrantLock_FairLock extends Thread {

    //参数为true表示为公平锁，请对比输出结果
    private static ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获得锁");
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        T05_ReentrantLock_FairLock rl = new T05_ReentrantLock_FairLock();
        Thread th1 = new Thread(rl);
        Thread th2 = new Thread(rl);
        th1.start();
        th2.start();
    }
}
