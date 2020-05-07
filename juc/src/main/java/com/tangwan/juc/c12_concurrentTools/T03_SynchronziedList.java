/*
 * File Name:T02_CopyOnWriteList is created on 2020-05-06 16:27 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c12_concurrentTools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.tangwan.juc.ComputeTimeTest;

/**
 * @author tangwan
 * @Description : T02_CopyOnWriteList
 * 速度快
 * @date 2020-05-06 16:27
 * @since JDK 1.8
 */
public class T03_SynchronziedList {
    public static void main(String[] args) {
        List<String> lists = Collections.synchronizedList(new ArrayList<>());
        Thread[] threads = new Thread[100];

        Random random = new Random();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1_000; j++) {
                    lists.add("a" + random.nextInt(10_000));
                }
            });
        }

        ComputeTimeTest.runAndComputeTime(threads, lists);
    }
}
