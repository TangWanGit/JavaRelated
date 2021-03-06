/*
 * File Name:T04_RingArray is created on 2020-05-17 12:48 by tangwan
 *
 * tangwan
 *
 */
package com.tangwan.algorithm.c02_list;

/**
 * @author tangwan
 * @Description : T04_RingArray
 * 环形queue，使用数组实现可利用的队列
 * @date 2020-05-17 12:48
 * @since JDK 1.8
 */
public class T04_RingArray {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(5);
        for (int i = 0; i < 5; i++) {
            queue.push(i << 1);
            System.out.print(queue.polli + "_" + queue.pop() + " ");

            queue.push(i << 2);
        }

        System.out.println();
        System.out.println("size " + queue.size);

        while (!queue.isEmpty()) {
            System.out.print(queue.polli + "_" + queue.pop() + " ");
        }

    }

    public static class MyQueue {

        private int[] arr;
        private int pushi;
        private int polli;
        private int size;
        private final int limit;

        public MyQueue(int limit) {
            arr = new int[limit];
            pushi = 0;
            polli = 0;
            size = 0;
            this.limit = limit;
        }

        public void push(int value) {

            if (size == limit) {
                throw new RuntimeException("栈满了，不能再加了");
            }
            size++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);
        }

        public int pop() {
            if (size == 0) {
                throw new RuntimeException("栈空了，不能再拿了");
            }
            size--;
            int ans = arr[polli];
            polli = nextIndex(polli);
            return ans;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * 如果现在的下标是i，返回下一个位置
         *
         * @param i
         *
         * @return
         */
        public int nextIndex(int i) {
            return i < limit - 1 ? i + 1 : 0;
        }
    }

}
