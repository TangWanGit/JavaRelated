/*
 * File Name:T02_HeapWithComparator is created on 2020-05-21 16:26 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c04_comparator_and_heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author Zhao Xiaoli
 * @Description : T02_HeapWithComparator
 * @date 2020-05-21 16:26
 * @since JDK 1.8
 */
public class T03_HeapWithComparator {
    public static void main(String[] args) {
        Student s1 = new Student(2, 50, 11111);
        Student s2 = new Student(1, 60, 22222);
        Student s3 = new Student(6, 10, 33333);
        Student s4 = new Student(3, 20, 44444);
        Student s5 = new Student(7, 72, 55555);
        Student s6 = new Student(1, 14, 66666);

        PriorityQueue<Student> heap = new PriorityQueue<>(new StudentComparator());
        heap.add(s1);
        heap.add(s2);
        heap.add(s3);
        heap.add(s4);
        heap.add(s5);
        heap.add(s6);
        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }

        System.out.println("=====================");

        MyHeap<Student> myHeap = new MyHeap<>(new StudentComparator());
        myHeap.push(s1);
        myHeap.push(s2);
        myHeap.push(s3);
        myHeap.push(s4);
        myHeap.push(s5);
        myHeap.push(s6);

        while (!myHeap.isEmpty()) {
            System.out.println(myHeap.pop());
        }

        System.out.println("=====================");

        heap.add(s1);
        heap.add(s2);
        heap.add(s3);
        heap.add(s4);
        heap.add(s5);
        heap.add(s6);

        s2.age = 6;
        s4.age = 12;
        s5.age = 10;
        s6.age = 84;

        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }

        System.out.println("=====================");
        s1 = new Student(2, 50, 11111);
        s2 = new Student(1, 60, 22222);
        s3 = new Student(6, 10, 33333);
        s4 = new Student(3, 20, 44444);
        s5 = new Student(7, 72, 55555);
        s6 = new Student(1, 14, 66666);
        myHeap.push(s1);
        myHeap.push(s2);
        myHeap.push(s3);
        myHeap.push(s4);
        myHeap.push(s5);
        myHeap.push(s6);

        s2.age = 6;
        myHeap.resign(s2);

        s4.age = 12;
        myHeap.resign(s4);
        s5.age = 10;
        myHeap.resign(s5);
        s6.age = 84;
        myHeap.resign(s6);
        while (!myHeap.isEmpty()) {
            System.out.println(myHeap.pop());
        }

        System.out.println("test begin");
        int maxValue = 100000;
        int pushTimes = 1000_000;
        int resignTime = 100;

        MyHeap<Student> test = new MyHeap<>(new StudentComparator());
        ArrayList<Student> list = new ArrayList<>(pushTimes);

        for (int i = 0; i < pushTimes; i++) {
            Student cur = new Student(1, (int)(Math.random() * maxValue), 1000);
            test.push(cur);
            list.add(cur);
        }

        for (int i = 0; i < resignTime; i++) {
            int index = (int)(Math.random() * pushTimes);
            list.get(index).age = (int)(Math.random() * maxValue);
            test.resign(list.get(index));
        }

        int preAge = Integer.MIN_VALUE;
        while (!test.isEmpty()) {
            Student cur = test.pop();
            if (cur.age < preAge) {
                System.out.println("Oops");
            }
            preAge = cur.age;
        }

        System.out.println("test finish");
    }

    public static class MyHeap<T> {
        private ArrayList<T> heap;
        private HashMap<T, Integer> indexMap;
        private int heapSize;
        private Comparator<T> comparator;

        public MyHeap(Comparator<T> comparator) {
            heap = new ArrayList<>();
            indexMap = new HashMap<>();
            heapSize = 0;
            this.comparator = comparator;

        }

        public boolean isEmpty() {
            return heap.isEmpty();
        }

        public int size() {
            return heapSize;
        }

        public boolean contains(T value) {
            return indexMap.containsKey(value);
        }

        public void push(T value) {
            heap.add(value);
            indexMap.put(value, heapSize);
            heapInsert(heapSize++);
        }

        public T pop() {
            T ans = heap.get(0);

            swap(heap, 0, --heapSize);
            heap.remove(heapSize);
            indexMap.remove(ans);

            heapify(heap, 0, heapSize);
            return ans;
        }

        public void resign(T value) {
            Integer index = indexMap.get(value);
            heapInsert(index);
            heapify(heap, index, heapSize);
        }

        private void heapify(ArrayList<T> heap, int index, int heapSize) {
            int left = index * 2 + 1;
            while (left < heapSize) {
                int largest =
                    left + 1 < heapSize && comparator.compare(heap.get(left + 1), heap.get(left)) < 0 ? left + 1 : left;
                largest = comparator.compare(heap.get(largest), heap.get(index)) < 0 ? largest : index;
                if (largest == index) {
                    break;
                }

                swap(heap, largest, index);
                index = largest;
                left = index * 2 + 1;
            }
        }

        private void heapInsert(int index) {
            while (comparator.compare(heap.get(index), heap.get((index - 1) / 2)) < 0) {
                swap(heap, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        private void swap(ArrayList<T> heap, int i, int j) {
            T o1 = heap.get(i);
            T o2 = heap.get(i);
            heap.set(i, o2);
            heap.set(j, o1);
            indexMap.put(o2, j);
            indexMap.put(o1, i);
        }
    }

    public static class Student {
        public int classNo;
        public int age;
        public int id;

        public Student(int classNo, int age, int id) {
            this.classNo = classNo;
            this.age = age;
            this.id = id;
        }

        public Student() {
        }

        @Override
        public String toString() {
            return "Student{" + "classNo=" + classNo + ", age=" + age + ", id=" + id + '}';
        }
    }

    public static class StudentComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }
    }

}
