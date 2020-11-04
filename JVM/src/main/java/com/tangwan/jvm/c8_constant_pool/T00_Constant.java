/*
 * File Name:T00_Constant is created on 2020-10-29 14:52 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c8_constant_pool;

/**
 * @author Zhao Xiaoli
 * @Description : T00_Constant
 * 1. 被final修饰，已在编译期把结果放入常量池的静态字段除外：仅包括基本变量的设置
 * 如：public static final int C = 897;
 * public static final String C = "897";
 * <p>
 * 2. 被final修饰，只能在<clint>阶段生成，就会触发类的加载初始化
 * @date 2020-10-29 14:52
 * @since JDK 1.8
 */
public class T00_Constant {

    public static final String C = "kkk";

    static {
        System.out.println("cinit T00_Constant");
    }
}
