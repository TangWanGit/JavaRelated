/*
 * File Name:TestClass is created on 2020-07-29 21:49 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c0_basic;

/**
 * @author Zhao Xiaoli
 * @Description : TestClass
 * @date 2020-07-29 21:49
 * @since JDK 1.8
 */
public class TestClass {
    private int m;

    public int inc() {
        int x;
        try {
            x = 1;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
    }
}
