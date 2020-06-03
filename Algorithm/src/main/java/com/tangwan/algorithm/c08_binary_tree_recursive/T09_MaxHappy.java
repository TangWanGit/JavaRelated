/*
 * File Name:T09_MaxHappy is created on 2020-06-03 14:27 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c08_binary_tree_recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhao Xiaoli
 * @Description : T09_MaxHappy
 * @date 2020-06-03 14:27
 * @since JDK 1.8
 */
public class T09_MaxHappy {
    public static void main(String[] args) {
        int maxLevel = 4;
        int maxNexts = 7;
        int maxHappy = 100;
        int testTimes = 1000_000;
        System.out.println("test begin");
        for (int i = 0; i < testTimes; i++) {
            Employee employee = generateBoss(maxLevel, maxNexts, maxHappy);
            if (maxHappy1(employee) != maxHappy2(employee)) {
                System.out.println("Oops");
                print(employee);
                break;
            }
        }
        System.out.println("test end");
    }

    private static int maxHappy1(Employee boss) {
        if (boss == null) {
            return 0;
        }

        return process1(boss, false);
    }

    private static int process1(Employee cur, boolean up) {
        if (up) {
            int ans = 0;
            for (Employee next : cur.nexts) {
                ans += process1(next, false);
            }
            return ans;
        } else {
            int p1 = cur.happy;
            int p2 = 0;
            for (Employee next : cur.nexts) {
                p1 += process1(next, true);
                p2 += process1(next, false);
            }
            return Math.max(p1, p2);
        }
    }

    private static int maxHappy2(Employee boss) {
        if (boss == null) {
            return 0;
        }
        Info info = process2(boss);
        return Math.max(info.no, info.yes);
    }

    private static Info process2(Employee cur) {
        if (cur.nexts == null) {
            return new Info(cur.happy, 0);
        }

        int yes = cur.happy;
        int no = 0;

        for (Employee next : cur.nexts) {
            Info nextInfo = process2(next);
            yes += nextInfo.no;
            no += Math.max(nextInfo.no, nextInfo.yes);
        }

        return new Info(yes, no);
    }

    private static Employee generateBoss(int maxLevel, int maxNext, int maxHappy) {
        Employee boss = new Employee((int)(Math.random() * maxHappy));
        generateNext(boss, 1, maxLevel, maxNext, maxHappy);
        return boss;
    }

    private static void generateNext(Employee boss, int level, int maxLevel, int maxNext, int maxHappy) {
        if (level > maxLevel) {
            return;
        }
        int nextSize = (int)(Math.random() * maxNext);
        for (int i = 0; i < nextSize; i++) {
            Employee next = new Employee((int)(Math.random() * maxHappy));
            boss.nexts.add(next);
            generateNext(next, level + 1, maxLevel, maxNext, maxHappy);
        }
    }

    private static void print(Employee employee) {

    }

    public static class Employee {
        public int happy;
        public List<Employee> nexts;

        public Employee(int happy) {
            this.happy = happy;
            nexts = new ArrayList<>();
        }
    }

    public static class Info {
        public int yes;
        public int no;

        public Info(int yes, int no) {
            this.yes = yes;
            this.no = no;
        }
    }
}
