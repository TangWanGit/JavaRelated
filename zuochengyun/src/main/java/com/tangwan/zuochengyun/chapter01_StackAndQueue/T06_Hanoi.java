/*
 * File Name:T06_Hanoi is created on 2020-07-15 15:32 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.zuochengyun.chapter01_StackAndQueue;

import java.util.Stack;

/**
 * @author Zhao Xiaoli
 * @Description : T06_Hanoi
 * @date 2020-07-15 15:32
 * @since JDK 1.8
 */
public class T06_Hanoi {
    public static void main(String[] args) {
        int num = 2;
        int count1 = hanoiWithRecursive1(num);

        System.out.println("=====================");

        int count2 = hanoiWithRecursive2(num, "left", "mid", "right");

        System.out.println("=====================");
        int count3 = hanoiWithStack(num);

        System.out.println((count1 == count2) + " " + (count2 == count3) + " " + count1 + " " + count2 + " " + count3);
    }

    public static int hanoiWithRecursive1(int num) {
        return leftToRight(num);
    }

    /**
     * 左 --> 中
     * N层塔都在'左'，希望全部移到'中'，有三个步骤
     * 1. 将1~N-1层塔先全部从'左'移到'右'
     * 2. 将N层塔从'左'移到'中'
     * 3. 再将1~N-1层塔从'右'移到'中'
     *
     * @param n
     */
    public static int leftToMid(int n) {
        if (n == 1) {
            System.out.println("Move " + n + " from left to mid");
            return 1;
        }
        int part1 = leftToRight(n - 1);
        System.out.println("Move " + n + " from left to mid");
        int part2 = rightToMid(n - 1);
        return part1 + part2 + 1;
    }

    /**
     * 中 --> 左
     * N层塔都在'中'，希望全部移到'左'，有三个步骤
     * 1. 将1~N-1层塔先全部从'中'移到'右'
     * 2. 将N层塔从'中'移到'左'
     * 3. 再将1~N-1层塔从'右'移到'左'
     *
     * @param n
     */
    public static int midToLeft(int n) {
        if (n == 1) {
            System.out.println("Move " + n + " from mid to left");
            return 1;
        }
        int part1 = midToRight(n - 1);
        System.out.println("Move " + n + " from mid to left");
        int part2 = rightToLeft(n - 1);
        return part1 + part2 + 1;
    }

    /**
     * 右 --> 中
     * N层塔都在'右'，希望全部移到'中'，有三个步骤
     * 1. 将1~N-1层塔先全部从'右'移到'左'
     * 2. 将N层塔从'右'移到'中'
     * 3. 再将1~N-1层塔从'左'移到'中'
     *
     * @param n
     */
    private static int rightToMid(int n) {
        if (n == 1) {
            System.out.println("Move " + n + " from right to mid");
            return 1;
        }
        int part1 = rightToLeft(n - 1);
        System.out.println("Move " + n + " from right to mid");
        int part2 = leftToMid(n - 1);
        return part1 + part2 + 1;
    }

    /**
     * 中 --> 右
     * N层塔都在'中'，希望全部移到'右'，有三个步骤
     * 1. 将1~N-1层塔先全部从'中'移到'左'
     * 2. 将N层塔从'中'移到'右'
     * 3. 再将1~N-1层塔从'左'移到'右'
     *
     * @param n
     */
    private static int midToRight(int n) {
        if (n == 1) {
            System.out.println("Move " + n + " from mid to right");
            return 1;
        }
        int part1 = midToLeft(n - 1);
        System.out.println("Move " + n + " from mid to right");
        int part2 = leftToRight(n - 1);
        return part1 + part2 + 1;
    }

    /**
     * 右 --> 左
     * N层塔都在'右'，希望全部移到'左'，有三个步骤
     * 1. 将1~N-1层塔先全部从'右'移到'左'
     * 2. 将N层塔从'右'移到'中'
     * 3. 再将1~N-1层塔从'左'移到'右'
     * 4. 将N层塔从'中'移到'左'
     * 5. 再将1~N-1层塔从'右'移到'左'
     *
     * @param n
     */
    private static int rightToLeft(int n) {
        if (n == 1) {
            System.out.println("Move " + n + " from right to mid");
            System.out.println("Move " + n + " from mid to left");
            return 2;
        }

        int part1 = rightToLeft(n - 1);
        System.out.println("Move " + n + " from right to mid");
        int part2 = leftToRight(n - 1);
        System.out.println("Move " + n + " from  mid  to left");
        int part3 = rightToLeft(n - 1);
        return part1 + part2 + part3 + 2;
    }

