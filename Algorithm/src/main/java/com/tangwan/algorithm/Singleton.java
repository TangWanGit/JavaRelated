/*
 * File Name:Singleton is created on 2020-05-22 09:07 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm;

import java.io.Serializable;

/**
 * @author Zhao Xiaoli
 * @Description : Singleton
 * @date 2020-05-22 09:07
 * @since JDK 1.8
 */
public class Singleton implements Serializable {
    private volatile static Singleton singleton;

    static {
        singleton = getSingleton();
    }

    private Singleton() {
        if (singleton != null) {
            throw new RuntimeException("is called");
        }
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    // 加了这个方法，反序列化破坏单例就不成功了
    //private Object readResolve() {
    //    return getSingleton();
    //}
}
