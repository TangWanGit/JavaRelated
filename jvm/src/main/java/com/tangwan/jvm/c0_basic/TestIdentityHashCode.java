/*
 * File Name:TestIdentityHashCode is created on 2020-04-15 15:45 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.jvm.c0_basic;

/**
 * identityHashCode和hashCode的区别是，identityHashCode会返回对象的hashCode，而不管对象是否重写了hashCode方法。
 *
 * @author tangwan
 * @date 2020-04-15 15:45
 * @since JDK 1.8
 */
public class TestIdentityHashCode {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(o.hashCode());
        System.out.println(System.identityHashCode(o));

        System.out.println("-------------------------");

        T t = new T();
        /* T重写了hashCode方法 */
        System.out.println(t.hashCode());
        System.out.println(t.superHashCode());
        System.out.println(System.identityHashCode(t));

        System.out.println("-------------------------");

        String s1 = new String("Hello");
        String s2 = new String("Hello");
        System.out.println(s1.hashCode() == s2.hashCode());
        System.out.println(System.identityHashCode(s1) == System.identityHashCode(s2));
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));
    }

    private static final class T {
        @Override
        public int hashCode() {
            return 1;
        }

        public int superHashCode() {
            return super.hashCode();
        }
    }
}
