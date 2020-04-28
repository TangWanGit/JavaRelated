/*
 * File Name:T03_WeakReference is created on 2020-04-28 15:38 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c9_RefTypeAndThreadLocal;

import java.lang.ref.WeakReference;

/**
 * @author Zhao Xiaoli
 * @Description : T03_WeakReference
 * <p>
 * 弱引用遭到gc就会回收
 * @date 2020-04-28 15:38
 * @since JDK 1.8
 */
public class T03_WeakReference {
    public static void main(String[] args) {
        WeakReference<M> m = new WeakReference<>(new M());
        // 对象地址
        System.out.println(m.get());
        // 被回收
        System.gc();
        // null
        System.out.println(m.get());

        ThreadLocal<M> tl = new ThreadLocal<>();
        tl.set(new M());
        tl.remove();
    }
}
