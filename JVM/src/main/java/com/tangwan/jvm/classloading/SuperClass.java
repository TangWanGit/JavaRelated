/*
 * File Name:SuperClass is created on 2020-08-03 20:55 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.classloading;

/**
 * @author Zhao Xiaoli
 * @Description : 被动使用类字段演示一
 * 通过子类引用父类的静态字段，不会导致子类初始化
 * @date 2020-08-03 20:55
 * @since JDK 1.8
 */
public class SuperClass {
    static {
        value = 340;
        System.out.println("SuperClass init.");
    }

    public static int value = 123;

    public SuperClass() {
        System.out.println("su[er");
    }
}

class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init.");
    }

    public SubClass() {
        System.out.println("ps sub");
    }

}

class ConstClass {
    static {
        System.out.println("ConstClass init.");
    }

    public static final String H = "hello world";
}

class Main {
    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }
}


