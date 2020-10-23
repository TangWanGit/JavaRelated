/*
 * File Name:T07_TestAllocation is created on 2020-10-22 14:17 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c7_exception;

/**
 * @author Zhao Xiaoli
 * @Description : 测试内存分配
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+PrintCommandLineFlags -XX:+UseSerialGC
 * @date 2020-10-22 14:17
 * @since JDK 1.8
 */
public class T07_TestAllocation {
    public static final int _1MB = 1024 * 1024;

    /**
     * 书上说，在给allocation4分配的时候才会产生Minor GC，然后新生代占用4M，老年代占用6M
     * 但我在实践的过程中发现，在给allocation3分配的时候就会产生Minor GCl，然后新生代占用6M，老年代占用4M，本人使用环境为jdk8,UseParallelGC
     * 这是个问题，ParallelGC在什么时间点会触发Minor GC
     *
     * @param args
     */
    public static void main(String[] args) {
        testAllocation();
        //testPretenureSizeThreshold();
    }

    /**
     * -XX:PretenureSizeThreshold=3145728
     */
    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }

    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }
}
