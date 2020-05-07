/*
 * File Name:T0208_WayToRun is created on 2020-04-16 10:26 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.jvm.c2_classloader;

/**
 * @author tangwan
 * @Description : T0208_WayToRun
 * 热点代码
 * @date 2020-04-16 10:26
 * @since JDK 1.8
 */
public class T0208_WayToRun {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10_0000; i++) {
            m();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        for (int i = 0; i < 10_0000; i++) {
            m();
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void m() {
        for (int i = 0; i < 10_0000; i++) {
            long j = i % 3;
        }
    }
}
