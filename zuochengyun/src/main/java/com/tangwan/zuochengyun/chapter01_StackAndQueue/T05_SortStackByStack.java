/*
 * File Name:T05_SortStackByStack is created on 2020-07-15 14:13 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.zuochengyun.chapter01_StackAndQueue;

import java.util.Stack;

/**
 * @author Zhao Xiaoli
 * @Description : T05_SortStackByStack
 * @date 2020-07-15 14:13
 * @since JDK 1.8
 */
public class T05_SortStackByStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(4);

        sortStackByStack(stack);
        for (Integer i : stack) {
            System.out.println(i);
        }

    }

    private static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            Integer cur = stack.pop();
            while (!help.isEmpty() && help.peek() > cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}
