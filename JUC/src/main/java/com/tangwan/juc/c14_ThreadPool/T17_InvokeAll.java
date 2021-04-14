/*
 * File Name:T17_InvokeAll is created on 2021/4/9 11:06 上午 by Zhao Xiaoli
 *
 * Copyright (c) 2021, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c14_ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Zhao Xiaoli
 * @Description : T17_InvokeAll
 * @date 2021/4/9 11:06 上午
 * @since JDK 1.8
 */
public class T17_InvokeAll {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(1),
            new ThreadFactoryBuilder().setNameFormat("task-[%d]").build(), new CancellationExceptionPolicy());

        List<Callable<String>> futureTasks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            futureTasks.add(new MyTask(i));
        }

        try {
            List<Future<String>> futures = executor.invokeAll(futureTasks);

            for (Future<String> future : futures) {
                System.out.println("future.get : " + future.get());
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("end");
    }

    static class MyTask implements Callable<String> {
        private int index;

        public MyTask(int index) {
            this.index = index;
        }

        @Override
        public String call() throws Exception {
            System.out.println(Thread.currentThread().getName() + ": task execute " + index);
            sleep(500);
            return "task " + index;
        }
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class DiscardPolicy implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println(Thread.currentThread().getName() + ": reject task ");
        }
    }

    public static class CancellationExceptionPolicy implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println(Thread.currentThread().getName() + ": reject task and throw exception");
            throw new CancellationException("cancel thread");
        }
    }

    public static class ThreadFactoryBuilder {
        private String nameFormat = null;

        public ThreadFactoryBuilder setNameFormat(String nameFormat) {
            String.format(nameFormat, 0); // fail fast if the format is bad or null
            this.nameFormat = nameFormat;
            return this;
        }

        public ThreadFactory build() {
            return build(this);
        }

        private static ThreadFactory build(ThreadFactoryBuilder builder) {
            final String nameFormat = builder.nameFormat;
            final ThreadFactory backingThreadFactory = Executors.defaultThreadFactory();
            final AtomicLong count = (nameFormat != null) ? new AtomicLong(0) : null;
            return runnable -> {
                Thread thread = backingThreadFactory.newThread(runnable);
                if (nameFormat != null) {
                    thread.setName(String.format(nameFormat, count.getAndIncrement()));
                }
                thread.setDaemon(false);
                return thread;
            };
        }
    }
}
