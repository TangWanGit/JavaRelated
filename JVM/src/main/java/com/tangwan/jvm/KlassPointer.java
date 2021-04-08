/*
 * File Name:KlassPointer is created on 2021/4/6 11:08 下午 by Zhao Xiaoli
 *
 * Copyright (c) 2021, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm;

import java.util.ArrayList;
import java.util.List;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * @author Zhao Xiaoli
 * @Description : KlassPointer
 * @date 2021/4/6 11:08 下午
 * @since JDK 1.8
 */
public class KlassPointer {
    public static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        testHashcode();
    }

    public static void testAddrChange() {
        Object o = new Object();
        Object o1 = new Object();

        addr(o);
        addr(o1);

        List<byte[]> list = new ArrayList<byte[]>();
        for (int i = 0; i < 10; i++) {
            list.add(new byte[_1MB]);
        }

        System.gc();

        addr(o);
        addr(o1);
    }

    public static void testHashcode() {
        // 创建对象并打印JVM中对象的信息
        Person person = new Person(1);
        System.out.println(ClassLayout.parseInstance(person).toPrintable());
        // 调用hashCode方法，如果重写了hashCode方法则调用System#identityHashCode方法
        System.out.println(person.hashCode());
        // System.out.println(System.identityHashCode(person));
        // 再次打印对象JVM中的信息
        System.out.println(ClassLayout.parseInstance(person).toPrintable());

        System.out.println(System.identityHashCode(person));

        // 再次打印对象JVM中的信息
        System.out.println(ClassLayout.parseInstance(person).toPrintable());
    }

    public static void addr(Object o) {
        System.out.println("The memory address is " + VM.current().addressOf(o) + " , toString: " + o.toString());
    }

    private static class Person {
        int i;

        public Person(int i) {
            this.i = i;
        }

        @Override
        public int hashCode() {
            return i;
        }
    }
}
