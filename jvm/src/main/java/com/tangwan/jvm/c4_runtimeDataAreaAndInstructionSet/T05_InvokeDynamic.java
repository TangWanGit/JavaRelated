/*
 * File Name:T05_InvokeDynamic is created on 2020-04-16 15:34 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c4_runtimeDataAreaAndInstructionSet;

/**
 * @author Zhao Xiaoli
 * @Description : T05_InvokeDynamic
 * @date 2020-04-16 15:34
 * @since JDK 1.8
 */
public class T05_InvokeDynamic {
    public static void main(String[] args) {
        I i = C::n;
        I i2 = C::n;
        I i3 = C::n;
        I i4 = () -> C.n();

        System.out.println(i.getClass());
        System.out.println(i2.getClass());
        System.out.println(i3.getClass());
        System.out.println(i4.getClass());
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
