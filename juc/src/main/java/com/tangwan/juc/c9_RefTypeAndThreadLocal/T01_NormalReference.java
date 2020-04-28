/*
 * File Name:T01_NormalReference is created on 2020-04-28 15:30 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c9_RefTypeAndThreadLocal;

import java.io.IOException;

/**
 * @author Zhao Xiaoli
 * @Description : T01_NormalReference
 * <p>
 * 强引用
 * @date 2020-04-28 15:30
 * @since JDK 1.8
 */
public class T01_NormalReference {
    public static void main(String[] args) throws IOException {
        M m = new M();
        m = null;
        // 强引用的时候，当m指向空的时候，gc以后，原先的对象就会被清理
        System.gc();
    }
}
