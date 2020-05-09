/*
 * File Name:T16_ListenableFuture is created on 2020-05-07 15:29 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c14_ThreadPool;

import java.util.concurrent.Executors;

import org.checkerframework.checker.nullness.qual.Nullable;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

/**
 * @author Zhao Xiaoli
 * @Description : T16_ListenableFuture
 * 代码不好维护
 * @date 2020-05-07 15:29
 * @since JDK 1.8
 */
public class T16_ListenableFuture {
    public static void main(String[] args) {
        ListeningExecutorService listeningExecutorService =
            MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(2));

        ListenableFuture<Integer> future = listeningExecutorService.submit(() -> 8);

        Futures.addCallback(future, new FutureCallback<Integer>() {
            @Override
            public void onSuccess(@Nullable Integer result) {
                System.out.println(result);
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        }, listeningExecutorService);

        listeningExecutorService.shutdown();
    }
}
