/*
 * File Name:T13_ForkJoinPool is created on 2020-05-07 10:31 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c14_ThreadPool;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * @author Zhao Xiaoli
 * @Description : T13_ForkJoinPool
 * @date 2020-05-07 10:31
 * @since JDK 1.8
 */
public class T13_ForkJoinPool {
    static int[] nums = new int[1_000_000];
    static final int MAX_NUM = 50_000;
    static Random r = new Random();

    static {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(100);
        }

        System.out.println("---" + Arrays.stream(nums).sum());
    }

    public static void main(String[] args) {
        //ForkJoinPool fjp = new ForkJoinPool();
        //AddTask addTask = new AddTask(0, nums.length);
        //fjp.execute(addTask);

        ForkJoinPool fjp = new ForkJoinPool();
        AddTaskReturn addTask = new AddTaskReturn(0, nums.length);
        fjp.execute(addTask);

        System.out.println(addTask.join());

    }

    static class AddTask extends RecursiveAction {

        int start, end;

        public AddTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start <= MAX_NUM) {
                long sum = 0L;
                for (int i = start; i < end; i++) {
                    sum += nums[i];
                }
                System.out.println("from:" + start + " to:" + end + " = " + sum);
            } else {
                int middle = start + (end-start)/2;
                AddTask sub1 = new AddTask(start, middle);
                AddTask sub2 = new AddTask(middle, end);

                sub1.fork();
                sub2.fork();
            }
        }
    }

    static class AddTaskReturn extends RecursiveTask<Long> {

        int start, end;

        public AddTaskReturn(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start <= MAX_NUM) {
                long sum = 0L;
                for (int i = start; i < end; i++) {
                    sum += nums[i];
                }
                return sum;
            } else {
                int middle = start + (end-start)/2;
                AddTaskReturn sub1 = new AddTaskReturn(start, middle);
                AddTaskReturn sub2 = new AddTaskReturn(middle, end);

                sub1.fork();
                sub2.fork();
                return sub1.join() + sub2.join();
            }
        }
    }
}
