/*
 * File Name:T0210_ClassReloading1 is created on 2020-04-16 10:52 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c2_classloader;

/**
 * @author Zhao Xiaoli
 * @Description : T0210_ClassReloading1
 * 验证双亲委派
 * @date 2020-04-16 10:52
 * @since JDK 1.8
 */
public class T0210_ClassReloading1 {
    public static void main(String[] args) throws ClassNotFoundException {
        T0205_MIneClassLoader classLoader = new T0205_MIneClassLoader();
        Class clazz = classLoader.loadClass("com.tangwan.jvm.Hello");

        classLoader = null;
        System.out.println(clazz.hashCode());

        classLoader = null;

        classLoader = new T0205_MIneClassLoader();
        Class clazz1 = classLoader.loadClass("com.tangwan.jvm.Hello");
        System.out.println(clazz1.hashCode());

        System.out.println(clazz == clazz1);
    }
}
