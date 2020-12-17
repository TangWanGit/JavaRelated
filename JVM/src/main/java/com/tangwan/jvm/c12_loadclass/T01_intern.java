/*
 * File Name:T01_intern is created on 2020-11-17 15:55 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c12_loadclass;

/**
 * @author Zhao Xiaoli
 * @Description : T01_intern
 * @date 2020-11-17 15:55
 * @since JDK 1.8
 */
public class T01_intern {
    public static void main(String[] args) {
        String a = "java";
        StringBuilder s = new StringBuilder("java");
        replace(a);
        append(s);
        System.out.println(a + s.toString());

    }


    public static void replace(String s) {
        s = s.replace("j","c");
    }

    public static void append(StringBuilder stringBuilder) {
        stringBuilder.append("a");
        //锁方法、锁对象头、锁代码块
        // 锁方法是在方法的access——flag上加标志
        // 锁对象头
        // 锁代码块是分实例方法和静态方法，静态方法是锁定的class类型，实例方法是锁定实例
    //    锁升级过程

    }

}
