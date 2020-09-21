/*
 * File Name:Father is created on 2020-09-19 17:36 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c0_basic;

/**
 * @author Zhao Xiaoli
 * @Description : Father
 * @date 2020-09-19 17:36
 * @since JDK 1.8
 */
public class Father {

    static {
        System.out.println("Father静态代码块");
    }

    {
        System.out.println("Father普通代码块");
    }

    public Father() {
        System.out.println("Father构造方法");
    }

    public static void main(String[] args) {
        new Son();
    }
}

class Son extends Father {
    static {
        System.out.println("Son静态代码块");
    }

    {
        System.out.println("Son普通代码块");
    }

    public Son() {
        System.out.println("Son构造方法");
    }

}
