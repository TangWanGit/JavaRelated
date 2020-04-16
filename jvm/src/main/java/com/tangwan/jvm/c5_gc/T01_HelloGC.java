/*
 * File Name:T01_HelloGC is created on 2020-04-16 16:29 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c5_gc;

/**
 * @author Zhao Xiaoli
 * @Description : T01_HelloGC
 * -XX:+PrintGCDetails -XX:+UseConcMarkSweepGC -XX:+PrintFlagsFinal -XX:+PrintVMOptions -Xms20m -Xmx20m
 * @date 2020-04-16 16:29
 * @since JDK 1.8
 */
public class T01_HelloGC {
    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            byte[] b = new byte[1024 * 1024];
        }
    }
}
