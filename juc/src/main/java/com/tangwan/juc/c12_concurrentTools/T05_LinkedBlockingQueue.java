/*
 * File Name:T05_LinkedBlockingQueue is created on 2020-05-06 16:43 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c12_concurrentTools;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author tangwan
 * @Description : T05_LinkedBlockingQueue
 * <p>
 * 实现消费者生产者模式
 * <p>
 * @date 2020-05-06 16:43
 * @since JDK 1.8
 */
public class T05_LinkedBlockingQueue {
    static BlockingQueue<String> queue = new LinkedBlockingQueue<>();
    static Random r = new Random();

    public static void main(String[] args) {

        // 生产者
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    // 如果满了，就会等待
                    queue.put("a" + i);
                    TimeUnit.MILLISECONDS.sleep(r.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "p1").start();

        for (int i = 0; i < 5; i++) {
            // 消费者
            new Thread(() -> {
                for (; ; ) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " take - " + queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "c" + i).start();
        }
    }
}
