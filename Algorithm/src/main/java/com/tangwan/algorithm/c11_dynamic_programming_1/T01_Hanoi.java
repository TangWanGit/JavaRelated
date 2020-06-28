/*
 * File Name:T01_Hanoi is created on 2020-06-28 11:34 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c11_dynamic_programming_1;

import java.util.Stack;

/**
 * @author Zhao Xiaoli
 * @Description : T01_Hanoi
 * 汉诺塔问题
 * @date 2020-06-28 11:34
 * @since JDK 1.8
 */
public class T01_Hanoi {
    public static void main(String[] args) {
        int n = 3;
        hanoi1(n);
        System.out.println("=======================");
        hanoi2(n);
        System.out.println("=======================");
        hanoi3(n);
    }

    private static void hanoi1(int n) {
        leftToRight(n);
    }

    // 请把1~N层圆盘 从左 -> 右
    private static void leftToRight(int n) {
        if (n == 1) {
            System.out.println("Move 1 from left to right");
            return;
        }
        leftToMid(n - 1);
        System.out.println("Move " + n + " from left to right");
        midToRight(n - 1);
    }

    // 请把1~N层圆盘 从左 -> 中
    private static void leftToMid(int n) {
        if (n == 1) {
            System.out.println("Move 1 from left to mid");
            return;
        }
        leftToRight(n - 1);
        System.out.println("Move " + n + " from left to mid");
        rightToMid(n - 1);

    }

    private static void rightToMid(int n) {
        if (n == 1) {
            System.out.println("Move 1 from right to mid");
            return;
        }
        rightToLeft(n - 1);
        System.out.println("Move " + n + " from right to mid");
        leftToMid(n - 1);
    }

    private static void midToRight(int n) {
        if (n == 1) {
            System.out.println("Move 1 from mid to right");
            return;
        }
        midToLeft(n - 1);
        System.out.println("Move " + n + " from mid to right");
        leftToRight(n - 1);
    }

    private static void midToLeft(int n) {
        if (n == 1) {
            System.out.println("Move 1 from mid to left");
            return;
        }

        midToRight(n - 1);
        System.out.println("Move " + n + " from mid to left");
        rightToLeft(n - 1);
    }

    private static void rightToLeft(int n) {
        if (n == 1) {
            System.out.println("Move 1 from right to left");
            return;
        }
        rightToMid(n - 1);
        System.out.println("Move " + n + " from right to left");
        midToLeft(n - 1);
    }

    private static void hanoi2(int n) {
        if (n > 0) {
            func(n, "left", "right", "mid");
        }
    }

    // 1~i 圆盘 目标是from -> to， other是另外一个
    private static void func(int n, String from, String to, String other) {
        if (n == 1) {
            System.out.println("Move " + n + " from " + from + " to " + to);
            return;
        } else {
            func(n - 1, from, other, to);
            System.out.println("Move " + n + " from " + from + " to " + to);
            func(n - 1, other, to, from);
        }
    }

    private static void hanoi3(int n) {
        if (n < 1) {
            return;
        }

        Stack<Record> stack = new Stack<>();
        stack.push(new Record(false, n, "left", "right", "mid"));
        while (!stack.isEmpty()) {
            Record cur = stack.pop();
            if (cur.base == 1) {
                System.out.println("Move " + cur.base + " from " + cur.from + " to " + cur.to);
                if (!stack.isEmpty()) {
                    stack.peek().finish = true;
                }
            } else {
                if (!cur.finish) {
                    stack.push(cur);
                    stack.push(new Record(false, cur.base - 1, cur.from, cur.other, cur.to));
                } else {
                    System.out.println("Move " + cur.base + " from " + cur.from + " to " + cur.to);
                    stack.push(new Record(false, cur.base - 1, cur.other, cur.to, cur.from));
                }
            }
        }
    }

    public static class Record {
        public boolean finish;
        public int base;
        public String from;
        public String to;
        public String other;

        public Record(boolean finish, int base, String from, String to, String other) {
            this.finish = finish;
            this.base = base;
            this.from = from;
            this.to = to;
            this.other = other;
        }
    }

}
