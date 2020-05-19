/*
 * File Name:T08_GetMax is created on 2020-05-18 17:40 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c02_list;

/**
 * @author Zhao Xiaoli
 * @Description : T08_GetMax
 * 递归二分法 实现获取数组中的最大值
 * @date 2020-05-18 17:40
 * @since JDK 1.8
 */
public class T08_GetMax {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(getMax(arr));
    }

    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }

        // 中点
        int mid = L + ((R - L) >> 1);
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);

        return Math.max(leftMax, rightMax);
    }

}
