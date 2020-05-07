/*
 * File Name:T01_ReentrantLock1 is created on 2020-04-21 17:31 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c6_AQSLock;

import java.util.concurrent.TimeUnit;

/**
 * @author tangwan
 * @Description : T01_ReentrantLock1
 * reentrantlock用于替代synchronized
 * 本例中由于m1锁定this,只有m1执行完毕的时候,m2才能执行
 * 这里是复习synchronized最原始的语义
 * @date 2020-04-21 17:31
 * @since JDK 1.8
 */
public class T01_ReentrantLock1 {

    synchronized void m1() {
        for (int i = 0; i < 10; i++) {

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(i);

            if (i == 2) {
                m2();
            }
        }
    }

    synchronized void m2() {
        System.out.println("m2 ...");
    }

    public static void main(String[] args) throws InterruptedException {
        T01_ReentrantLock1 t = new T01_ReentrantLock1();
        new Thread(t::m1).start();
        TimeUnit.SECONDS.sleep(1);
    }
}
