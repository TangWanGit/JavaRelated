/*
 * File Name:T04_StringTableOOM is created on 2020-10-28 17:27 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c9_gc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhao Xiaoli
 * @Description : T04_StringTableOOM
 * @date 2020-10-28 17:27
 * @since JDK 1.8
 */
public class T04_StringTableOOM {
    static String base = "string";

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(2994380);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String str = T04_StringTableOOM.base;
            base = str;
            try {
                String intern = str.intern();
                list.add(intern);
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
                System.out.println(i);
                break;
            }
        }
    }
}
