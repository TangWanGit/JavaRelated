/*
 * File Name:T03_ReverseStackUsingRecursive is created on 2020-07-13 19:12 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.zuochengyun.chapter01_StackAndQueue;

import java.util.Stack;

/**
 * @author Zhao Xiaoli
 * @Description : T03_ReverseStackUsingRecursive
 * @date 2020-07-13 19:12
 * @since JDK 1.8
 */
public class T03_ReverseStackUsingRecursive {
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

    /**
     * 逆序
     * <p>
     * 假如stack中数据未3、2、1
     * 那么reverse方法的步骤为：
     * 1. i = getAndRemoveLastElement = 1
     * 2. 递归调用 i = getAndRemoveLastElement = 2
     * 3. 递归调用 i = getAndRemoveLastElement = 3
     * 4. 递归调用，栈已空，返回
     * 5. 将 i = 3 ，重新压入栈
     * 6. 将 i = 2 ，重新压入栈
     * 7. 将 i = 1 ，重新压入栈
     *
     * @param stack
     */
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        // 获得栈底元素
        int i = getAndRemoveLastElement(stack);
        // 递归
        reverse(stack);
        // 将获得的栈底元素重新push
        stack.push(i);
    }

    /**
     * 移除并返回栈底元素
     *
     * @param stack
     *
     * @return
     */
    private static int getAndRemoveLastElement(Stack<Integer> stack) {
        Integer result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }
}
