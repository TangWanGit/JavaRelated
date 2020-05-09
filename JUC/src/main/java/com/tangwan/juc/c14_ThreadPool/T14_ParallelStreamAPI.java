/*
 * File Name:T14_ParallelStreamAPI is created on 2020-05-07 11:51 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c14_ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.tangwan.juc.StopWatcher;

/**
 * @author tangwan
 * @Description : T14_ParallelStreamAPI
 * @date 2020-05-07 11:51
 * @since JDK 1.8
 */
public class T14_ParallelStreamAPI {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 10_000; i++) {
            nums.add(1_000_000 + r.nextInt(1000_000));
        }

        StopWatcher watcher = new StopWatcher();
        watcher.start();
        nums.forEach(T14_ParallelStreamAPI::isPrime);
        watcher.endAndFinish();

        watcher.start();
        nums.parallelStream().forEach(T14_ParallelStreamAPI::isPrime);
        watcher.endAndFinish();
    }

    private static boolean isPrime(Integer num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
