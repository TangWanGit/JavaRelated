/*
 * File Name:T02_CMS_Eden is created on 2020-04-16 16:34 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.jvm.c5_gc;

import java.util.concurrent.TimeUnit;

/**
 * @author tangwan
 * @Description : T02_CMS_Eden
 * <p>
 * -Xmn10m
 * @date 2020-04-16 16:34
 * @since JDK 1.8
 */
public class T04_CMS_YGC {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10_0000; i++) {
            Object o = new Object();
            o = null;

            TimeUnit.MICROSECONDS.sleep(100);
        }
    }
}
