/*
 * File Name:TestQueue is created on 2021/3/21 10:49 上午 by Zhao Xiaoli
 *
 * Copyright (c) 2021, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.common.utils.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Zhao Xiaoli
 * @Description : TestQueue
 * @date 2021/3/21 10:49 上午
 * @since JDK 1.8
 */
public class TestQueue {

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10000);
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(10000);

        new Thread(() -> {
            testBlockingQueue(linkedBlockingQueue);
            testBlockingQueue(arrayBlockingQueue);
        }).start();

        Thread.sleep(100);

        new Thread(() -> {
            testTakeBlockingQueue(linkedBlockingQueue);
            testTakeBlockingQueue(arrayBlockingQueue);
        }).start();

    }

    public static void testBlockingQueue(BlockingQueue queue) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            queue.offer(i);
        }
        System.out.println(queue.getClass() + "add : " + (System.currentTimeMillis() - start));
    }

    public static void testTakeBlockingQueue(BlockingQueue queue) {
        long start = System.currentTimeMillis();
        while (queue.size() > 0) {
            try {
                queue.take();
            } catch (InterruptedException e) {
                continue;
            }
        }
        System.out.println(queue.getClass() + "take : " + (System.currentTimeMillis() - start));
    }

}
