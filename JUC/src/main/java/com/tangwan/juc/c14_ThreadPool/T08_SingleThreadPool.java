/*
 * File Name:T08_SingleThreadPool is created on 2020-05-07 09:50 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c14_ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tangwan
 * @Description : T08_SingleThreadPool
 * @date 2020-05-07 09:50
 * @since JDK 1.8
 */
public class T08_SingleThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            final int j = i;
            executorService.execute(() -> System.out.println(j + " " + Thread.currentThread().getName()));
        }
    }
}
