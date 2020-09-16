/*
 * File Name:T02_HowToCreateThread is created on 2020-09-10 00:14 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c0_basic;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author Zhao Xiaoli
 * @Description : T02_HowToCreateThread
 * @date 2020-09-10 00:14
 * @since JDK 1.8
 */
public class T02_HowToCreateThread {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello MyThread");
        }
    }

    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello MyRun");
        }
    }

    static class MyCall implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("Hello MyCall");
            return "success";
        }
    }

    public static void main(String[] args) {
        //启动线程的五种方式
        new MyThread().start();
        new Thread(new MyRun()).start();
        new Thread(() -> System.out.println("Hello Lambda")).start();
        Thread t = new Thread(new FutureTask<String>(new MyCall()));
        t.start();

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> System.out.println("Hello ThreadPool"));
        executorService.shutdown();
    }
}
