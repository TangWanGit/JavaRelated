/*
 * File Name:T02_Compare is created on 2020-11-10 11:14 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c8_constant_pool;

import java.util.ArrayList;

/**
 * @author Zhao Xiaoli
 * @Description : T02_Compare
 * @date 2020-11-10 11:14
 * @since JDK 1.8
 */
public class T02_Compare {

    public static void main(String[] args) {
        boolean f = true;
        if (f) {
            System.out.println("if(f)");
        }
        if (f == true) {
            System.out.println("if (f == true)");
        }

        //268435455
        for (int i = Integer.MAX_VALUE - 1; i > 0; i = i >> 1) {
            try {
                ArrayList arrayList = new ArrayList(i);
                arrayList.add(1);

                System.out.println(i);
                break;
            } catch (Throwable e) {
                System.out.println(e.getMessage() + i);
            }
        }
    }
}
