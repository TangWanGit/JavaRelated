/*
 * File Name:T07_CompletableFuture is created on 2020-05-07 09:19 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c14_ThreadPool;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import com.tangwan.juc.StopWatcher;

/**
 * @author Zhao Xiaoli
 * @Description : T07_CompletableFuture
 * <p>
 * 假设你能够提供一个服务
 * 这个服务查询各大电商网站同一类产品的价格并汇总展示
 * @date 2020-05-07 09:19
 * @since JDK 1.8
 */
public class T07_CompletableFuture {
    public static void main(String[] args) {
        StopWatcher watcher = new StopWatcher();
        watcher.start();
        priceOfTM();
        priceOfTB();
        priceOfJD();

        watcher.endAndFinish();

        watcher.start();

        CompletableFuture<Double> futureTM = CompletableFuture.supplyAsync(T07_CompletableFuture::priceOfTM);
        CompletableFuture<Double> futureTB = CompletableFuture.supplyAsync(T07_CompletableFuture::priceOfTB);
        CompletableFuture<Double> futureJD = CompletableFuture.supplyAsync(T07_CompletableFuture::priceOfJD);

        // 异步处理会比同步的快很多
        CompletableFuture.allOf(futureJD, futureTB, futureTM).join();

        watcher.endAndFinish();

        // 可以对异步拿到的结果进行处理
        CompletableFuture.supplyAsync(T07_CompletableFuture::priceOfTM).thenApply(String::valueOf)
            .thenApply(str -> "price " + str).thenAccept(System.out::println);

        try {
            // 保持阻塞
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Double priceOfJD() {
        delay();
        return 3.00;
    }

    private static Double priceOfTB() {
        delay();
        return 2.00;
    }

    private static Double priceOfTM() {
        delay();
        return 1.00;
    }

    private static void delay() {
        //int time = new Random().nextInt(500);
        int time = 200;
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("After %s sleep! \n", time);
    }
}
