/*
 * File Name:T04_ReverseStackUsingRecursive is created on 2020-06-30 17:47 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c11_dynamic_programming_1;

import java.util.Stack;

/**
 * @author Zhao Xiaoli
 * @Description : T04_ReverseStackUsingRecursive
 * 使用递归的方式将stack逆序
 * @date 2020-06-30 17:47
 * @since JDK 1.8
 */
public class T04_ReverseStackUsingRecursive {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        reverse(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int last = f(stack);
        reverse(stack);
        stack.push(last);
    }

    private static int f(Stack<Integer> stack) {
        Integer result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = f(stack);
            stack.push(result);
            return last;
        }
    }
}
