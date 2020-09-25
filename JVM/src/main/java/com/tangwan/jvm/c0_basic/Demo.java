/*
 * File Name:Demo is created on 2020-09-19 17:34 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c0_basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Zhao Xiaoli
 * @Description : Demo
 * @date 2020-09-19 17:34
 * @since JDK 1.8
 */
public class Demo {
    public Demo() {
        System.out.println(IntegerCache.low);
    }

    public static void main(String[] args) {
        //Integer i1 = 120;
        //Integer i2 = 120;
        //Integer i3 = new Integer(120);
        //Integer i4 = 128;
        //Integer i5 = 128;
        //System.out.println(i1 == i2);
        //System.out.println(i1 == i3);
        //System.out.println(i4 == i5);

        //String s1 = "test";
        //String s2 = "test";
        //String s3 = new String("test");
        //String s4 = new String("test").intern();
        //System.out.println(s1 == s2);
        //System.out.println(s1 == s3);
        //System.out.println(s1 == s4);
        //
        //String s = new String("你好世界");
        //
        //for (int i = 0; i < s.length(); i++) {
        //    System.out.print("\\u" + Integer.toHexString(s.charAt(i)));
        //}
        //
        //System.out.println(("\n\u4f60\u597d\u4e16\u754c"));

        String s1 = "hello world";
        String s2 = "hello";
        // 运行时通过StringBuilder拼接后返回的toString()
        String s3 = s2 + " world";
        String s4 = "hello" + " world";
        System.out.println(s1 == s3);
        System.out.println(s1 == s3.intern());
        System.out.println(s1 == s4);

        int i1 = 3;
        int i2 = 3;
        System.out.println(i1 == i2);
    }

    private static class IntegerCache {
        static {
            System.out.println("IntegerCache");
        }

        static final int low = -128;
    }

    /**
     * public void test();
     * Code:
     * 0: iconst_1
     * 1: istore_1
     * 2: bipush        10
     * 4: istore_2
     * 5: sipush        128
     * 8: istore_3
     * 9: ldc           #12                 // int 32768
     * 11: istore        4
     * 13: ldc           #13                 // int -32769
     * 15: istore        5
     * 17: iconst_m1
     * 18: istore        6
     * 20: return
     */
    public void test() {
        int const_1 = 1;
        int bipush = 10;
        int sipush = 128;
        int ldc = 32768;
        int ldc2 = 32768;

        int ldc3 = -32769;
        int iconst_m1 = -1;

        Integer integer1 = new Integer(32769);
        Integer integer2 = new Integer(32769);

        System.out.println(integer1 == integer2);
        System.out.println(ldc == ldc2);
        System.out.println(ldc != ldc2);
    }

    public void testString() {
        String s1 = "hello world";
        String s2 = "hello";
        // 运行时通过StringBuilder拼接后返回的toString()
        String s3 = s2 + " world";
        System.out.println(s1 == s3);
        System.out.println(s1 == s3.intern());
        String s4 = "hello" + " world";
        System.out.println(s1 == s4);
    }

    static int i = 0;
    public static class People {

        String name;

        public People(String name) {
            System.out.println(i);
            this.name = name;
        }

        public static void print() {
            System.out.println("hello ");
        }
        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (obj instanceof People) {
                return name.equals(((People)obj).name);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }

        @Override
        public String toString() {
            return "People{" + "name='" + name + '\'' + '}';
        }
    }
}


