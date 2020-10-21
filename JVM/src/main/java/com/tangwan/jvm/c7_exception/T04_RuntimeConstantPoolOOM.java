/*
 * File Name:T04_RuntimeConstantPoolOOm is created on 2020-10-19 11:47 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c7_exception;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Zhao Xiaoli
 * @Description : T04_RuntimeConstantPoolOOm
 * @date 2020-10-19 11:47
 * @since JDK 1.8
 */
public class T04_RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        String s1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(s1.intern() == s1);

        // 在sun.misc.Version中进入常量池的
        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern() == s2);

        Integer i1 = 1;
        Integer i2 = 1;
        System.out.println(i1 == i2);
        i1 = 130;
        i2 = 130;
        System.out.println(i1 == i2);
    }

    public static void testOOM() {
        Set<String> set = new HashSet<>();
        try {
            // 使用Set保持着常量池的引用，避免Full GC回收常量池行为
            //在short范围内足以让6MB的PermSize产生OOM了
            short i = 0;
            while (true) {
                set.add(String.valueOf(i++).intern());
            }
        } catch (Throwable e) {
            System.out.println("set size" + set.size());
            throw e;
        }
    }
}
