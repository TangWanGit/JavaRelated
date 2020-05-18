/*
 * File Name:T01_SelectionSort is created on 2020-05-10 21:11 by tangwan
 *
 * tangwan
 *
 */
package com.tangwan.algorithm.c01_bs;

/**
 * @author tangwan
 * @Description : T01_SelectionSort
 * <p>
 * 选择排序
 * <p>
 * @date 2020-05-10 21:11
 * @since JDK 1.8
 */
public class T01_SelectionSort extends T00_Base {

    public static void main(String[] args) {
        int testTime = 500_000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;

        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);

            selectionSort(arr1);
            comparator(arr2);

            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }

        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
        if (succeed) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            printArray(arr);
            selectionSort(arr);
            printArray(arr);
        }

    }

    private static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }

            swap(arr, i, minIndex);
        }
    }
}


