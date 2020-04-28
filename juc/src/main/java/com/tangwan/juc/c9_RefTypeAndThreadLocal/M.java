/*
 * File Name:M is created on 2020-04-28 15:29 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c9_RefTypeAndThreadLocal;

/**
 * @author Zhao Xiaoli
 * @Description : M
 * @date 2020-04-28 15:29
 * @since JDK 1.8
 */
public class M {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }
}
