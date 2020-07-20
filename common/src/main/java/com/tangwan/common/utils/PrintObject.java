/*
 * File Name:PrintObject is created on 2020-07-20 12:55 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.common.utils;

/**
 * @author Zhao Xiaoli
 * @Description : PrintObject
 * @date 2020-07-20 12:55
 * @since JDK 1.8
 */
public class PrintObject {
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int o : arr) {
            System.out.print(o + " ");
        }
        System.out.print("]\n");
    }
}
