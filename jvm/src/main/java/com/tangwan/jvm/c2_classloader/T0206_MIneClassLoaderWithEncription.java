/*
 * File Name:T0205_MIneClassLoader is created on 2020-04-15 19:24 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c2_classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.tangwan.jvm.Hello;

/**
 * @author Zhao Xiaoli
 * @Description : T0205_MIneClassLoader
 * @date 2020-04-15 19:24
 * @since JDK 1.8
 */
public class T0206_MIneClassLoaderWithEncription extends ClassLoader {
    public static int seed = 0B10110110;

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File f = new File("/Users/sunshine/Documents/zhaoxl/mine/git/tangwan/JavaRelated/jvm/target/classes",
            name.replace(".", "/").concat(".mclass"));

        try {
            FileInputStream fis = new FileInputStream(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;

            while ((b = fis.read()) != 0) {
                baos.write(b ^ seed);
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
        throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        encFile("com.tangwan.jvm.Hello");

        ClassLoader l = new T0206_MIneClassLoaderWithEncription();
        Class<?> clazz = l.loadClass("com.tangwan.jvm.Hello");

        Hello h = (Hello)clazz.newInstance();
        h.m();

        System.out.println(l.getClass().getClassLoader());
        System.out.println(l.getParent());
    }

    private static void encFile(String name) throws IOException {
        File f = new File("/Users/sunshine/Documents/zhaoxl/mine/git/tangwan/JavaRelated/jvm/target/classes",
            name.replace(".", "/").concat(".class"));
        FileInputStream fis = new FileInputStream(f);
        FileOutputStream fos = new FileOutputStream(
            new File("/Users/sunshine/Documents/zhaoxl/mine/git/tangwan/JavaRelated/jvm/target/classes",
                name.replace(".", "/").concat("m.class")));

        int b = 0;
        while ((b = fis.read()) != -1) {
            fos.write(b ^ seed);
        }

        fis.close();
        fos.close();

    }

}
