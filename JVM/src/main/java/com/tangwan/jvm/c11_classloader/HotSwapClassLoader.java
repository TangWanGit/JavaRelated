/*
 * File Name:HotSwapClassLoader is created on 2020-11-06 16:00 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c11_classloader;

/**
 * @author Zhao Xiaoli
 * @Description : HotSwapClassLoader
 * @date 2020-11-06 16:00
 * @since JDK 1.8
 */
public class HotSwapClassLoader extends ClassLoader {
    public HotSwapClassLoader() {
        super(HotSwapClassLoader.class.getClassLoader());
    }

    public Class loadByte(byte[] classByte) {
        return defineClass(null, classByte, 0, classByte.length);
    }
}
