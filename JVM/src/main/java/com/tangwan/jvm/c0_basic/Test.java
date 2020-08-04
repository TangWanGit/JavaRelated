/*
 * File Name:Test is created on 2020-08-03 20:22 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c0_basic;

/**
 * @author Zhao Xiaoli
 * @Description : Test
 * @date 2020-08-03 20:22
 * @since JDK 1.8
 */
public class Test {
    static {
        i = 0;
        //System.out.println(i);
    }

    static int i = 1;

    static class Parent {
        public static int A = 1;

        static {
            A = 2;
        }
    }

    static class Sub extends Parent {
        public static int B = A;
    }

    static class DeadLoopClass {
        static {
            /** 如果不加上这个if语句，编译器将提示"Initializer does not complete normally" 并拒绝编译 */
            if (true) {
                System.out.println(Thread.currentThread() + "init DeadLoopClass");
                while (true) {
                }
            }
        }
    }

    public static void main(String[] args) {
        Runnable script = () -> {
            System.out.println(Thread.currentThread().getName() + "start");
            DeadLoopClass deadLoopClass = new DeadLoopClass();
            System.out.println(Thread.currentThread() + "run over");
        };

        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);
        thread1.start();
        thread2.start();
    }
}
