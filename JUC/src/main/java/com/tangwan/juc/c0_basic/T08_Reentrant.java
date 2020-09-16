/*
 * File Name:T08_Reentrant is created on 2020-09-12 11:51 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c0_basic;

import java.util.concurrent.TimeUnit;

/**
 * @author Zhao Xiaoli
 * @Description : T08_Reentrant
 * @date 2020-09-12 11:51
 * @since JDK 1.8
 */
public class T08_Reentrant {
    synchronized void m() throws InterruptedException {
        System.out.println("m start");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("m end");
    }

    public static void main(String[] args) throws InterruptedException {
        new TT().m();
    }
}

class TT extends T08_Reentrant {
    @Override
    synchronized void m() throws InterruptedException {
        System.out.println("child m start");
        super.m();
        System.out.println("child m end");
    }
}
