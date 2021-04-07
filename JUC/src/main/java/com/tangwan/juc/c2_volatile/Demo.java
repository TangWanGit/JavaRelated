/*
 * File Name:Demo is created on 2021/3/16 8:23 下午 by Zhao Xiaoli
 *
 * Copyright (c) 2021, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c2_volatile;

/**
 * @author Zhao Xiaoli
 * @Description : Demo
 * @date 2021/3/16 8:23 下午
 * @since JDK 1.8
 */
public class Demo {
    static boolean flag;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println("start");
            while (!flag) {
            }
            System.out.println("end");
        }).start();
        Thread.sleep(1000);
        flag = true;
    }
}
