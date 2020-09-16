/*
 * File Name:T11_Semaphore is created on 2020-04-23 15:16 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c6_AQSLock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tangwan
 * @Description : T11_Semaphore
 * @date 2020-04-23 15:16
 * @since JDK 1.8
 */
public class T11_Semaphore {
    static Semaphore semaphore1 = new Semaphore(1);
    static Semaphore semaphore2 = new Semaphore(1);

    public static void main(String[] args) throws InterruptedException {
        testDeadlockRecovery();
    }

    /**
     * 结果说明了以下2个问题：
     * <p>
     * 1.并没有抛出异常，也就是线程在调用release()之前，并不要求先调用acquire() 。
     * <p>
     * 2.我们看到可用的许可数目增加了一个，但我们的初衷是保证只有一个许可来达到互斥排他锁的目的.
     */
    public static void testRelease() {
        Lock lock = new ReentrantLock();
        // 未使用lock的时候，先使用unlock，会抛异常：java.lang.IllegalMonitorStateException
        // lock.unlock();

        Semaphore s = new Semaphore(1);
        System.out.println(s.availablePermits());
        s.release();
        System.out.println(s.availablePermits());
    }

    public static void testSemaphore() {
        Semaphore s = new Semaphore(2, true);
        new Thread(() -> {
            try {
                s.acquire();

                System.out.println("T1 running ...");
                Thread.sleep(200);
                System.out.println("T1 running ...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release();
            }
        }).start();

        new Thread(() -> {
            try {
                s.acquire();

                System.out.println("T2 running ...");
                Thread.sleep(200);
                System.out.println("T2 running ...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release();
            }
        }).start();

    }

    public static void testDeadlockRecovery() throws InterruptedException {
        Work1 work1 = new Work1();
        Work2 work2 = new Work2();

        work1.start();
        work2.start();
        //此时已经陷入了死锁（也可以说是活锁）
        //WorkThread1持有semaphore1的许可，请求semaphore2的许可
        // WorkThread2持有semaphore2的许可，请求semaphore1的许可
        TimeUnit.SECONDS.sleep(10);
        //在主线程是否semaphore1,semaphore2,解决死锁
        System.out.println("===释放信号==");
        semaphore1.release();
        semaphore2.release();

        TimeUnit.SECONDS.sleep(1);
        System.out.println("===availablePermits==");
        System.out.println("semaphore1.availablePermits: " + semaphore1.availablePermits());
        System.out.println("semaphore2.availablePermits: " + semaphore2.availablePermits());

    }

    static class Work1 extends Thread {
        @Override
        public void run() {
            try {
                semaphore1.acquire();
                System.out.println(Thread.currentThread().getName() + " 获得semaphore1");

                TimeUnit.SECONDS.sleep(5);

                semaphore2.acquire();
                System.out.println(Thread.currentThread().getName() + " 获得semaphore2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Work2 extends Thread {
        @Override
        public void run() {
            try {
                semaphore2.acquire();
                System.out.println(Thread.currentThread().getName() + " 获得semaphore2");

                TimeUnit.SECONDS.sleep(5);

                semaphore1.acquire();
                System.out.println(Thread.currentThread().getName() + " 获得semaphore1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}


