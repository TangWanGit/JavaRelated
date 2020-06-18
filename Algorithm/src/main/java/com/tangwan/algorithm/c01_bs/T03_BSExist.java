/*
 * File Name:T03_BSExist is created on 2020-05-10 21:48 by tangwan
 *
 * tangwan
 *
 */
package com.tangwan.algorithm.c01_bs;

import java.util.Arrays;

/**
 * @author tangwan
 * @Description : T03_BSExist
 * @date 2020-05-10 21:48
 * @since JDK 1.8
 */
public class T03_BSExist {
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
            if (test(arr, value) != exist(arr, value)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    private static boolean test(int[] arr, int value) {
        for (int cur : arr) {
            if (cur == value) {
                return true;
            }
        }
        return false;
    }

    private static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int)((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
        }
        return arr;
    }

    /**
     * num是否在sortedArr中存在
     *
     * @param sortedArr
     * @param num
     *
     * @return
     */
    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }

        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;
        while (L < R) {
            // mid = (L+R) / 2;
            // L 10亿  R 18亿
            // mid = L + (R - L) / 2
            // N / 2    N >> 1
            // mid = (L + R) / 2
            mid = L + ((R - L) >> 1);
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return sortedArr[L] == num;
    }
}
