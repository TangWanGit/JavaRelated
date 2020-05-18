/*
 * File Name:T03_BSExist is created on 2020-05-10 21:48 by tangwan
 *
 * tangwan
 *
 */
package com.tangwan.algorithm.c01_bs;

/**
 * @author tangwan
 * @Description : T03_BSExist
 * @date 2020-05-10 21:48
 * @since JDK 1.8
 */
public class T03_BSExist {

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
