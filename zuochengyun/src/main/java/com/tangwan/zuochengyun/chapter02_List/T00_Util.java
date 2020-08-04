/*
 * File Name:T00_Util is created on 2020-08-04 13:21 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.zuochengyun.chapter02_List;

/**
 * @author Zhao Xiaoli
 * @Description : T00_Util
 * @date 2020-08-04 13:21
 * @since JDK 1.8
 */
public class T00_Util {
    public static void print(Node node) {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void print(DoubleNode node) {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
}
