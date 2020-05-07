/*
 * File Name:T01_Use_LockSupport is created on 2020-05-06 17:50 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c13_interview.A1B2C3;

import java.util.concurrent.locks.LockSupport;

/**
 * @author tangwan
 * @Description : T01_Use_LockSupport
 * @date 2020-05-06 17:50
 * @since JDK 1.8
 */
public class T01_Use_LockSupport extends T00_Base {

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {

        t1 = new Thread(() -> {
            for (char c : aI) {
                System.out.print(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        }, "t1");

        t2 = new Thread(() -> {
            for (char c : aC) {
                LockSupport.park();
                System.out.print(c);
                LockSupport.unpark(t1);
            }
        }, "t2");

        t1.start();
        t2.start();
    }

}
