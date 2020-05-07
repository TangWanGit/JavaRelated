/*
 * File Name:T0204_LoadClassByHand is created on 2020-04-16 09:48 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.jvm.c2_classloader;

/**
 * @author tangwan
 * @Description : T0204_LoadClassByHand
 * @date 2020-04-16 09:48
 * @since JDK 1.8
 */
public class T0204_LoadClassByHand {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = T0204_LoadClassByHand.class.getClassLoader()
            .loadClass("com.tangwan.jvm.c2_classloader.T0204_LoadClassByHand");
        System.out.println(clazz.getName());

        //利用类加载器加载资源，参考坦克图片的加载
        //T005_LoadClassByHand.class.getClassLoader().getResourceAsStream("");
    }
}
