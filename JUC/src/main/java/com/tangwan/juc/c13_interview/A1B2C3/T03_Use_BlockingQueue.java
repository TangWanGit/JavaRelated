/*
 * File Name:T03_Use_BlockingQueue is created on 2020-05-06 18:59 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c13_interview.A1B2C3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author tangwan
 * @Description : T03_Use_BlockingQueue
 * @date 2020-05-06 18:59
 * @since JDK 1.8
 */
public class T03_Use_BlockingQueue extends T00_Base {
    static BlockingQueue<String> q1 = new ArrayBlockingQueue<>(1);
    static BlockingQueue<String> q2 = new ArrayBlockingQueue<>(1);

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                for (char c : aI) {
                    q1.put(String.valueOf(c));
                    System.out.print(q2.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                for (char c : aC) {
                    System.out.print(q1.take());
                    q2.put(String.valueOf(c));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }
}
