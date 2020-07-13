/*
 * File Name:T01_GetMinFromStack is created on 2020-07-09 16:43 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.zuochengyun.chapter01_StackAndQueue;

import java.util.Stack;

/**
 * @author Zhao Xiaoli
 * @Description : T01_GetMinFromStack
 * 设计一个有getMin功能的栈
 * @date 2020-07-09 16:43
 * @since JDK 1.8
 */
public class T01_GetMinFromStack {
    public static void main(String[] args) {
        MyStack1<Integer> stack1 = new MyStack1<>();
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        stack1.push(1);
        stack1.push(2);
        stack1.push(1);

        while (!stack1.isEmpty()) {
            System.out.println(stack1.getMin() + " : " + stack1.pop());
        }

        System.out.println("==========================");

        MyStack2<Integer> stack2 = new MyStack2<>();
        stack2.push(3);
        stack2.push(4);
        stack2.push(5);
        stack2.push(1);
        stack2.push(2);
        stack2.push(1);

        while (!stack2.isEmpty()) {
            System.out.println(stack2.getMin() + " : " + stack2.pop());
        }
    }

    public static class MyStack1<E extends Comparable> {
        public Stack<E> stackData;
        public Stack<E> stackMin;

        public MyStack1() {
            stackData = new Stack<>();
            stackMin = new Stack<>();
        }

        public void push(E value) {
            if (stackMin.isEmpty()) {
                stackMin.push(value);
            } else if (value.compareTo(getMin()) <= 0) {
                stackMin.push(value);
            }

            stackData.push(value);
        }

        public E pop() {
            if (stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            E pop = stackData.pop();
            if (pop == getMin()) {
                stackMin.pop();
            }
            return pop;
        }

        public E getMin() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return stackMin.peek();
        }

        public boolean isEmpty() {
            return stackData.isEmpty();
        }
    }

    public static class MyStack2<E extends Comparable> {
        public Stack<E> stackData;
        public Stack<E> stackMin;

        public MyStack2() {
            stackData = new Stack<>();
            stackMin = new Stack<>();
        }

        public void push(E value) {
            if (stackMin.isEmpty()) {
                stackMin.push(value);
            } else if (value.compareTo(getMin()) < 0) {
                stackMin.push(value);
            } else {
                stackMin.push(getMin());
            }

            stackData.push(value);
        }

        public E pop() {
            if (stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            E pop = stackData.pop();
            stackMin.pop();
            return pop;
        }

        public E getMin() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return stackMin.peek();
        }

        public boolean isEmpty() {
            return stackData.isEmpty();
        }
    }
}
