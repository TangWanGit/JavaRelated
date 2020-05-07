/*
 * File Name:T0207_LazyLoading is created on 2020-04-16 10:17 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.jvm.c2_classloader;

/**
 * @author tangwan
 * @Description : T0207_LazyLoading
 * <p>
 * 严格讲应该叫lazy initialization，因为java虚拟机规范并没有严格规定什么时候必须loading,但严格规定了什么时候initialization
 * @date 2020-04-16 10:17
 * @since JDK 1.8
 */
public class T0207_LazyLoading {

    public static void main(String[] args) throws ClassNotFoundException {
        P p;
        //X x = new X();
        //System.out.println(P.i);
        //System.out.println(P.j);

        Class.forName("com.tangwan.jvm.c2_classloader.T0207_LazyLoading$X");
    }

    public static class P {
        final static int i = 8;
        static int j = 9;

        static {
            System.out.println("P");
            System.out.println("P.i=" + i);
            System.out.println("P.j=" + j);

        }
    }

    public static class X extends P {
        static {
            System.out.println("X");
        }
    }
}
