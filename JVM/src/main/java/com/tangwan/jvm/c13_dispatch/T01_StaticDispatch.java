/*
 * File Name:T01_StaticDispatch is created on 2021-01-11 10:15 by Zhao Xiaoli
 *
 * Copyright (c) 2021, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c13_dispatch;

/**
 * @author Zhao Xiaoli
 * @Description : 方法调用之静态分派
 * @date 2021-01-11 10:15
 * @since JDK 1.8
 */
public class T01_StaticDispatch {
    static abstract class Human {
    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }

    public void sayHello(Human human) {
        System.out.println("hello,guy");
    }

    public void sayHello(Man man) {
        System.out.println("hello,man");
    }

    public void sayHello(Woman woman) {
        System.out.println("hello,woman");
    }

    public static void main(String[] args) {

        Human man = new Man();
        Human woman = new Woman();

        T01_StaticDispatch sr = new T01_StaticDispatch();

        sr.sayHello(man);
        sr.sayHello(woman);
        sr.sayHello((Woman)woman);
    }
}
