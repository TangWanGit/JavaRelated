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
