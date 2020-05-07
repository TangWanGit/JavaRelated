/*
 * File Name:T02_SoftReference is created on 2020-04-28 15:33 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c9_RefTypeAndThreadLocal;

import java.lang.ref.SoftReference;

/**
 * @author tangwan
 * @Description : T02_SoftReference
 * <p>
 * 软引用
 * 软引用是用来描述一些还有用但并非必须的对象。
 * 对于软引用关联着的对象，在系统将要发生内存溢出异常之前，将会把这些对象列进回收范围进行第二次回收。
 * 如果这次回收还没有足够的内存，才会抛出内存溢出异常。
 * -Xmx20M
 * @date 2020-04-28 15:33
 * @since JDK 1.8
 */
public class T02_SoftReference {
    public static void main(String[] args) throws InterruptedException {
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024 * 1024 * 10]);
        // 有输出
        System.out.println(m.get());
        System.gc();

        Thread.sleep(500);

        // 有输出
        System.out.println(m.get());

        // 再分配一个数组，heap将装不下，这时候系统会垃圾回收，先回收一次，如果不够，会把软引用干掉
        byte[] b = new byte[1024 * 1024 * 10];

        System.out.println(m.get());
    }
}

//软引用非常适合缓存使用