/*
 * File Name:PrintCompilationTest is created on 2020-11-07 09:18 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c10_demo;

/**
 * @author Zhao Xiaoli
 * @Description : PrintCompilationTest
 * <p>
 * -XX:+PrintCompilation -XX:+UnlockDiagnosticVMOptions -XX:+PrintInlining
 * </p>
 * @date 2020-11-07 09:18
 * @since JDK 1.8
 */
public class PrintCompilationTest {
    public static final int NUM = 15000;

    public static int doubleValue(int i) {
        // 空循环用于后面演示JIT代码优化过程
        for (int j = 0; j < 100_000; j++) {
        }
        return i * 2;
    }

    public static long calcSum() {
        long sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum = doubleValue(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        for (int i = 0; i < NUM; i++) {
            calcSum();
        }
    }
}
