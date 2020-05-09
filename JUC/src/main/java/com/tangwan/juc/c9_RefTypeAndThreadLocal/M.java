/*
 * File Name:M is created on 2020-04-28 15:29 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c9_RefTypeAndThreadLocal;

/**
 * @author tangwan
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
