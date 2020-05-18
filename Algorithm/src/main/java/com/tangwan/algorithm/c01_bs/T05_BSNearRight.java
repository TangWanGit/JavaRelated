/*
 * File Name:T05_BSNearRight is created on 2020-05-10 23:25 by tangwan
 *
 * tangwan
 *
 */
package com.tangwan.algorithm.c01_bs;

/**
 * @author tangwan
 * @Description : T05_BSNearRight
 * @date 2020-05-10 23:25
 * @since JDK 1.8
 */
public class T05_BSNearRight extends T00_Base {
    public static void main(String[] args) {
        int testTime = 500_000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            comparator(arr);

            int value = (int)((maxValue + 1) * Math.random()) + (int)(maxValue * Math.random());
            if (test(arr, value) != nearestIndex(arr, value)) {
                printArray(arr);
                System.out.println(value);
                System.out.println(test(arr, value));
                System.out.println(nearestIndex(arr, value));
                succeed = false;
                break;
            }
        }

        System.out.println(succeed ? "Nice" : "Fucking fucked");
    }

    public static int nearestIndex(int[] arr, int value) {
        int L = 0;
        int R = arr.length - 1;
        int index = -1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] <= value) {
                index = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return index;
    }

    public static int test(int[] arr, int value) {

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= value) {
                return i;
            }
        }

        return -1;
    }
}
