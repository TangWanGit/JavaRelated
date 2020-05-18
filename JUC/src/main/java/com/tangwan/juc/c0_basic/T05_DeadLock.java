/*
 * File Name:T05_DeadLock is created on 2020-05-07 17:23 by tangwan
 *
 * tangwan
 *
 */
package com.tangwan.juc.c0_basic;

import java.util.concurrent.TimeUnit;

/**
 * @author tangwan
 * @Description : T05_DeadLock
 * @date 2020-05-07 17:23
 * @since JDK 1.8
 */
public class T05_DeadLock {

    static class DeadLock {
        String name;
        Integer id;

        public DeadLock(String name, Integer id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            synchronized (name) {
                System.out.println("enter get name");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (id) {
                    return name;
                }
            }
        }

        public Integer getId() {
            synchronized (id) {
                System.out.println("enter get id");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (name) {
                    return id;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DeadLock lock = new DeadLock("this is test", 10);
        Thread thread1 = new Thread(lock::getName);
        Thread thread2 = new Thread(lock::getId);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

