/*
 * File Name:T19_Yeild is created on 2021/4/10 3:00 下午 by Zhao Xiaoli
 *
 * Copyright (c) 2021, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c14_ThreadPool;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import sun.misc.Unsafe;

/**
 * @author Zhao Xiaoli
 * @Description : T19_Yeild
 * @date 2021/4/10 3:00 下午
 * @since JDK 1.8
 */
public class T19_Yeild {

    public static Unsafe UNSAFE;
    public static long A_OFFSET;
    public static long COUNTER_OFFSET;

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            UNSAFE = (Unsafe)theUnsafe.get(null);
            A_OFFSET = UNSAFE.staticFieldOffset(T19_Yeild.class.getDeclaredField("a"));
            COUNTER_OFFSET = UNSAFE.staticFieldOffset(T19_Yeild.class.getDeclaredField("counter"));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static int a = 0;
    public static int counter = 1;

    public static void lock() {
        for (; ; ) {
            if (UNSAFE.compareAndSwapInt(T19_Yeild.class, COUNTER_OFFSET, 1, 0)) {
                break;
            }
            //Thread.yield();
        }
    }

    public static void unlock() {
        counter = 1;
    }

    public static void incr() {
        lock();
        a++;
        unlock();
    }

    public static void execute() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            executorService.execute(() -> incr());
        }

        executorService.shutdown();
        //executorService.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println(System.currentTimeMillis() - start + " " + a);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            execute();
        }
    }
}
