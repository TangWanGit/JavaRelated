/*
 * File Name:T06 is created on 2020-04-16 15:54 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c4_runtimeDataAreaAndInstructionSet;

/**
 * @author Zhao Xiaoli
 * @Description : T06
 * @date 2020-04-16 15:54
 * @since JDK 1.8
 */
public class T06 {
    public static void main(String[] args) {
        int i = 100;
    }

    public void m1() {
        int i = 200;
    }

    public void m2(int k) {
        int i = 300;
    }

    public void add(int a, int b) {
        int c = a + b;
    }

    public void m3() {
        Object o = null;
    }

    public void m4() {
        Object o = new Object();
    }

    public int m(int n) {
        if (n == 1) {
            return 1;
        }
        return n * m(n - 1);
    }

}
