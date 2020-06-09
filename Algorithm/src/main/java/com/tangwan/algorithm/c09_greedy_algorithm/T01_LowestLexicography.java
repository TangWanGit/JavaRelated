/*
 * File Name:T01_LowestLexicography is created on 2020-06-04 17:44 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c09_greedy_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Zhao Xiaoli
 * @Description : T01_LowestLexicography
 * @date 2020-06-04 17:44
 * @since JDK 1.8
 */
public class T01_LowestLexicography {
    public static void main(String[] args) {
        int arrLen = 6;
        int strLen = 5;
        int testTimes = 1000_000;
        System.out.println("test begin");
        for (int i = 0; i < testTimes; i++) {
            String[] strs1 = generateRandomStringArray(arrLen, strLen);
            String[] strs2 = copyStringArray(strs1);
            if (!lowestLexicography1(strs1).equals(lowestLexicography2(strs2))) {
                System.out.println(lowestLexicography1(strs1));
                System.out.println(lowestLexicography2(strs2));
                System.out.println("Oops");
                break;
            }
        }
        System.out.println("test finish");
    }

    private static String[] copyStringArray(String[] arr) {
        String[] ans = new String[arr.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = String.valueOf(arr[i]);
        }
        return ans;
    }

    // for test
    public static String generateRandomString(int strLen) {
        char[] ans = new char[(int)(Math.random() * strLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            int value = (int)(Math.random() * 5);
            ans[i] = (char)(97 + value);
        }
        return String.valueOf(ans);
    }

    // for test
    public static String[] generateRandomStringArray(int arrLen, int strLen) {
        String[] ans = new String[(int)(Math.random() * arrLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = generateRandomString(strLen);
        }
        return ans;
    }

    public static String lowestLexicography1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }

        List<String> all = new ArrayList<>();
        Set<Integer> use = new HashSet<>();
        process(strs, use, "", all);
        String lowest = all.get(0);
        for (String s : all) {
            if (lowest.compareTo(s) > 0) {
                lowest = s;
            }
        }
        return lowest;
    }

    // strs里放着所有的字符串
    // 已经使用过的字符串的下标，在use里登记了，不要再使用了
    // 之前使用过的字符串，拼接成了-> path
    // 用all收集所有可能的拼接结果
    private static void process(String[] strs, Set<Integer> use, String path, List<String> all) {
        if (use.size() == strs.length) {
            all.add(path);
        }
        for (int i = 0; i < strs.length; i++) {
            if (!use.contains(i)) {
                use.add(i);
                process(strs, use, path + strs[i], all);
                use.remove(i);
            }
        }
    }

    public static String lowestLexicography2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        Arrays.sort(strs, new MyComparator());
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            res.append(strs[i]);
        }
        return res.toString();
    }

    public static class MyComparator implements Comparator<String> {

        @Override
        public int compare(String a, String b) {
            return (a + b).compareTo(b + a);
        }
    }
}
