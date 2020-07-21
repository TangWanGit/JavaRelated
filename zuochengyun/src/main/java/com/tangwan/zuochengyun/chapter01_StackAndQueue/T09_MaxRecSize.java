/*
 * File Name:T09_MaxRecSize is created on 2020-07-20 16:17 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.zuochengyun.chapter01_StackAndQueue;

import java.util.Stack;

/**
 * @author Zhao Xiaoli
 * @Description : T09_MaxRecSize
 * 求最大子矩阵大小
 * @date 2020-07-20 16:17
 * @since JDK 1.8
 */
public class T09_MaxRecSize {
    public static void main(String[] args) {
        //int[][] arr = {{1}, {1}, {1}, {0}};
        //System.out.println(maxRecSize(arr));

        int[][] arr2 = {{1, 0, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 0}};
        System.out.println(maxRecSize(arr2));
    }

    public static int maxRecSize(int[][] map) {
        if (map == null || map.length == 0 || map[0].length == 0) {
            return 0;
        }

        int maxArea = 0;
        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxArea, maxRecFormBottom(height));
        }
        return maxArea;
    }

    private static int maxRecFormBottom(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while ((!stack.isEmpty()) && height[i] <= height[stack.peek()]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                // j  向右最大能扩到i位置
                // j  向左最大能扩到k+1位置
                // 故 一共能扩的最大位置为i-(k+1)位置
                int curArea = (i - k - 1) * height[j];
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }
}
