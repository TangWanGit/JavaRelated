/*
 * File Name:T06_Knapsack is created on 2020-07-02 11:10 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c11_dynamic_programming_1;

/**
 * @author Zhao Xiaoli
 * @Description : T06_Knapsack
 * 背包问题
 * @date 2020-07-02 11:10
 * @since JDK 1.8
 */
public class T06_Knapsack {
    public static void main(String[] args) {
        int[] weights = {3, 2, 4, 7};
        int[] values = {5, 6, 3, 19};
        int bag = 11;
        System.out.println(maxValue(weights, values, bag));
        System.out.println(dpWay(weights, values, bag));
    }

    private static int maxValue(int[] weights, int[] values, int bag) {
        return process(weights, values, 0, bag);
    }

    private static int process(int[] weights, int[] values, int index, int rest) {
        if (rest < 0) {
            return -1;
        }
        if (index == weights.length) {
            return 0;
        }

        int p1 = process(weights, values, index + 1, rest);
        int p2 = -1;
        int p2Next = process(weights, values, index + 1, rest - weights[index]);
        if (p2Next != -1) {
            p2 = values[index] + p2Next;
        }

        return Math.max(p1, p2);
    }

    private static int dpWay(int[] weights, int[] values, int bag) {
        int N = weights.length;
        int[][] dp = new int[N + 1][bag + 1];
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 1; rest <= bag; rest++) {
                dp[index][rest] = dp[index + 1][rest];
                if (rest > weights[index]) {
                    dp[index][rest] = Math.max(dp[index][rest], dp[index + 1][rest - weights[index]] + values[index]);
                }
            }
        }

        return dp[0][bag];
    }
}
