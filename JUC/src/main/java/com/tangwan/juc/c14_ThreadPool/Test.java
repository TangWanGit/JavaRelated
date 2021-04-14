/*
 * File Name:Test is created on 2021/4/10 2:46 下午 by Zhao Xiaoli
 *
 * Copyright (c) 2021, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c14_ThreadPool;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Zhao Xiaoli
 * @Description : Test
 * @date 2021/4/10 2:46 下午
 * @since JDK 1.8
 */
public class Test {
  public static   AtomicInteger atomicInteger = new AtomicInteger(1);
    public static void main(String[] args) throws InterruptedException {
        int snap = atomicInteger.get();
        new Thread(() -> atomicInteger.incrementAndGet()).start();

        Thread.sleep(100);

        System.out.println(snap);
        System.out.println(atomicInteger.get());
    }
}
