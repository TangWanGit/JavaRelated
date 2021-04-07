/*
 * File Name:TestCyclicBarrier is created on 2021/3/21 2:53 下午 by Zhao Xiaoli
 *
 * Copyright (c) 2021, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.common.utils.test;

import java.util.concurrent.Semaphore;

/**
 * @author Zhao Xiaoli
 * @Description : TestCyclicBarrier
 * @date 2021/3/21 2:53 下午
 * @since JDK 1.8
 */
public class TestCyclicBarrier {
    public static void main(String[] args) {
        int N = 8; //工人数
        Semaphore semaphore = new Semaphore(5); //机器数目
        for (int i = 0; i < N; i++) {
            new Worker(i, semaphore).start();
        }
    }

    static class Worker extends Thread {
        private int num;
        private Semaphore semaphore;

        public Worker(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人" + this.num + "占用一个机器在生产...");
                Thread.sleep(2000);
                System.out.println("工人" + this.num + "释放出机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}