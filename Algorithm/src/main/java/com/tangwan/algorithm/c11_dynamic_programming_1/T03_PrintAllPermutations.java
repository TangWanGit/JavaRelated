/*
 * File Name:T03_PrintAllPermutations is created on 2020-06-30 17:35 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c11_dynamic_programming_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.tangwan.algorithm.c01_bs.T00_Base.swap;

/**
 * @author Zhao Xiaoli
 * @Description : T03_PrintAllPermutations
 * @date 2020-06-30 17:35
 * @since JDK 1.8
 */
public class T03_PrintAllPermutations {
    public static void main(String[] args) {
        String str = "aacc";
        List<String> permutation = permutation(str);
        for (String s : permutation) {
            System.out.println(s);
        }

        System.out.println("===================");
        permutation = permutationNoRepeat(str);
        for (String s : permutation) {
            System.out.println(s);
        }
    }

    private static List<String> permutation(String str) {
        List<String> ans = new ArrayList<>();
        char[] chars = str.toCharArray();
        process(chars, 0, ans);
        return ans;
    }

    private static void process(char[] chars, int i, List<String> ans) {
        if (i == chars.length) {
            ans.add(String.valueOf(chars));
        }
        for (int j = i; j < chars.length; j++) {
            swap(chars, i, j);
            process(chars, i + 1, ans);
            swap(chars, i, j);
        }
    }

    private static List<String> permutationNoRepeat(String str) {
        Set<String> set = new HashSet<>();
        char[] chars = str.toCharArray();
        process(chars, 0, set);
        List<String> ans = new ArrayList<>();
        for (String s : set) {
            ans.add(s);
        }
        return ans;
    }

    private static void process(char[] chars, int i, Set<String> ans) {
        if (i == chars.length) {
            ans.add(String.valueOf(chars));
        }
        for (int j = i; j < chars.length; j++) {
            swap(chars, i, j);
            process(chars, i + 1, ans);
            swap(chars, i, j);
        }
    }
}
