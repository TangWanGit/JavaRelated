/*
 * File Name:T0201_ClassLoaderLevel is created on 2020-04-15 19:18 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.jvm.c2_classloader;

import sun.net.spi.nameservice.dns.DNSNameService;

/**
 * @author tangwan
 * @Description : T0201_ClassLoaderLevel
 * 类加载等级
 * Bootstrap
 * ExtClassLoader   AppClassLoader
 * 自定义ClassLoader
 * @date 2020-04-15 19:18
 * @since JDK 1.8
 */
public class T0201_ClassLoaderLevel {
    public static void main(String[] args) {
        // 查看是被谁load到内存的，执行结果为null，为什么是null呢? Bootstrap使用c++实现的，Java里没有class和它对应
        System.out.println(String.class.getClassLoader());
        // 这个是核心类库某个包里的类
        System.out.println(sun.awt.HKSCS.class.getClassLoader());
        // 这个类是位于ext目录下某个jar文件里，执行结果为sun.misc.Launcher$ExtClassLoader@66d3c617
        System.out.println(DNSNameService.class.getClassLoader());
        // 这是我们自己实现的类，加载器sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(T0201_ClassLoaderLevel.class.getClassLoader());
        // 这是一个ext的ClassLoader调用getClass，然后再调用getClassLoader,就是想获取ExtClassLoader的ClassLoader是哪个
        System.out.println(DNSNameService.class.getClassLoader().getClass().getClassLoader());
        System.out.println(T0201_ClassLoaderLevel.class.getClassLoader().getClass().getClassLoader());

        System.out.println(new T0205_MIneClassLoader().getParent());

        System.out.println(ClassLoader.class.getClassLoader());
    }
}
