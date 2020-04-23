/*
 * File Name:T11_Semaphore is created on 2020-04-23 15:16 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c6_AQSLock;

import java.util.concurrent.Semaphore;

/**
 * @author Zhao Xiaoli
 * @Description : T11_Semaphore
 * @date 2020-04-23 15:16
 * @since JDK 1.8
 */
public class T11_Semaphore {
    public static void main(String[] args) {
        Semaphore s = new Semaphore(2,true);
        new Thread(() -> {
            try {
                s.acquire();

                System.out.println("T1 running ...");
                Thread.sleep(200);
                System.out.println("T1 running ...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release();
            }
        }).start();

        new Thread(() -> {
            try {
                s.acquire();

                System.out.println("T2 running ...");
                Thread.sleep(200);
                System.out.println("T2 running ...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release();
            }
        }).start();

    }
}
