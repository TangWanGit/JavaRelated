/*
 * File Name:T01_CacheLinePadding is created on 2020-05-07 15:33 by tangwan
 *
 * tangwan
 *
 */
package com.tangwan.juc.c15_FalseSharing;

import com.google.common.base.Stopwatch;

/**
 * @author tangwan
 * @Description : T01_CacheLinePadding
 * @date 2020-05-07 15:33
 * @since JDK 1.8
 */
public class T01_CacheLinePadding {

    private static class T {
        public volatile long x = 0L;
    }

    public static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (long i = 0; i < 1000_0000L; i++) {
                arr[0].x = i;
            }
        });

        Thread t2 = new Thread(() -> {
            for (long i = 0; i < 1000_0000L; i++) {
                arr[1].x = i;
            }
        });

        Stopwatch stopwatch = Stopwatch.createStarted();

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(stopwatch.toString());
    }
}
