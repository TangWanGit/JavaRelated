/*
 * File Name:T0303_HeapDump is created on 2020-04-16 15:22 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.jvm.c3_jmm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tangwan
 * @Description : T0303_HeapDump
 * 内存溢出：
 * -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath="/Users/sunshine/Documents/tmp/jvm.dump
 * -XX:+PrintGCDetails -Xms10M -Xmx10M
 * @date 2020-04-16 15:22
 * @since JDK 1.8
 */
public class T0303_HeapDump {
    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i = 0; i < 1000_0000; i++) {
            list.add(new byte[1024 * 1024]);
        }
    }
}
