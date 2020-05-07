/*
 * File Name:T10_FixedThreadPool is created on 2020-05-07 09:56 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c14_ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.tangwan.juc.StopWatcher;

/**
 * @author Zhao Xiaoli
 * @Description : T10_FixedThreadPool
 * @date 2020-05-07 09:56
 * @since JDK 1.8
 */
public class T10_FixedThreadPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        StopWatcher watcher = new StopWatcher();
        watcher.start();
        getPrime(1, 200_000);
        watcher.endAndFinish();

        int cpuCoreNum = 4;
        // 核心线程为4个，多余的任务会被放在queue里
        ExecutorService executorService = Executors.newFixedThreadPool(cpuCoreNum);

        MyTask t1 = new MyTask(1, 80_000);
        MyTask t2 = new MyTask(80_001, 130_000);
        MyTask t3 = new MyTask(130_001, 170_000);
        MyTask t4 = new MyTask(170_001, 180_000);
        MyTask t5 = new MyTask(180_001, 190_000);
        MyTask t6 = new MyTask(190_001, 200_000);

        Future<List<Integer>> f1 = executorService.submit(t1);
        Future<List<Integer>> f2 = executorService.submit(t2);
        Future<List<Integer>> f3 = executorService.submit(t3);
        Future<List<Integer>> f4 = executorService.submit(t4);
        Future<List<Integer>> f5 = executorService.submit(t5);
        Future<List<Integer>> f6 = executorService.submit(t6);

        System.out.println(executorService);

        watcher.start();
        f1.get();
        f2.get();
        f3.get();
        f4.get();
        f5.get();
        f6.get();
        watcher.endAndFinish();

        executorService.shutdown();
    }

    static class MyTask implements Callable<List<Integer>> {
        private int start;
        private int end;

        public MyTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public List<Integer> call() throws Exception {
            return getPrime(start, end);
        }
    }

    static List<Integer> getPrime(int start, int end) {
        List<Integer> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
