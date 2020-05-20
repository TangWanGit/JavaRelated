/*
 * File Name:T01_Comparator is created on 2020-05-20 15:39 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c04_comparator_and_heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @author Zhao Xiaoli
 * @Description : T01_Comparator
 * @date 2020-05-20 15:39
 * @since JDK 1.8
 */
public class T01_Comparator {
    public static void main(String[] args) {
        Integer[] arr = {5, 4, 3, 2, 7, 9, 1, 0};
        Arrays.sort(arr, new AComp());

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("===========================");
        Student student1 = new Student(2, "A", 20);
        Student student2 = new Student(3, "B", 21);
        Student student3 = new Student(1, "C", 22);

        Student[] students = {student1, student2, student3};
        Arrays.sort(students, new IdAscendingComparator());
        printStudents(students);

        System.out.println("===========================");
        Arrays.sort(students, new IdDescendingComparator());
        printStudents(students);

        System.out.println("===========================");
        Arrays.sort(students, new AgeDescendingComparator());
        printStudents(students);

        System.out.println("===========================");
        PriorityQueue<Student> minHeapBasedId = new PriorityQueue<>(new IdAscendingComparator());
        minHeapBasedId.add(student1);
        minHeapBasedId.add(student2);
        minHeapBasedId.add(student3);

        while (!minHeapBasedId.isEmpty()) {
            System.out.println(minHeapBasedId.poll());
        }

        System.out.println("===========================");
        TreeSet<Student> treeAgeAsc = new TreeSet<>(new AgeAscendingComparator());
        treeAgeAsc.add(student1);
        treeAgeAsc.add(student2);
        treeAgeAsc.add(student3);

        System.out.println(treeAgeAsc.first());

        System.out.println(treeAgeAsc.last());
    }

    private static void printStudents(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].toString());
        }
    }

    public static class AComp implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }

    }

    public static class Student {
        public int id;
        public String name;
        public int age;

        public Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + '}';
        }
    }

    public static class IdAscendingComparator implements Comparator<Student> {

        // 返回负数的时候，第一个参数排在前面
        // 返回正数的时候，第二个参数排在前面
        // 返回0的时候，谁在前面无所谓
        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }
    }

    public static class IdDescendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.id - o1.id;
        }
    }

    public static class AgeAscendingComparator implements Comparator<Student> {

        // 返回负数的时候，第一个参数排在前面
        // 返回正数的时候，第二个参数排在前面
        // 返回0的时候，谁在前面无所谓
        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }
    }

    public static class AgeDescendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.age - o1.age;
        }
    }

}
