/*
 * File Name:T05_GetMinStack is created on 2020-05-17 13:00 by tangwan
 *
 * tangwan
 *
 */
package com.tangwan.algorithm.c02_list;

import java.util.Stack;

/**
 * @author tangwan
 * @Description : T05_GetMinStack
 * 两种获取stack中最小值的结构，获取最小值的复杂度为 O(1)
 * @date 2020-05-17 13:00
 * @since JDK 1.8
 */
public class T05_GetMinStack {

    public static void main(String[] args) {
        MyStack1 stack1 = new MyStack1();
        stack1.push(3);
        System.out.println(stack1.getMin());

        stack1.push(4);
        System.out.println(stack1.getMin());

        stack1.push(1);
        System.out.println(stack1.getMin());

        System.out.println(stack1.pop());
        System.out.println(stack1.getMin());

        System.out.println("========");
        MyStack2 stack2 = new MyStack2();
        stack2.push(3);
        System.out.println(stack2.getMin());

        stack2.push(4);
        System.out.println(stack2.getMin());

        stack2.push(1);
        System.out.println(stack2.getMin());

        System.out.println(stack2.pop());
        System.out.println(stack2.getMin());

    }

    public static class MyStack1 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack1() {
            stackData = new Stack<>();
            stackMin = new Stack<>();
        }

        public void push(int newNum) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
            } else if (newNum <= this.getMin()) {
                this.stackMin.push(newNum);
            }

            this.stackData.push(newNum);
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }

            Integer value = this.stackData.pop();
            if (value == this.getMin()) {
                this.stackMin.pop();
            }
            return value;
        }

        private int getMin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }

    }

    public static class MyStack2 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack2() {
            stackData = new Stack<>();
            stackMin = new Stack<>();
        }

        public void push(int newNum) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
            } else if (newNum < this.getMin()) {
                this.stackMin.push(newNum);
            } else {
                int newMin = this.stackMin.peek();
                this.stackMin.push(newMin);
            }

            this.stackData.push(newNum);
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }

            Integer value = this.stackData.pop();
            this.stackMin.pop();
            return value;
        }

        private int getMin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }
    }
}
