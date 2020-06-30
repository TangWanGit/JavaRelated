/*
 * File Name:T02_PrintAllSubsquences is created on 2020-06-30 17:16 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c11_dynamic_programming_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Zhao Xiaoli
 * @Description : T02_PrintAllSubsquences
 * @date 2020-06-30 17:16
 * @since JDK 1.8
 */
public class T02_PrintAllSubsquences {
    public static void main(String[] args) {
        String str = "aacc";

        List<String> subs = subs(str);
        for (String sub : subs) {
            System.out.println(sub);
        }

        System.out.println("==================");
        subs = subsNoRepeat(str);
        for (String sub : subs) {
            System.out.println(sub);
        }

    }

    private static List<String> subs(String str) {
        char[] chars = str.toCharArray();
        String path = "";
        List<String> ans = new ArrayList<>();
        process1(chars, 0, ans, path);
        return ans;
    }

    private static void process1(char[] chars, int index, List<String> ans, String path) {
        if (index == chars.length) {
            ans.add(path);
            return;
        }
        String no = path;
        process1(chars, index + 1, ans, no);
        String yes = path + chars[index];
        process1(chars, index + 1, ans, yes);
    }

    private static List<String> subsNoRepeat(String str) {
        char[] chars = str.toCharArray();
        String path = "";
        Set<String> set = new HashSet<>();
        process2(chars, 0, set, path);

        List<String> ans = new ArrayList<>();
        for (String cur : set) {
            ans.add(cur);
        }
        return ans;
    }

    private static void process2(char[] chars, int index, Set<String> set, String path) {
        if (index == chars.length) {
            set.add(path);
            return;
        }
        String no = path;
        process2(chars, index + 1, set, no);
        String yes = path + chars[index];
        process2(chars, index + 1, set, yes);
    }
}
