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
        System.out.println(String.class.getClassLoader());
        System.out.println(sun.awt.HKSCS.class.getClassLoader());
        System.out.println(DNSNameService.class.getClassLoader());
        System.out.println(T0201_ClassLoaderLevel.class.getClassLoader());

        System.out.println(DNSNameService.class.getClassLoader().getClass().getClassLoader());
        System.out.println(T0201_ClassLoaderLevel.class.getClassLoader().getClass().getClassLoader());

        System.out.println(new T0205_MIneClassLoader().getParent());

        System.out.println(ClassLoader.class.getClassLoader());
    }
}
