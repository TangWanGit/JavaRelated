/*
 * File Name:T03_LessMoneySplitGold is created on 2020-06-16 14:44 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c09_greedy_algorithm;

import java.util.PriorityQueue;

/**
 * @author Zhao Xiaoli
 * @Description : T03_LessMoneySplitGold
 * @date 2020-06-16 14:44
 * @since JDK 1.8
 */
public class T03_LessMoneySplitGold {
    public static void main(String[] args) {
        int maxSize = 6;
        int maxValue = 1000;
        int testTimes = 1000_000;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int lessMoney1 = lessMoney1(arr);
            int lessMoney2 = lessMoney2(arr);
            if (lessMoney1 != lessMoney2) {
                System.out.println(lessMoney1);
                System.out.println(lessMoney2);
                printArray(arr);
                System.out.println("Oops");
                break;
            }
        }
        System.out.println("finish");
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();
    }

    public static int lessMoney1(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }

        return process(arr, 0);

    }

    private static int process(int[] arr, int pre) {
        if (arr.length == 1) {
            return pre;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                ans = Math.min(ans, process(copyAndMergeTwo(arr, i, j), pre + arr[i] + arr[j]));
            }
        }
        return ans;
    }

    private static int[] copyAndMergeTwo(int[] arr, int i, int j) {
        int[] ans = new int[arr.length - 1];
        int ansi = 0;
        for (int k = 0; k < arr.length; k++) {
            if (k != i && k != j) {
                ans[ansi++] = arr[k];
            }
        }
        ans[ansi] = arr[i] + arr[j];
        return ans;
    }

    public static int lessMoney2(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pQ.offer(arr[i]);
        }

        int cur = 0;
        int sum = 0;
        while (pQ.size() > 1) {
            cur = pQ.poll() + pQ.poll();
            sum += cur;
            pQ.offer(cur);
        }
        return sum;
    }

    private static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] ans = new int[(int)(Math.random() * maxSize + 1)];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (int)(Math.random() * maxValue);
        }
        return ans;
    }

}
