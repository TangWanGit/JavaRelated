/*
 * File Name:T09_SynchronzedQueue is created on 2020-05-06 17:12 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c12_concurrentTools;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author tangwan
 * @Description : T09_SynchronzedQueue
 * @date 2020-05-06 17:12
 * @since JDK 1.8
 */
public class T09_SynchronzedQueue {
    public static void main(String[] args) throws InterruptedException {
        // 容量为0
        BlockingQueue<String> queue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // 被上述线程取出
        queue.put("aaa");

        // 阻塞等待消费者消费
        //queue.put("bbb");

        System.out.println(queue.size());
    }
}
