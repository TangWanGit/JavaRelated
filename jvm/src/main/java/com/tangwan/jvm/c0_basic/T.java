/*
 * File Name:T is created on 2020-04-15 15:35 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.jvm.c0_basic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tangwan
 * @Description : T
 * @date 2020-04-15 15:35
 * @since JDK 1.8
 */
public class T {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        Runtime runtime = Runtime.getRuntime();
        long l1 = runtime.freeMemory();
        for (int i = 0; i < 100_0000; i++) {
            list.add(new Object());
        }
        long l2 = runtime.freeMemory();

        System.out.println((l1 - l2));
        System.out.println((l1 - l2) / 1024);
        System.out.println((l1 - l2) / (1024.0 * 1024.0));
    }
}
