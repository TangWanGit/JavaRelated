/*
 * File Name:T02_QueueConsistingOfTwoStacks is created on 2020-07-13 15:50 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.zuochengyun.chapter01_StackAndQueue;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Zhao Xiaoli
 * @Description : T02_QueueConsistingOfTwoStacks
 * 由两个栈组成的队列
 * @date 2020-07-13 15:50
 * @since JDK 1.8
 */
public class T02_QueueConsistingOfTwoStacks {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        test(queue);

        Queue<Integer> twoStacksQueue = new TwoStacksQueue<>();
        test(twoStacksQueue);
    }

    private static void test(Queue queue) {
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        System.out.println("========add==========");
        printQueue(queue);

        System.out.println("=======after pop=======");
        queue.add(5);
        queue.add(6);
        queue.add(7);

        System.out.println(queue.poll());

        queue.add(8);

        System.out.println("=======pop=======");
        printQueue(queue);

        System.out.println("\n=======================================\n");
    }

    private static <E> void printQueue(Queue<E> queue) {
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println();
    }

    public static class TwoStacksQueue<E> implements Queue<E> {

        private Stack<E> stackPush;
        private Stack<E> stackPop;

        public TwoStacksQueue() {
            this.stackPush = new Stack<>();
            this.stackPop = new Stack<>();
        }

        @Override
        public int size() {
            return stackPop.size() + stackPush.size();
        }

        @Override
        public boolean isEmpty() {
            return stackPop.isEmpty() && stackPush.isEmpty();
        }

        @Override
        public boolean contains(Object o) {
            return stackPush.contains(o) || stackPop.contains(o);
        }

        @Override
        public boolean add(E o) {
            return offer(o);
        }

        @Override
        public boolean offer(E o) {
            stackPush.push(o);
            return true;
        }

        @Override
        public E poll() {
            beforePop();
            if (!stackPop.isEmpty()) {
                return stackPop.pop();
            }
            throw new RuntimeException("Your queue is empty.");
        }

        @Override
        public E element() {
            beforePop();
            if (!stackPop.isEmpty()) {
                return stackPop.peek();
            }
            throw new RuntimeException("Your queue is empty.");
        }

        @Override
        public E peek() {
            beforePop();
            if (!stackPop.isEmpty()) {
                return stackPop.peek();
            }
            throw new RuntimeException("Your queue is empty.");
        }

        private void beforePop() {
            if (stackPush.isEmpty() && stackPop.isEmpty()) {
                throw new RuntimeException("Your queue is empty.");
            }
            if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }

        @Override
        public Iterator iterator() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Object[] toArray(Object[] a) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean remove(Object o) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean addAll(Collection c) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void clear() {
            stackPop.clear();
            stackPush.clear();
        }

        @Override
        public boolean retainAll(Collection c) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean removeAll(Collection c) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean containsAll(Collection c) {
            throw new UnsupportedOperationException();
        }

        @Override
        public E remove() {
            throw new UnsupportedOperationException();
        }
    }
}
