/*
 * File Name:T06_PlaceHolder is created on 2021-01-05 12:35 by Zhao Xiaoli
 *
 * Copyright (c) 2021, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c5_gc;

/**
 * @author Zhao Xiaoli
 * @Description : T06_PlaceHolder
 * @date 2021-01-05 12:35
 * @since JDK 1.8
 */
public class T06_PlaceHolder {
    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        int i = 0;
        System.gc();

        String js = "{\"name\": \"1\",\"age\": 9}";
        if (js == null) {

        }
    }
}
