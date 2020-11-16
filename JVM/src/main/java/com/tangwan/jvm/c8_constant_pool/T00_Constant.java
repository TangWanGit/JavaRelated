/*
 * File Name:T00_Constant is created on 2020-10-29 14:52 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c8_constant_pool;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

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
    public static final int i = 9;
    public static final Object o = new Object();

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(10);
        System.out.println(list.size());
        System.out.println(getCapacity(list));
        list.set(5, 1);
        list.remove(1);

        HashMap<String, String> map = new HashMap<>();
        map.put("", "");
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("", "");

    }

    /**
     * 获取list容量
     *
     * @param list
     *
     * @return
     */
    public static Integer getCapacity(ArrayList list) {
        Integer length = null;
        Class clazz = list.getClass();
        Field field;
        try {
            field = clazz.getDeclaredField("elementData");
            field.setAccessible(true);
            Object[] object = (Object[])field.get(list);
            length = object.length;
            return length;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return length;
    }
}
