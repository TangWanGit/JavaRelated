/*
 * File Name:Foo is created on 2020-10-09 11:36 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c0_basic;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Zhao Xiaoli
 * @Description : Foo
 * @date 2020-10-09 11:36
 * @since JDK 1.8
 */
public class Foo implements AutoCloseable {
    private final String name;

    public Foo(String name) {
        this.name = name;
    }

    @Override
    public void close() {
        throw new RuntimeException(name);
    }

    public static void main(String[] args)
        throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method method = Foo.class.getMethod("target", int.class);
        method.invoke(null, 3);

        MethodHandles.Lookup l = Foo.lookup();
        Method m = Foo.class.getDeclaredMethod("target", int.class);
        MethodHandle mh0 = l.unreflect(m);
        MethodType t = MethodType.methodType(void.class, int.class);
        MethodHandle mh1 = l.findStatic(Foo.class, "target", t);
        
    }

    public static void target(int i) {
        new Exception("#" + i).printStackTrace();
    }

    public static MethodHandles.Lookup lookup() {
        return MethodHandles.lookup();
    }

}
