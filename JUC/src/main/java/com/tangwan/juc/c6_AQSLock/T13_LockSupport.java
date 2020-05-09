/*
 * File Name:T13_LockSupport is created on 2020-04-23 15:31 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c6_AQSLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author tangwan
 * @Description : T13_LockSupport
 * @date 2020-04-23 15:31
 * @since JDK 1.8
 */
public class T13_LockSupport {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if (i == 5) {
                    LockSupport.park();
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();
        //LockSupport.unpark(t);

        TimeUnit.SECONDS.sleep(8);
        System.out.println("after 8 seconds");

        LockSupport.unpark(t);
    }
}
