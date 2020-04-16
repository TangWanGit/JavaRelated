/*
 * File Name:T0210_ClassReloading1 is created on 2020-04-16 10:52 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c2_classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Zhao Xiaoli
 * @Description : T0210_ClassReloading1
 * 破坏双亲委派
 * @date 2020-04-16 10:52
 * @since JDK 1.8
 */
public class T0211_ClassReloading1 {

    private static class MyLoader extends ClassLoader {
        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            File f = new File("/Users/sunshine/Documents/zhaoxl/mine/git/tangwan/JavaRelated/jvm/target/classes",
                name.replace(".", "/").concat(".class"));
            if (!f.exists()) {
                return super.loadClass(name);
            }
            try {
                FileInputStream fis = new FileInputStream(f);

                byte[] b = new byte[fis.available()];
                fis.read(b);
                return defineClass(name, b, 0, b.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return super.loadClass(name);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        MyLoader classLoader = new MyLoader();
        Class clazz = classLoader.loadClass("com.tangwan.jvm.Hello");

        System.out.println(clazz.hashCode());

        classLoader = new MyLoader();
        Class clazz1 = classLoader.loadClass("com.tangwan.jvm.Hello");
        System.out.println(clazz1.hashCode());

        System.out.println(clazz == clazz1);
    }
}
