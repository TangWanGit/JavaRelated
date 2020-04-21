/*
 * File Name:HelloUnsafe is created on 2020-04-21 17:15 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c5_unsafe;

import sun.misc.Unsafe;

/**
 * @author Zhao Xiaoli
 * @Description : HelloUnsafe
 * @date 2020-04-21 17:15
 * @since JDK 1.8
 */
public class HelloUnsafe {
    static class M {
        private M() {
        }

        int i = 0;
    }

    public static void main(String[] args) throws InstantiationException {
        Unsafe unsafe = Unsafe.getUnsafe();
        M m = (M)unsafe.allocateInstance(M.class);
        System.out.println(m.i);

        m.i = 9;

        System.out.println(m.i);
    }
}
