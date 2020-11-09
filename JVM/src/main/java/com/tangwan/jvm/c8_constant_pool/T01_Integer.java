/*
 * File Name:T01_Integer is created on 2020-10-21 10:36 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c8_constant_pool;

/**
 * @author Zhao Xiaoli
 * @Description : T01_Integer
 * @date 2020-10-21 10:36
 * @since JDK 1.8
 */
public class T01_Integer {
    public static void main(String[] args) {
        testSugar();
    }

    public static void testSugar() {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;

        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals((a + b)));
        System.out.println(g == (a + b));
        System.out.println(g.equals((a + b)));
    }

    public static void test() {
        System.out.println(1 << 12);
        System.out.println(1 << 15);

        long l = 3;
        System.out.println(l);

        Integer const_1 = 1;
        Integer const_2 = 1;
        Integer bipush = 127;
        Integer bipush2 = 127;
        Integer sipush = 128;
        Integer sipush2 = 128;
        Integer ldc = Integer.valueOf(32768);
        Integer ldc2 = new Integer(32768);
        System.out.println(const_1 == const_2);
        System.out.println(bipush == bipush2);
        System.out.println(sipush == sipush2);
        System.out.println(ldc == ldc2);

        boolean b = true;
        if (b) {
            System.out.println("b");
        }
        if (b == true) {
            System.out.println("==");
        }

        System.out.println(T00_Constant.C);
    }

}
