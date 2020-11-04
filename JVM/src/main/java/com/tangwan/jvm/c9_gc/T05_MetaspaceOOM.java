/*
 * File Name:T05_MetaspaceOOM is created on 2020-10-28 17:48 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c9_gc;

import java.io.File;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhao Xiaoli
 * @Description : T05_MetaspaceOOM
 * @date 2020-10-28 17:48
 * @since JDK 1.8
 */
public class T05_MetaspaceOOM {
    public static void main(String[] args) {
        try {
            //准备url
            URL url = new File("/Users/sunshine/Documents/zhaoxl/mine/git/tangwan/JavaRelated/JVM/src/main/java/com/tangwan/jvm").toURI().toURL();
            URL[] urls = {url};
            //获取有关类型加载的JMX接口
            ClassLoadingMXBean loadingBean = ManagementFactory.getClassLoadingMXBean();
            //用于缓存类加载器
            List<ClassLoader> classLoaders = new ArrayList<ClassLoader>();
            while (true) {
                //加载类型并缓存类加载器实例
                ClassLoader classLoader = new URLClassLoader(urls);
                classLoaders.add(classLoader);
                classLoader.loadClass("com.tangwan.jvm.c9_gc.T05_MetaspaceOOM");
                //显示数量信息（共加载过的类型数目，当前还有效的类型数目，已经被卸载的类型数目）System.out.println("total: " + loadingBean.getTotalLoadedClassCount());
                System.out.println("active: " + loadingBean.getLoadedClassCount());
                System.out.println("unloaded: " + loadingBean.getUnloadedClassCount());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
