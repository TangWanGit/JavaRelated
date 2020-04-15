/*
 * File Name:T0202_ClassLoaderScope is created on 2020-04-15 19:30 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c2_classloader;

/**
 * @author Zhao Xiaoli
 * @Description : T0202_ClassLoaderScope
 * @date 2020-04-15 19:30
 * @since JDK 1.8
 */
public class T0202_ClassLoaderScope {
    public static void main(String[] args) {
        String pathBoot = System.getProperty("sun.boot.class.path");
        System.out.println(pathBoot);
        System.out.println(pathBoot.replaceAll(":", System.lineSeparator()));

        System.out.println("--------------------------");
        String pathExt = System.getProperty("java.ext.dirs");
        System.out.println(pathExt.replaceAll(":", System.lineSeparator()));

        System.out.println("--------------------------");
        String pathApp = System.getProperty("java.class.path");
        System.out.println(pathApp.replaceAll(":", System.lineSeparator()));
    }
}
