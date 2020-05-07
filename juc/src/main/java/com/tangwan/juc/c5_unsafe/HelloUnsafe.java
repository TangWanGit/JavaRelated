/*
 * File Name:HelloUnsafe is created on 2020-04-21 17:15 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c5_unsafe;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;

import sun.misc.Unsafe;

/**
 * @author tangwan
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

    private static Unsafe THE_UNSAFE;

    static {
        try {
            final PrivilegedExceptionAction<Unsafe> action = () -> {
                Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
                theUnsafe.setAccessible(true);
                return (Unsafe)theUnsafe.get(null);
            };
            THE_UNSAFE = AccessController.doPrivileged(action);
        } catch (Exception e) {
            throw new RuntimeException("Unable to load unsafe", e);
        }
    }

    public static void main(String[] args) throws InstantiationException {

        //Unsafe unsafe = Unsafe.getUnsafe();

        M m = (M)THE_UNSAFE.allocateInstance(M.class);
        System.out.println(m.i);

        m.i = 9;

        System.out.println(m.i);
    }
}
