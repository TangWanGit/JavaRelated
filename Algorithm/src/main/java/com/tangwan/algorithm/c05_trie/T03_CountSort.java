/*
 * File Name:T03_CountSort is created on 2020-05-25 10:07 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c05_trie;

import com.tangwan.algorithm.c01_bs.T00_Base;

/**
 * @author Zhao Xiaoli
 * @Description : T03_CountSort
 * 大概是桶排序
 * @date 2020-05-25 10:07
 * @since JDK 1.8
 */
public class T03_CountSort extends T00_Base {
    public static void main(String[] args) {
        int maxSize = 200;
        int maxValue = 200;

        int testTimes = 100_000;
        boolean succeed = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            countSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                System.out.println("oops");
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }

        System.out.println(succeed ? "Nice" : "Oops");

    }

    // 桶排序？
    // 0~200
    public static int[] countSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = arr[i] > max ? arr[i] : max;
        }

        int[] bucket = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }

        int i = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j]-- > 0) {
                arr[i++] = j;
            }
        }
        return arr;
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int)((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((maxValue + 1) * Math.random());
        }
        return arr;
    }

}
