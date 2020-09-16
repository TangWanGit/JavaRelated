/*
 * File Name:T01_PretenureSizeThreshold is created on 2020-09-10 19:03 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c6_allocate;

/**
 * @author Zhao Xiaoli
 * @Description : T01_PretenureSizeThreshold
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=1048576 -XX:+PrintCommandLineFlags
 * @date 2020-09-10 19:03
 * @since JDK 1.8
 */
public class T01_PretenureSizeThreshold {
    public static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }
}
