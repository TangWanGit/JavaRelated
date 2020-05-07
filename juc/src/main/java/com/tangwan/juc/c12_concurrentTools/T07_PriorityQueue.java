/*
 * File Name:T07_PriorityQueue is created on 2020-05-06 17:03 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c12_concurrentTools;

import java.util.PriorityQueue;

/**
 * @author tangwan
 * @Description : T07_PriorityQueue
 * @date 2020-05-06 17:03
 * @since JDK 1.8
 */
public class T07_PriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<String> q = new PriorityQueue<>();

        q.add("c");
        q.add("e");
        q.add("a");
        q.add("d");
        q.add("z");

        for (int i = 0; i < 5; i++) {
            System.out.println(q.poll());
        }

    }
}
