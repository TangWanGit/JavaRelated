/*
 * File Name:T07_GetMaxWindows is created on 2020-07-17 13:58 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.zuochengyun.chapter01_StackAndQueue;

import java.util.LinkedList;

import com.tangwan.common.utils.PrintObject;

/**
 * @author Zhao Xiaoli
 * @Description : T07_GetMaxWindows
 * 生成窗口最大值数组
 * @date 2020-07-17 13:58
 * @since JDK 1.8
 */
public class T07_GetMaxWindow {

    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        int w = 3;
        int[] result = getMaxWindow(arr, w);
        PrintObject.printArray(result);
    }

    /**
     * 利用双端队列来实现窗口最大值的更新
     * 队尾永远存储当前窗口最大值的下标
     *
     * @param arr
     * @param w
     *
     * @return
     */
    private static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }

        LinkedList<Integer> qmax = new LinkedList<>();
        int[] result = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            /**
             * qmax的放入规则
             * 1. 如果qmax为空，直接放入队尾
             * 2. 如果qmax不为空，取出当前qmax队尾存的下标，假设为j
             *  1. 如果arr[j]>arr[i],直接放入队尾
             *  2. 如果arr[j]<=arr[i],把j从qmax中弹出，继续qmax的放入规则
             */
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);

            /**
             * 如果qmax队头的下标等于i-w，说明当前qmax队头的下标已过期，弹出当前队头的下标即可
             */
            if (qmax.peekFirst() == (i - w)) {
                qmax.pollFirst();
            }

            /**
             * 窗口开始滑动以后，每滑动一步记录一步
             */
            if (i >= w - 1) {
                result[index++] = arr[qmax.peekFirst()];
            }
        }
        return result;
    }
}
