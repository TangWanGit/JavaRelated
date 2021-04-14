/*
 * File Name:T18_InvokeAny is created on 2021/4/10 11:04 上午 by Zhao Xiaoli
 *
 * Copyright (c) 2021, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c14_ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Zhao Xiaoli
 * @Description : T18_InvokeAny
 * @date 2021/4/10 11:04 上午
 * @since JDK 1.8
 */
public class T18_InvokeAny {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 4, 1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(1),
            new T17_InvokeAll.ThreadFactoryBuilder().setNameFormat("task-[%d]").build(),
            new ThreadPoolExecutor.DiscardPolicy());

        List<Callable<String>> futureTasks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            futureTasks.add(new MyTask(i));
        }
        try {
            String s = executor.invokeAny(futureTasks);
            System.out.println("res: " + s);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
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
            //Thread.sleep(500);
            //System.out.println(Thread.currentThread().getName() + ": task execute end " + index);
            //Thread.sleep(10);
            return "task " + index;
        }
    }
}
