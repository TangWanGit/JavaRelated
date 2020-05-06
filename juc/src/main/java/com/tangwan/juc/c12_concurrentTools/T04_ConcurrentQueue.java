/*
 * File Name:T02_CopyOnWriteList is created on 2020-05-06 16:27 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c12_concurrentTools;

import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Zhao Xiaoli
 * @Description : T02_CopyOnWriteList
 * 速度快
 * @date 2020-05-06 16:27
 * @since JDK 1.8
 */
public class T04_ConcurrentQueue {
    public static void main(String[] args) {
        // 队列
        Queue<String> queue = new ConcurrentLinkedQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.offer("a" + i);
        }

        System.out.println(queue);
        System.out.println(queue.size());

        System.out.println(queue.poll());
        System.out.println(queue.size());

        System.out.println(queue.peek());
        System.out.println(queue.size());

        // 双端队列
        Deque<String> deque = new ConcurrentLinkedDeque<>();
        for (int i = 0; i < 10; i++) {
            deque.offer("a" + i);
        }

        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
        System.out.println(deque.pollFirst());

        System.out.println(deque.size());
    }
}
