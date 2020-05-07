/*
 * File Name:T0200_ClassLoadingProcedure is created on 2020-04-15 17:14 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.jvm.c2_classloader;

/**
 * @author tangwan
 * @Description : T0200_ClassLoadingProcedure
 * class加载过程
 * @date 2020-04-15 17:14
 * @since JDK 1.8
 */
public class T0200_ClassLoadingProcedure {
    public static void main(String[] args) {
        System.out.println(T.count);
    }
}

class T {
    /**
     * 类加载过程：
     * <p>
     * 静态变量，从上到下依次加载
     */
    public static T t = new T();
    public static int count = 2;
    private int m = 8;

    private T() {
        count++;
        System.out.println("--" + count);
    }
}
