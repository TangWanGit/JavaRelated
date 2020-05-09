/*
 * File Name:PS is created on 2020-05-09 15:34 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jmh;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Zhao Xiaoli
 * @Description : PS
 * @date 2020-05-09 15:34
 * @since JDK 1.8
 */
public class PS {
    static List<Integer> nums = new ArrayList<>();

    static {
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            nums.add(1_000_000 + r.nextInt(1_000_000));
        }
    }

    static void foreach() {
        nums.forEach(PS::isPrime);
    }

    static void parallel() {
        nums.parallelStream().forEach(PS::isPrime);
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
