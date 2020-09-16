/*
 * File Name:HeapOOM is created on 2020-04-20 10:59 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tangwan
 * @Description : HeapOOM
 * Options: -verbose：c5_gc -Xms20m -Xmx20m -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
 * @date 2020-04-20 10:59
 * @since JDK 1.8
 */
public class HeapOOM {
    public static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        List<byte[]> byteList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            byte[] bytes = new byte[2 * _1MB];
            byteList.add(bytes);
        }
    }
}
