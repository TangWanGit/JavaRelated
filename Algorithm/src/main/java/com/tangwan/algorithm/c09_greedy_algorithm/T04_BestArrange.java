/*
 * File Name:T04_BestArrange is created on 2020-06-16 15:04 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c09_greedy_algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Zhao Xiaoli
 * @Description : T04_BestArrange
 * 会议安排 安排数量最多
 * @date 2020-06-16 15:04
 * @since JDK 1.8
 */
public class T04_BestArrange {
    public static void main(String[] args) {
        int maxSize = 20;
        int maxValue = 100;
        int testTimes = 1000_000;
        for (int i = 0; i < testTimes; i++) {
            Program[] programs = generateRandomProgram(maxSize, maxValue);
            int bestArrange1 = bestArrange1(programs);
            int bestArrange2 = bestArrange2(programs);
            if (bestArrange1 != bestArrange2) {
                System.out.println("Oops");
                break;
            }
        }
        System.out.println("finish");
    }

    public static int bestArrange1(Program[] programs) {
        if (null == programs || programs.length == 0) {
            return 0;
        }
        return process(programs, 0, 0);

    }

    // 还剩什么会议都放在programs里
    // done 之前已经安排了多少会议，数量
    // timeLine目前来到的时间点是什么

    // 目前来到timeLine的时间点，已经安排了done多的会议，剩下的会议programs可以自由安排
    // 返回能安排的最多会议数量
    private static int process(Program[] programs, int done, int timeLine) {
        if (programs.length == 0) {
            return done;
        }
        // 还有会议可以选择
        int max = done;
        // 当前安排的会议是什么会，每一个都枚举
        for (int i = 0; i < programs.length; i++) {
            if (programs[i].start >= timeLine) {
                Program[] next = copyButExcept(programs, i);
                max = Math.max(max, process(next, done + 1, programs[i].end));
            }
        }
        return max;
    }

    private static Program[] copyButExcept(Program[] programs, int i) {
        Program[] arr = new Program[programs.length - 1];
        int ansi = 0;
        for (int j = 0; j < programs.length; j++) {
            if (j != i) {
                arr[ansi++] = programs[j];
            }
        }
        return arr;
    }

    public static int bestArrange2(Program[] programs) {
        Arrays.sort(programs, new ProgramComparator());

        int result = 0;
        int timeLine = 0;
        for (int i = 0; i < programs.length; i++) {
            if (timeLine <= programs[i].start) {
                result++;
                timeLine = programs[i].end;
            }
        }
        return result;
    }

    public static Program[] generateRandomProgram(int maxSize, int maxValue) {
        Program[] programs = new Program[(int)(Math.random() * maxSize + 1)];
        for (int i = 0; i < programs.length; i++) {
            int start = (int)(Math.random() * maxValue);
            int end = (int)(Math.random() * maxValue);
            if (start == end) {
                programs[i] = new Program(start, start + 1);
            } else {
                programs[i] = new Program(Math.min(start, end), Math.max(start, end));
            }
        }
        return programs;
    }

    public static class ProgramComparator implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
