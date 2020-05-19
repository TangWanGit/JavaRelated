/*
 * File Name:T01_MergeSort is created on 2020-05-18 17:55 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c03_merge_sort_and_random_sort;

import com.tangwan.algorithm.c01_bs.T00_Base;

/**
 * @author Zhao Xiaoli
 * @Description : T01_MergeSort
 * @date 2020-05-18 17:55
 * @since JDK 1.8
 */
public class T01_MergeSort extends T00_Base {
    public static void main(String[] args) {
        int maxValue = 100;
        int maxSize = 100;
        int testTimes = 500_000;
        boolean succeed = true;

        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            mergeSort1(arr1);
            mergeSort2(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }

        System.out.println(succeed ? "Nice!" : "Oops!");
    }

    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    /**
     * 递归排序
     *
     * @param arr
     * @param L
     * @param R
     */
    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }

        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;

        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }

        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    public static void mergeSort2(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        int N = arr.length;
        // 当前有序的，左组长度
        int mergeSize = 1;
        while (mergeSize < N) {
            int L = 0;
            while (L < N) {
                int M = L + mergeSize - 1;
                if (M >= N) {
                    break;
                }

                int R = Math.min(M + mergeSize, N - 1);
                merge(arr, L, M, R);
                L = R + 1;
            }
            if (mergeSize > N / 2) {
                break;
            }
            mergeSize <<= 1;
        }
    }

}
