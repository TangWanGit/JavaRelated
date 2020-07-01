/*
 * File Name:T05_ConvertToLetterString is created on 2020-07-01 09:43 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c11_dynamic_programming_1;

/**
 * @author Zhao Xiaoli
 * @Description : T05_ConvertToLetterString
 * @date 2020-07-01 09:43
 * @since JDK 1.8
 */
public class T05_ConvertToLetterString {
    public static void main(String[] args) {
        System.out.println(number("11111"));
        System.out.println(dpWays2("11111"));
        System.out.println(dpWays("11111"));
    }

    private static int number(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        return process(str.toCharArray(), 0);
    }

    // str[0...i-1]已经转化完了，固定了
    // i之前的位置，如何转化已经做过决定了, 不用再关心
    // i... 有多少种转化的结果
    private static int process(char[] chars, int i) {
        if (i == chars.length) {
            return 1;
        }
        if (chars[i] == '0') {
            return 0;
        }
        if (chars[i] == '1') {
            int res = process(chars, i + 1);
            if (i + 1 < chars.length) {
                res += process(chars, i + 2);
            }
            return res;
        }
        if (chars[i] == '2') {
            int res = process(chars, i + 1);
            if (i + 1 < chars.length && (chars[i + 1] >= '0' && chars[i + 1] <= '6')) {
                // (i和i+1)作为单独的部分，后续有多少种方法
                res += process(chars, i + 2);
            }
            return res;
        }
        return process(chars, i + 1);
    }

    private static int dpWays2(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int N = str.length();
        int[] dp = new int[N + 1];
        dp[N] = 1;
        for (int i = N - 1; i >= 0; i--) {
            if (chars[i] == '0') {
                dp[i] = 0;
            }
            if (chars[i] == '1') {
                dp[i] = dp[i + 1];
                if (i + 1 < N) {
                    dp[i] += dp[i + 2];
                }
            }
            if (chars[i] == '2') {
                dp[i] = dp[i + 1];
                if (i + 1 < N && (chars[i + 1] >= '0' && chars[i + 1] <= '6')) {
                    // (i和i+1)作为单独的部分，后续有多少种方法
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }

    private static int dpWays(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int N = str.length();
        int[] dp = new int[N + 1];
        dp[N] = 1;
        for (int i = N - 1; i >= 0; i--) {
            if (chars[i] == '0') {
                dp[i] = 0;
            } else if (chars[i] == '1') {
                dp[i] = dp[i + 1];
                if (i + 1 < N) {
                    dp[i] += dp[i + 2];
                }
            } else if (chars[i] == '2') {
                dp[i] = dp[i + 1];
                if (i + 1 < N && (chars[i + 1] >= '0' && chars[i + 1] <= '6')) {
                    // (i和i+1)作为单独的部分，后续有多少种方法
                    dp[i] += dp[i + 2];
                }
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }
}
