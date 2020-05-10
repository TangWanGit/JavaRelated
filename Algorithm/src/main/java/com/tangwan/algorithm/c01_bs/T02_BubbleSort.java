/*
 * File Name:T02_BubbleSort is created on 2020-05-10 21:28 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c01_bs;

/**
 * @author Zhao Xiaoli
 * @Description : T02_BubbleSort
 * <p>
 * 冒泡排序
 * <p>
 * @date 2020-05-10 21:28
 * @since JDK 1.8
 */
public class T02_BubbleSort extends T00_Base {
    public static void main(String[] args) {
        int testTime = 500_000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;

        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);

            bubbleSort(arr1);
            comparator(arr2);

            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }

        System.out.println(succeed ? "Nice" : "Fucking fucked");

        if (succeed) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            printArray(arr);
            bubbleSort(arr);
            printArray(arr);
        }
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int e = arr.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}