    /**
     * 左 --> 右
     * N层塔都在'左'，希望全部移到'右'，有三个步骤
     * 1. 将1~N-1层塔先全部从'左'移到'右'
     * 2. 将N层塔从'左'移到'中'
     * 3. 再将1~N-1层塔从'右'移到'左'
     * 4. 将N层塔从'中'移到'右'
     * 5. 再将1~N-1层塔从'左'移到'右'
     *
     * @param n
     */
    private static int leftToRight(int n) {
        if (n == 1) {
            System.out.println("Move " + n + " from left to mid");
            System.out.println("Move " + n + " from mid to right");
            return 2;
        }
        int part1 = leftToRight(n - 1);
        System.out.println("Move " + n + " from left to mid");
        int part2 = rightToLeft(n - 1);
        System.out.println("Move " + n + " from mid to right");
        int part3 = leftToRight(n - 1);
        return part1 + part2 + part3 + 2;
    }

    public static int hanoiWithRecursive2(int num, String left, String mid, String right) {
        if (num < 1) {
            return 0;
        }
        return process(num, left, mid, right, left, right);
    }

    private static int process(int num, String left, String mid, String right, String from, String to) {
        if (num == 1) {
            if (from.equals(mid) || to.equals(mid)) {
                System.out.println("Move 1 from " + from + " to " + to);
                return 1;
            } else {
                System.out.println("Move 1 from " + from + " to " + mid);
                System.out.println("Move 1 from " + mid + " to " + to);
                return 2;
            }
        }
        if (from.equals(mid) || to.equals(mid)) {
            String another = (from.equals(left) || to.equals(left)) ? right : left;
            int part1 = process(num - 1, left, mid, right, from, another);
            int part2 = 1;
            System.out.println("Move " + num + " from " + from + " to " + to);

            int part3 = process(num - 1, left, mid, right, another, to);
            return part1 + part2 + part3;
        } else {
            int part1 = process(num - 1, left, mid, right, from, to);
            int part2 = 1;
            System.out.println("Move " + num + " from " + from + " to " + mid);
            int part3 = process(num - 1, left, mid, right, to, from);

            int part4 = 1;
            System.out.println("Move " + num + " from " + mid + " to " + to);
            int part5 = process(num - 1, left, mid, right, from, to);
            return part1 + part2 + part3 + part4 + part5;
        }
    }

    public static int hanoiWithStack(int num) {
        if (num < 1) {
            return 0;
        }
        return process2(num, "left", "mid", "right");
    }

    private static int process2(int num, String left, String mid, String right) {
        Stack<Integer> lS = new Stack<>();
        Stack<Integer> mS = new Stack<>();
        Stack<Integer> rS = new Stack<>();
        lS.push(Integer.MAX_VALUE);
        mS.push(Integer.MAX_VALUE);
        rS.push(Integer.MAX_VALUE);

        for (int i = num; i > 0; i--) {
            lS.push(i);
        }
        Action[] record = {Action.No};
        int step = 0;
        while (rS.size() != num + 1) {

            step += fStackToStack(record, Action.M2L, Action.L2M, lS, mS, left, mid);

            step += fStackToStack(record, Action.L2M, Action.M2L, mS, lS, mid, left);

            step += fStackToStack(record, Action.R2M, Action.M2R, mS, rS, mid, right);

            step += fStackToStack(record, Action.M2R, Action.R2M, rS, mS, right, mid);
        }
        return step;
    }

    private static int fStackToStack(Action[] record, Action preNoAct, Action nowAct, Stack<Integer> fStack,
        Stack<Integer> tStack, String from, String to) {
        if (record[0] != preNoAct && fStack.peek() < tStack.peek()) {
            tStack.push(fStack.pop());
            System.out.println("Move " + tStack.peek() + " from " + from + " to " + to);
            record[0] = nowAct;
            return 1;
        }
        return 0;
    }

    public static enum Action {
        No,
        L2M,
        M2L,
        M2R,
        R2M
    }
}
