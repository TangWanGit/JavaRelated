/*
 * File Name:MethodHandleTest is created on 2020-11-04 17:36 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c10_demo;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @author Zhao Xiaoli
 * @Description : MethodHandleTest
 * @date 2020-11-04 17:36
 * @since JDK 1.8
 */
public class MethodHandleTest {
    static class ClassA {
        public void println(String s) {
            System.out.println("com.tangwan.jvm.c10_demo.MethodHandleTest.ClassA.println#" + s);
        }
    }

    public static void main(String[] args) throws Throwable {
        Object object = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
        getPrintlnMH(object).invokeExact("icyfenix");
    }

    private static MethodHandle getPrintlnMH(Object receiver) throws NoSuchMethodException, IllegalAccessException {
        // MethodType：代表"方法类型"，包含了方法的返回值（methodType的第一个参数）和具体参数（methodType第二个以及以后的参数）
        MethodType methodType = MethodType.methodType(void.class, String.class);
        // lookup：作用是在指定类中查找符合给定的的方法名称、方法类型，并且符合调用权限的方法句柄。
        // 因为这里调用的是一个虚方法，按照Java语言的规则，方法第一个参数是隐式的，代表该方法的接收者，
        // 也即this指向的对象，这个参数以前是放在参数列表中进行传递，现在提供了bindTo方法来完成这件事
        return MethodHandles.lookup().findVirtual(receiver.getClass(), "println", methodType).bindTo(receiver);
    }
}
