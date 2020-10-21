/*
 * File Name:T01_WhatIsThread is created on 2020-04-20 11:08 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c0_basic;

import java.util.concurrent.TimeUnit;

/**
 * @author tangwan
 * @Description : T01_WhatIsThread
 * @date 2020-04-20 11:08
 * @since JDK 1.8
 */
public class T01_WhatIsThread {

    private static class T1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1");
            }
        }
    }

    public static void main(String[] args) {
        //new T1().start();
        //for (int i = 0; i < 10; i++) {
        //    try {
        //        TimeUnit.MICROSECONDS.sleep(1);
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    }
        //    System.out.println("main");
        //}

        new Thread(()-> System.out.println(Thread.currentThread().getName())).start();
        new Thread(()-> System.out.println(Thread.currentThread().getName())).start();

    }
}

