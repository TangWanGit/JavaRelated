package com.tangwan.common.utils;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * -Xmx20M -XX:MaxDirectMemorySize=10M
 *
 * @author Zhao Xiaoli
 * @date 2021/3/12 11:23 上午
 * @since JDK 1.8
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe)unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}