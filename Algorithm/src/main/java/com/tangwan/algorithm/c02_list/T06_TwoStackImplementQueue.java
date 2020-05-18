/*
 * File Name:T06_TwoStackImplementQueue is created on 2020-05-18 15:51 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c02_list;

import java.util.Stack;

/**
 * @author Zhao Xiaoli
 * @Description : T06_TwoStackImplementQueue
 * 使用两个栈实现一个队列
 * <p>
 * 添加时： 向stackPush中添加，若stackPop为空，则将push中的数据pop出去
 * 弹出时： 当queue不为空时，从stackPop中弹出，若stackPop为空，则先将push中的数据弹到pop中，再弹出
 * <p>
 * @date 2020-05-18 15:51
 * @since JDK 1.8
 */
public class T06_TwoStackImplementQueue {

    public static void main(String[] args) {
        TwoStacksQueue test = new TwoStacksQueue();
        test.add(1);
        test.add(2);
        test.add(3);

        System.out.println(test.peek());
        System.out.println(test.poll());

        System.out.println(test.peek());
        System.out.println(test.poll());

        System.out.println(test.peek());
        System.out.println(test.poll());
    }

    public static class TwoStacksQueue {
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;

        public TwoStacksQueue() {
            stackPush = new Stack<>();
            stackPop = new Stack<>();
        }

        private void pushToPop() {
            if (stackPop.empty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }

        public void add(int pushInt) {
            stackPush.push(pushInt);
            pushToPop();
        }

        public int poll() {
            if (stackPush.empty() && stackPop.empty()) {
                throw new RuntimeException("Queue is empty");
            }

            pushToPop();
            return stackPop.pop();
        }

        public int peek() {
            if (stackPush.empty() && stackPop.empty()) {
                throw new RuntimeException("Queue is empty");
            }

            pushToPop();
            return stackPop.peek();
        }
    }
}
