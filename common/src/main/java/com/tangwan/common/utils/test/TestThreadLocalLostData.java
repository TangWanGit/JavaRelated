/*
 * File Name:TestThreadLocalLostData is created on 2021/3/18 11:53 上午 by Zhao Xiaoli
 *
 * Copyright (c) 2021, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.common.utils.test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Zhao Xiaoli
 * @Description : 模拟ThreadLocal内存泄露导致OOM
 * JVM启动参数 -Xms20M -Xmx20M -Xmn10M
 * @date 2021/3/18 11:53 上午
 * @since JDK 1.8
 */
public class TestThreadLocalLostData {
    //线程本地存储变量
    private static ThreadLocal<Integer> THREAD_LOCAL_NUM = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public static void main(String[] args) {
        // 是否调用remove方法
        boolean doRemove = false;
        // 加锁，让多个线程串行执行，避免多个线程同时占用内存导致的内存溢出问题
        Object lockObj = new Object();
        // 开启20个线程
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        // 为了不重复使用线程，用Map标记一下已经已使用过的线程，
        Map<Long, Integer> threadIdMap = new ConcurrentHashMap<>();
        // 循环向线程变量中设置数据 1024 * 1024 = 1M
        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                synchronized (lockObj) {
                    Integer num = threadIdMap.putIfAbsent(Thread.currentThread().getId(), 1);
                    if (num == null) {
                        ThreadLocal<Byte[]> threadLocal = new ThreadLocal<>();
                        threadLocal.set(new Byte[1024 * 1024]);
                        if (doRemove) {
                            // 解决内存泄露关键
                            threadLocal.remove();
                        }
                        // 将threadLocal置为空引用，利于回收
                        threadLocal = null;
                        // 手工回收
                        System.gc();
                        try {
                            // 调用GC后不一定会马上回收
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(Thread.currentThread().getName());
                }
            });
            // System.out.println(i);
        }
    }

    /**
     * 线程本地存储变量加 5
     */
    private static void add10ByThreadLocal() {
        for (int i = 0; i < 5; i++) {
            Integer n = THREAD_LOCAL_NUM.get();
            n += 1;
            System.gc();

            THREAD_LOCAL_NUM.set(n);

            System.out.println(Thread.currentThread().getName() + " : ThreadLocal num=" + n);
        }
    }
}
