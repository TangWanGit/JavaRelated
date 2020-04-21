/*
 * File Name:T01_HelloVolatile is created on 2020-04-21 15:59 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c2_volatile;

import java.util.concurrent.TimeUnit;

/**
 * @author Zhao Xiaoli
 * @Description : T01_HelloVolatile
 * @date 2020-04-21 15:59
 * @since JDK 1.8
 */
public class T01_HelloVolatile {

    // 注释之后，线程之间存在不可见性，程序会一直执行下去
    /*volatile*/ boolean running = true;

    void m() {
        System.out.println("m start");
        while (running) {
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        T01_HelloVolatile t = new T01_HelloVolatile();
        new Thread(t::m, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.running = false;

    }
}
