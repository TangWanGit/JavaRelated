/*
 * File Name:T0205_MIneClassLoader is created on 2020-04-15 19:24 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.jvm.c2_classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.tangwan.jvm.Hello;

/**
 * @author tangwan
 * @Description : T0205_MIneClassLoader
 * @date 2020-04-15 19:24
 * @since JDK 1.8
 */
public class T0205_MIneClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File f = new File("/Users/sunshine/Documents/zhaoxl/mine/git/tangwan/JavaRelated/jvm/target/classes",
            name.replace(".", "/").concat(".class"));

        try {
            FileInputStream fis = new FileInputStream(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;

            while ((b = fis.read()) != 0) {
                baos.write(b);
            }

            byte[] bytes = baos.toByteArray();
            baos.close();
            fis.close();
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    /**
     * 执行结果：
     * true
     * Hello JVM!
     * sun.misc.Launcher$AppClassLoader@18b4aac2
     * sun.misc.Launcher$AppClassLoader@18b4aac2
     * sun.misc.Launcher$AppClassLoader@18b4aac2
     *
     * @param args
     *
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static void main(String[] args)
        throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        ClassLoader l = new T0205_MIneClassLoader();
        Class<?> clazz = l.loadClass("com.tangwan.jvm.Hello");
        Class<?> clazz1 = l.loadClass("com.tangwan.jvm.Hello");

        System.out.println(clazz == clazz1);

        Hello h = (Hello)clazz.newInstance();
        h.m();

        System.out.println(h.getClass().getClassLoader());

        System.out.println(l.getClass().getClassLoader());
        System.out.println(l.getParent());

        System.out.println(getSystemClassLoader());
    }

}
