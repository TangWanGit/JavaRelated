/*
 * File Name:T16_ReadWriteLock is created on 2021/4/24 10:31 上午 by Zhao Xiaoli
 *
 * Copyright (c) 2021, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c6_AQSLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Zhao Xiaoli
 * @Description : T16_ReadWriteLock
 * @date 2021/4/24 10:31 上午
 * @since JDK 1.8
 */
public class T16_ReadWriteLock {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        Thread a = new Thread(service::read);
        a.setName("A");
        a.start();

        Thread.sleep(1000);

        Thread b = new Thread(service::write);
        b.setName("B");
        b.start();

        Thread.sleep(1000);

        Thread c = new Thread(service::read);
        c.setName("C");
        c.start();

    }

    public static class Service {
        private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        public void read() {
            try {
                try {
                    lock.readLock().lock();
                    System.out
                        .println("read lock  " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
                    Thread.sleep(5000);
                } finally {
                    lock.readLock().unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void write() {
            try {
                try {
                    lock.writeLock().lock();
                    System.out
                        .println("write lock " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
                    Thread.sleep(5000);
                } finally {
                    lock.writeLock().unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
