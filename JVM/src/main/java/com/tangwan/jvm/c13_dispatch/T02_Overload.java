/*
 * File Name:T02_Overload is created on 2021-01-11 10:30 by Zhao Xiaoli
 *
 * Copyright (c) 2021, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c13_dispatch;

import java.io.Serializable;

/**
 * @author Zhao Xiaoli
 * @Description : T02_Overload
 * @date 2021-01-11 10:30
 * @since JDK 1.8
 */
public class T02_Overload {
    //
    //public static void sayHello(char arg) {
    //    System.out.println("Hello char");
    //}
    //
    //public static void sayHello(int arg) {
    //    System.out.println("Hello int");
    //}
    //
    //public static void sayHello(long arg) {
    //    System.out.println("Hello long");
    //}
    //
    //public static void sayHello(Character arg) {
    //    System.out.println("Hello Character");
    //}
    //
    //public static void sayHello(Serializable arg) {
    //    System.out.println("Hello Serializable");
    //}
    //
    //public static void sayHello(Object arg) {
    //    System.out.println("Hello Object");
    //}

    //public static void sayHello(char... arg) {
    //    System.out.println("Hello char...");
    //}

    public static void sayHello(int... arg) {
        System.out.println("Hello int...");
    }


    public static void main(String[] args) {
        sayHello('a');
    }

}
