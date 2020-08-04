/*
 * File Name:ClassLoaderTest is created on 2020-08-04 11:06 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.classloading;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Zhao Xiaoli
 * @Description : 类加载器与instanceof关键字演示
 * @date 2020-08-04 11:06
 * @since JDK 1.8
 */
public class ClassLoaderTest {
    public static void main(String[] args)
        throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader myClassLoader = new MyClassLoader();
        Object obj = myClassLoader.loadClass("com.tangwan.jvm.classloading.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj.getClass().getClassLoader());
        System.out.println(obj instanceof ClassLoaderTest);
    }

    public static class MyClassLoader extends ClassLoader {
        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {

            try {
                String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                InputStream is = getClass().getResourceAsStream(fileName);
                if (is == null) {
                    return super.loadClass(name);
                }
                byte[] b = new byte[is.available()];
                is.read(b);
                return defineClass(name, b, 0, b.length);
            } catch (IOException e) {
                throw new ClassNotFoundException(name);
            }
        }
    }
}
