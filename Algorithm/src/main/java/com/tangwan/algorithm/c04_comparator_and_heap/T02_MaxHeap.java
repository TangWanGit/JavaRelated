/*
 * File Name:T02_MaxHeap is created on 2020-05-21 13:41 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c04_comparator_and_heap;

/**
 * @author Zhao Xiaoli
 * @Description : 大根堆
 * @date 2020-05-21 13:41
 * @since JDK 1.8
 */
public class T02_MaxHeap {
    public static void main(String[] args) {
        int value = 1000;
        int limit = 100;
        int testTimes = 1000_000;
        for (int i = 0; i < testTimes; i++) {
            int curLimit = (int)(Math.random() * limit) + 1;
            RightMaxHeap test = new RightMaxHeap(curLimit);
            MyMaxHeap my = new MyMaxHeap(curLimit);

            int curOpTimes = (int)(Math.random() * limit);
            for (int j = 0; j < curOpTimes; j++) {
                if (my.isEmpty() != test.isEmpty()) {
                    System.out.println("isEmpty Oops");
                    break;
                }
                if (my.isFull() != test.isFull()) {
                    System.out.println("isFull Oops");
                    break;
                }

                if (my.isEmpty()) {
                    int curValue = (int)(Math.random() * value);
                    my.push(curValue);
                    test.push(curValue);
                } else if (my.isFull()) {
                    if (my.pop() != test.pop()) {
                        System.out.println("pop Oops");
                        break;
                    }
                } else {
                    if (Math.random() < 0.5) {
                        int curValue = (int)(Math.random() * value);
                        my.push(curValue);
                        test.push(curValue);
                    } else {
                        if (my.pop() != test.pop()) {
                            System.out.println("pop Oops");
                            break;
                        }
                    }
                }
            }
        }
        System.out.println("finish!");
    }

    public static class MyMaxHeap {
        private int[] heap;
        private final int limit;
        private int heapSize;

        public MyMaxHeap(int limit) {
            this.limit = limit;
            heap = new int[limit];
            heapSize = 0;
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public boolean isFull() {
            return heapSize == limit;
        }

        public void push(int value) {
            if (isFull()) {
                throw new RuntimeException("arr is full");
            }

            heap[heapSize] = value;
            heapInsert(heap, heapSize++);
        }

        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("arr is empty");
            }

            int ans = heap[0];
            swap(heap, 0, --heapSize);
            heapify(heap, 0, heapSize);
            return ans;
        }

        // 从index位置，往下看，不断的下沉，
        // 停：我的孩子都不再比我大；已经没孩子了
        private void heapify(int[] arr, int index, int heapSize) {
            int left = index * 2 + 1;
            while (left < heapSize) {
                // 左右两个孩子中，谁大，谁把自己的下标给largest
                // 右  ->  1) 有右孩子   && 2）右孩子的值比左孩子大才行
                // 否则，左
                int lartest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
                lartest = arr[lartest] > arr[index] ? lartest : index;
                if (lartest == index) {
                    break;
                }
                swap(heap, lartest, index);
                index = lartest;
                left = index * 2 + 1;
            }
        }

        private void heapInsert(int[] arr, int index) {
            //arr[index] > arr[(index - 1) / 2];
            // 当index一直比自己的父亲大，那就一直和父亲做交换
            // arr[index]
            // arr[index] 不比 arr[index父]大了 ， 停
            // index = 0;
            while (arr[index] > arr[(index - 1) / 2]) {
                swap(heap, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        private void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    public static class RightMaxHeap {
        private int[] arr;
        private final int limit;
        private int size;

        public RightMaxHeap(int limit) {
            this.limit = limit;
            arr = new int[limit];
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }

        public void push(int value) {
            if (isFull()) {
                throw new RuntimeException("heap is full");
            }
            arr[size++] = value;
        }

        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("arr is empty");
            }

            int maxValueIndex = 0;
            for (int i = 0; i < size; i++) {
                if (arr[i] > arr[maxValueIndex]) {
                    maxValueIndex = i;
                }
            }

            int ans = arr[maxValueIndex];
            arr[maxValueIndex] = arr[--size];
            return ans;
        }

    }
}
