/*
 * File Name:T02_VolatileReference is created on 2020-04-21 16:02 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c2_volatile;

import java.util.concurrent.TimeUnit;

/**
 * @author Zhao Xiaoli
 * @Description : T02_VolatileReference
 * @date 2020-04-21 16:02
 * @since JDK 1.8
 */
public class T02_VolatileReference {
    boolean running = true;

    /**
     * volatile 引用类型（包括数组）只能保证引用本身的可见性，不能保证内部字段的可见性
     */
    volatile static T02_VolatileReference T = new T02_VolatileReference();

    void m() {
        System.out.println("m start");
        while (running) {
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {

        new Thread(T::m, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        T.running = false;
    }
}
