/*
 * File Name:T07_TwoQueueImplementStack is created on 2020-05-18 15:56 by tangwan
 *
 * tangwan
 *
 */
package com.tangwan.algorithm.c02_list;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author tangwan
 * @Description : T07_TwoQueueImplementStack
 * <p>
 * 使用两个queue实现一个stack
 * 添加时：向queue中添加数据
 * 删除时：保留queue的最后一个数据，将其他的数据都转移到help中，然后将help和queu互换，返回数据
 * <p>
 * @date 2020-05-18 15:56
 * @since JDK 1.8
 */
public class T07_TwoQueueImplementStack {
    public static void main(String[] args) {
        TwoQueuesStack myStack = new TwoQueuesStack();
        Stack<Integer> test = new Stack<>();

        int testTimes = 1_000_000;
        int max = 1_000_000;

        for (int i = 0; i < testTimes; i++) {
            if (myStack.isEmpty()) {
                if (!test.isEmpty()) {
                    System.out.println("Oops");
                }
                int num = (int)(Math.random() * max);
                myStack.push(num);
                test.push(num);
            } else {
                if (Math.random() < 0.25) {
                    int num = (int)(Math.random() * max);
                    myStack.push(num);
                    test.push(num);
                } else if (Math.random() < 0.5) {
                    if (!myStack.peek().equals(test.peek())) {
                        System.out.println("Oops");
                    }
                } else if (Math.random() < 0.75) {
                    if (!myStack.pop().equals(test.pop())) {
                        System.out.println("Oops");
                    }
                } else {
                    if (myStack.isEmpty() != test.isEmpty()) {
                        System.out.println("Oops");
                    }
                }
            }
        }

        System.out.println("test finish");
    }

    public static class TwoQueuesStack {
        public Queue<Integer> queue;
        public Queue<Integer> help;

        public TwoQueuesStack() {
            queue = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(int value) {
            queue.offer(value);
        }

        public Integer pop() {
            if (queue.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }

            Integer ans = queue.poll();

            Queue<Integer> tmp = queue;
            queue = help;
            help = tmp;
            return ans;
        }

        public Integer peek() {
            if (queue.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }

            Integer ans = queue.poll();
            help.offer(ans);
            Queue<Integer> tmp = queue;
            queue = help;
            help = tmp;
            return ans;
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }
}
