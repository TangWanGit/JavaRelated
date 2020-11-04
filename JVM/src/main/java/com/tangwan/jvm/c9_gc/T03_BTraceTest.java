/*
 * File Name:T03_BTraceTest is created on 2020-10-27 14:57 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c9_gc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Zhao Xiaoli
 * @Description : T03_BTraceTest
 * @date 2020-10-27 14:57
 * @since JDK 1.8
 */
public class T03_BTraceTest {

    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws IOException {
        T03_BTraceTest test = new T03_BTraceTest();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            br.readLine();
            int a = (int)Math.round(Math.random() * 1000);
            int b = (int)Math.round(Math.random() * 1000);
            System.out.println(test.add(a, b));
        }
    }
}
