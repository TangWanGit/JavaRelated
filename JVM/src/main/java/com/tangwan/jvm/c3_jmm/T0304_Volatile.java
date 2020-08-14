/*
 * File Name:T0304_Volatile is created on 2020-08-13 21:48 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c3_jmm;

/**
 * @author Zhao Xiaoli
 * @Description : T0304_Volatile
 * @date 2020-08-13 21:48
 * @since JDK 1.8
 */
public class T0304_Volatile {
    public static final String s = "s";

    static {
        System.out.println(s);
    }

    int i = 9;
    final int j = 10;

    public T0304_Volatile() {
        this.i = 18;
    }

    public static void main(String[] args) {
        T0304_Volatile ex = new T0304_Volatile();
        System.out.println(ex.i);
        System.out.println(ex.j);
    }
}
