/*
 * File Name:Singleton is created on 2020-08-06 22:44 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c2_classloader;

/**
 * @author Zhao Xiaoli
 * @Description : Singleton
 * @date 2020-08-06 22:44
 * @since JDK 1.8
 */
public class Singleton {
    //JIT
    // 单例模式
    public static volatile Singleton INSTANCE;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            // 双重检查
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }
}
