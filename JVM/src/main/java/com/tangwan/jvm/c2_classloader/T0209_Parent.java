/*
 * File Name:T0209_Parent is created on 2020-04-16 10:50 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.jvm.c2_classloader;

/**
 * @author tangwan
 * @Description : T0209_Parent
 * @date 2020-04-16 10:50
 * @since JDK 1.8
 */
public class T0209_Parent {
    private static T0205_MIneClassLoader parent = new T0205_MIneClassLoader();

    private static class MyLoader extends ClassLoader {
        public MyLoader() {
            super(parent);
        }
    }

    public static void main(String[] args) {
        MyLoader loader = new MyLoader();
        System.out.println(loader.getParent());
    }
}
