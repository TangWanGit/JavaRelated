/*
 * File Name:T03_Callable is created on 2020-05-06 19:41 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c14_ThreadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author tangwan
 * @Description : T03_Callable
 * @date 2020-05-06 19:41
 * @since JDK 1.8
 */
public class T03_Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> c = () -> "Hello Callable";

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(c);

        // 阻塞
        System.out.println(future.get());

        executorService.shutdown();
    }
}
