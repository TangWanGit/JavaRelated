/*
 * File Name:HeapOOM is created on 2020-04-20 10:59 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Zhao Xiaoli
 * @Description : HeapOOM
 * Options: -verbose：c5_gc -Xms20m -Xmx20m -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
 * @date 2020-04-20 10:59
 * @since JDK 1.8
 */
public class HeapOOM {
    public static void main(String[] args) {
        List<Object> objects = new LinkedList<>();
        for (; ; ) {
            objects.add(new Object());
        }
    }
}
