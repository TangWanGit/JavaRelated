/*
 * File Name:T02_Light is created on 2020-06-10 09:22 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c09_greedy_algorithm;

import java.util.HashSet;

/**
 * @author Zhao Xiaoli
 * @Description : T02_Light
 * XX...X.X
 * X位置不能放灯
 * .位置可以放灯，一个灯能照亮左右的.
 * <p>
 * 所以上述位置最少放2个灯即可
 * XX.灯.X灯X
 * @date 2020-06-10 09:22
 * @since JDK 1.8
 */
public class T02_Light {

    public static void main(String[] args) {
        int len = 20;
        int testTimes = 1000_000;
        for (int i = 0; i < testTimes; i++) {
            String str = randomString(len);
            int light1 = minLight1(str);
            int light2 = minLight2(str);
            if (light1 != light2) {
                System.out.println(str);
                System.out.println(light1);
                System.out.println(light2);
                break;
            }
        }
        System.out.println("finish");
    }

    public static int minLight1(String road) {
        if (null == road || road.length() == 0) {
            return 0;
        }
        return process1(road.toCharArray(), 0, new HashSet<Integer>());
    }

    // str[index....]位置，自由选择放灯还是不放灯
    // str[0..index-1]位置呢？已经做完决定了，那些放了灯的位置，存在lights里
    // 要求选出能照亮所有.的方案，并且在这些有效的方案中，返回最少需要几个灯
    private static int process1(char[] str, int index, HashSet<Integer> lights) {
        if (index == str.length) {
            for (int i = 0; i < str.length; i++) {
                if (str[i] != 'X') {
                    if (!lights.contains(i - 1) && !lights.contains(i) && !lights.contains(i + 1)) {
                        return Integer.MAX_VALUE;
                    }
                }
            }
            return lights.size();
        } else { // str还没结束
            int no = process1(str, index + 1, lights);
            int yes = Integer.MAX_VALUE;
            if (str[index] == '.') {
                lights.add(index);
                yes = process1(str, index + 1, lights);
                lights.remove(index);
            }
            return Math.min(no, yes);
        }
    }

    public static int minLight2(String road) {
        if (null == road || road.length() == 0) {
            return 0;
        }
        int light = 0;
        int index = 0;
        while (index < road.length()) {
            if (road.charAt(index) == 'X') {
                index++;
            } else {
                light++;
                if (index + 1 == road.length()) {
                    break;
                }
                if (road.charAt(index + 1) == 'X') {
                    index = index + 2;
                } else {
                    index = index + 3;
                }
            }
        }
        return light;
    }

    public static String randomString(int len) {
        char[] chs = new char[(int)(Math.random() * len + 1)];
        for (int i = 0; i < chs.length; i++) {
            chs[i] = Math.random() < 0.5 ? 'X' : '.';
        }
        return String.valueOf(chs);
    }
}
