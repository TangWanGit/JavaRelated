/*
 * File Name:ComputeTimeTest is created on 2020-05-06 16:28 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author tangwan
 * @Description : ComputeTimeTest
 * @date 2020-05-06 16:28
 * @since JDK 1.8
 */
public class ComputeTimeTest {
    public static void runAndComputeTime(Thread[] threads, Collection collection) {
        StopWatcher watcher = new StopWatcher();
        watcher.start();

        Arrays.stream(threads).forEach(Thread::start);
        Arrays.stream(threads).forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        watcher.end();
        watcher.finish();
        System.out.println(collection.size());
    }
}
