/*
 * File Name:T07_EventTimesOddTimes is created on 2020-05-10 23:48 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c01_bs;

/**
 * @author Zhao Xiaoli
 * @Description : T07_EventTimesOddTimes
 * @date 2020-05-10 23:48
 * @since JDK 1.8
 */
public class T07_EventTimesOddTimes {
    public static void main(String[] args) {
        int a = 5;
        int b = 7;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a);
        System.out.println(b);

        System.out.println(Integer.toBinaryString(a));
        System.out.println(bit1counts(a));

        int[] arr1 = {3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1};
        printOddTimesNum1(arr1);

        int[] arr2 = {4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2};
        printOddTimesNum2(arr2);
    }

    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println(eor);
    }

    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }

        int rightOne = eor & (~eor + 1);
        int onlyOne = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                onlyOne ^= arr[i];
            }
        }

        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

    public static int bit1counts(int N) {
        int count = 0;
        while (N != 0) {
            int rightOne = N & ((~N) + 1);
            count++;
            N ^= rightOne;
        }
        return count;
    }

}
