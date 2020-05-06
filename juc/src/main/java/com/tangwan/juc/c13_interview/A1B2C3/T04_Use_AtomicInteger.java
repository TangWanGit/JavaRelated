/*
 * File Name:T03_Use_BlockingQueue is created on 2020-05-06 18:59 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c13_interview.A1B2C3;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Zhao Xiaoli
 * @Description : T04_Use_AtomicInteger
 * @date 2020-05-06 18:59
 * @since JDK 1.8
 */
public class T04_Use_AtomicInteger extends T00_Base {
    static AtomicInteger ac = new AtomicInteger(1);

    public static void main(String[] args) {
        new Thread(() -> {
            for (char c : aI) {
                while (ac.get() != 1) {
                }
                System.out.print(c);
                ac.set(2);
            }
        }, "t1").start();

        new Thread(() -> {
            for (char c : aC) {
                while (ac.get() != 2) {
                }
                System.out.print(c);
                ac.set(1);
            }
        }, "t2").start();
    }
}
