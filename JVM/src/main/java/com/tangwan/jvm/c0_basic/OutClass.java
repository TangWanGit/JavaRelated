/*
 * File Name:OutClass is created on 2020-09-24 21:03 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c0_basic;

/**
 * @author Zhao Xiaoli
 * @Description : OutClass
 * @date 2020-09-24 21:03
 * @since JDK 1.8
 */
public class OutClass {
    static int i = 100;

    public static void main(String[] args) {
        OutClass.StaticClass.print();
    }

    static class StaticClass {
        public static void print() {
            System.out.println(i);
        }
    }
    class NotStaticClass {
        public  void print() {
            System.out.println(i);
        }
    }

}
