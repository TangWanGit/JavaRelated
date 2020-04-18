/*
 * File Name:ExeModeCompVSMixed is created on 2020-04-16 19:44 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm;

/**
 * @author Zhao Xiaoli
 * @Description : ExeModeCompVSMixed
 * @date 2020-04-16 19:44
 * @since JDK 1.8
 */
public class ExeModeCompVSMixed {
    public static void main(String[] args) {
        long t = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            getMemoryInfo();
        }
        System.out.println(System.currentTimeMillis() - t);

    }

    private static void getMemoryInfo() {
        double pi = 3.14;

        for (int i = 0; i < 1_0000; i++) {

            pi = 3.14 / 2.58;
            pi = 3.14;
            long t = Runtime.getRuntime().totalMemory();
            new ExeModeCompVSMixed();
        }
    }
}
