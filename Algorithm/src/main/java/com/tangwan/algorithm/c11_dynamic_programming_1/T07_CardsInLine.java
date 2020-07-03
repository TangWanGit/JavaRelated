/*
 * File Name:T07_CardsInLine is created on 2020-07-03 09:35 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c11_dynamic_programming_1;

/**
 * @author Zhao Xiaoli
 * @Description : T07_CardsInLine
 * 两个人可以从数组左边或右边获取数据，每个人都按照自己利益最大化获取
 * @date 2020-07-03 09:35
 * @since JDK 1.8
 */
public class T07_CardsInLine {
    public static void main(String[] args) {
        int[] arr = {4, 7, 9, 5, 19, 29, 80, 4};
        // A 4 9 19 80
        // B 7 5 29 4
        System.out.println(win1(arr));
        System.out.println(win2(arr));
    }

    private static int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        return f(arr, 0, arr.length - 1);
    }

    private static int f(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        return Math.max(arr[L] + s(arr, L + 1, R), arr[R] + s(arr, L, R - 1));
    }

    private static int s(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        return Math.min(f(arr, L + 1, R), f(arr, L, R - 1));

    }

    private static int win2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] f = new int[N][N];
        int[][] s = new int[N][N];
        for (int i = 0; i < N; i++) {
            f[i][i] = arr[i];
        }

        // 0,0 右下方移动
        // 0,1
        // 0,2
        // 0,N-1
        for (int col = 1; col < N; col++) {
            int L = 0;
            int R = col;
            while (L < N && R < N) {
                f[L][R] = Math.max(arr[L] + s[L + 1][R], arr[R] + s[L][R - 1]);
                s[L][R] = Math.min(f[L + 1][R], f[L][R - 1]);
                L++;
                R++;
            }
        }

        return Math.max(f[0][N - 1], s[0][N - 1]);
    }
}
