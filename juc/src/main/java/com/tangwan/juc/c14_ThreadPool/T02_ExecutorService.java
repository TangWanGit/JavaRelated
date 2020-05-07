/*
 * File Name:T02_ExecutorService is created on 2020-05-06 19:40 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c14_ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Zhao Xiaoli
 * @Description : T02_ExecutorService
 * @date 2020-05-06 19:40
 * @since JDK 1.8
 */
public class T02_ExecutorService {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(() -> System.out.println("Hello ExecutorService"));

        executorService.shutdown();
    }
}
