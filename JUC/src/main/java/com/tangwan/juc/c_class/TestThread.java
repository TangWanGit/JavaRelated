/*
 * File Name:TestThread is created on 2020-09-27 22:27 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c_class;

/**
 * @author Zhao Xiaoli
 * @Description : TestThread
 * @date 2020-09-27 22:27
 * @since JDK 1.8
 */
public class TestThread implements Runnable {

    P p;

    public TestThread(P p) {
        this.p = p;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(p.name);

    }

    public static void main(String[] args) {
        P p = new P("Hello");
        Thread thread = new Thread(new TestThread(p));
        thread.start();
        p.name = "world";

    }
}

class P {
    String name;

    public P(String name) {
        this.name = name;
    }
}