/*
 * File Name:T00_LambdaGC is created on 2020-04-16 15:34 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.jvm.c5_gc;

/**
 * @author tangwan
 * @Description : T00_LambdaGC
 * -XX:+PrintGCDetails -Xms10m -Xmx10m
 * @date 2020-04-16 15:34
 * @since JDK 1.8
 */
public class T00_LambdaGC {
    public static void main(String[] args) {
        for (; ; ) {
            I i = C::n;
            i.m();
        }
    }

    @FunctionalInterface
    public interface I {
        void m();
    }

    public static class C {
        static void n() {
            System.out.println("hello");
        }
    }
}
