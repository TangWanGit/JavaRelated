/*
 * File Name:T04_BSNearLeft is created on 2020-05-10 21:56 by tangwan
 *
 * tangwan
 *
 */
package com.tangwan.algorithm.c01_bs;

/**
 * @author tangwan
 * @Description : T04_BSNearLeft
 * @date 2020-05-10 21:56
 * @since JDK 1.8
 */
public class T04_BSNearLeft extends T00_Base {
    public static void main(String[] args) {
        int testTime = 500_000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            comparator(arr);

            int value = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
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

    /**
     * 在arr上，找满足>=value的最左位置
     *
     * @param arr
     * @param value
     *
     * @return
     */
    public static int nearestIndex(int[] arr, int value) {
        int L = 0;
        int R = arr.length - 1;
        // 记录最左的对号
        int index = -1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                R = mid - 1;

            } else {
                L = mid + 1;
            }
        }
        return index;
    }

    public static int test(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= value) {
                return i;
            }
        }
        return -1;
    }
}
