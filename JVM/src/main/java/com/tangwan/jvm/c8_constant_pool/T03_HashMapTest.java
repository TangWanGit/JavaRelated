/*
 * File Name:T03_HashMapTest is created on 2020-11-11 15:57 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c8_constant_pool;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Zhao Xiaoli
 * @Description : T03_HashMapTest
 * @date 2020-11-11 15:57
 * @since JDK 1.8
 */
public class T03_HashMapTest {

    static class HashMapThread extends Thread {
        private static AtomicInteger incr = new AtomicInteger();
        private static Map<Integer, Integer> map = new HashMap<>();

        @Override
        public void run() {
            while (incr.get() < 10000000) {
                map.put(incr.get(), incr.get());
                incr.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) {
        HashMapThread thread1 = new HashMapThread();
        HashMapThread thread2 = new HashMapThread();
        HashMapThread thread3 = new HashMapThread();
        HashMapThread thread4 = new HashMapThread();
        HashMapThread thread5 = new HashMapThread();

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

    }
}
