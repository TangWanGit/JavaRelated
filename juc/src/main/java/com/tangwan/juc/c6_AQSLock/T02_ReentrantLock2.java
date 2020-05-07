/*
 * File Name:T02_ReentrantLock2 is created on 2020-04-23 10:02 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c6_AQSLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tangwan
 * @Description : T02_ReentrantLock2 和 T01_ReentrantLock1进行比较
 * 使用reentrantlock可以完成同样的功能
 * 需要注意的是，必须要必须要必须要手动释放锁（重要的事情说三遍）
 * 使用syn锁定的话如果遇到异常，jvm会自动释放锁，但是lock必须手动释放锁，因此经常在finally中进行锁的释放
 * @date 2020-04-23 10:02
 * @since JDK 1.8
 */
public class T02_ReentrantLock2 {
    Lock lock = new ReentrantLock();

    void m1() {
        try {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void m2() {
        try {
            lock.lock();
            System.out.println("m2....");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        T02_ReentrantLock2 rl = new T02_ReentrantLock2();
        new Thread(rl::m1).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(rl::m2).start();
    }
}
