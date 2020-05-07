/*
 * File Name:T0300_PrintMemoryInfo is created on 2020-04-16 11:18 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.jvm.c3_jmm;

/**
 * @author tangwan
 * @Description : T0300_PrintMemoryInfo
 * @date 2020-04-16 11:18
 * @since JDK 1.8
 */
public class T0300_PrintMemoryInfo {
    public static void main(String[] args) {
        long free1 = printMemoryInfo();

        byte[] b = new byte[1024 * 1024];
        System.out.println("------------------");

        long free2 = printMemoryInfo();

        System.out.println((free1 - free2) / 1024);
    }

    private static long printMemoryInfo() {
        System.out.println("total : " + Runtime.getRuntime().totalMemory());
        System.out.println("free  : " + Runtime.getRuntime().freeMemory());
        return Runtime.getRuntime().freeMemory();
    }
}

