/*
 * File Name:T06_BSAwesome is created on 2020-05-10 23:38 by tangwan
 *
 * tangwan
 *
 */
package com.tangwan.algorithm.c01_bs;

/**
 * @author tangwan
 * @Description : T06_BSAwesome
 * @date 2020-05-10 23:38
 * @since JDK 1.8
 */
public class T06_BSAwesome {

    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }

        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left < right) {
            mid = (left + right) << 1;
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return left;
    }
}
