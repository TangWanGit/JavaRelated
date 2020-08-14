/*
 * File Name:T0304_Volatile is created on 2020-08-13 21:48 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c3_jmm;

/**
 * @author Zhao Xiaoli
 * @Description : T0304_Volatile
 * @date 2020-08-13 21:48
 * @since JDK 1.8
 */
public class T0305_Synchronized {

    synchronized void m() {
    }

    void n() {
        synchronized (this) {
        }
    }

}
