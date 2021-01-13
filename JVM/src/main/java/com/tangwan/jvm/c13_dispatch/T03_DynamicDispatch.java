/*
 * File Name:T03_DynamicDispatch is created on 2021-01-11 12:43 by Zhao Xiaoli
 *
 * Copyright (c) 2021, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c13_dispatch;

/**
 * @author Zhao Xiaoli
 * @Description : T03_DynamicDispatch
 * @date 2021-01-11 12:43
 * @since JDK 1.8
 */
public class T03_DynamicDispatch {
    static abstract class Human {
        protected abstract void sayHello();
    }

    static class Man extends Human {

        @Override
        protected void sayHello() {
            System.out.println("man say hello");
        }
    }

    static class Woman extends Human{

        @Override
        protected void sayHello() {
            System.out.println("woman say hello");
        }
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();

        man.sayHello();
        woman.sayHello();

        man = new Woman();
        man.sayHello();
    }
}
