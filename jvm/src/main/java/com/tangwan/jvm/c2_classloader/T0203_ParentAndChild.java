/*
 * File Name:T0203_ParentAndChild is created on 2020-04-15 19:29 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c2_classloader;

/**
 * @author Zhao Xiaoli
 * @Description : T0203_ParentAndChild
 * @date 2020-04-15 19:29
 * @since JDK 1.8
 */
public class T0203_ParentAndChild {
    public static void main(String[] args) {
        System.out.println(T0203_ParentAndChild.class.getClassLoader());
        System.out.println(T0203_ParentAndChild.class.getClassLoader().getClass().getClassLoader());
        System.out.println(T0203_ParentAndChild.class.getClassLoader().getParent());
        System.out.println(T0203_ParentAndChild.class.getClassLoader().getParent().getParent());
    }

}
