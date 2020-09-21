/*
 * File Name:Hello is created on 2020-09-20 23:22 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c0_basic;

/**
 * @author Zhao Xiaoli
 * @Description : Hello
 * @date 2020-09-20 23:22
 * @since JDK 1.8
 */
public class Hello {
    private static String name = "jetty";
    private int age = 10;

    public Hello() {
        System.out.println("Hello.age modify before + " + age);
        this.age = 11;
        System.out.println("Hello.age modify after + " + age);
    }

    public static void main(String[] args) {
        //System.out.println(Hello.name);
        //new Hello();
    }
}
