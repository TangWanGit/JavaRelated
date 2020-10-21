/*
 * File Name:T06_DirectMemoryOOM is created on 2020-10-20 11:47 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c7_exception;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * @author Zhao Xiaoli
 * @Description : T06_DirectMemoryOOM
 * -Xmx20m -XX:MaxDirectMemorySize=10m
 * @date 2020-10-20 11:47
 * @since JDK 1.8
 */
public class T06_DirectMemoryOOM {
    public static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe)unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }

}
