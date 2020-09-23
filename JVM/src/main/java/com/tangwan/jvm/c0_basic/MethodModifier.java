/*
 * File Name:MethodModifier is created on 2020-09-21 13:50 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c0_basic;

/**
 * @author Zhao Xiaoli
 * @Description : MethodModifier
 * @date 2020-09-21 13:50
 * @since JDK 1.8
 */
public class MethodModifier {
    public void publicMethod() {
        this.privateMehtod();
        this.protectedMethod();
        p();

    }

    private void privateMehtod() {
        System.out.println("1");
    }

    protected void protectedMethod() {
    }

    private static void p() {

    }

    public void out(int i) {
        System.out.println(i + 1);
    }

    public void out(long l) {
        System.out.println(l + 1);
    }

    public static void main(String[] args) {
        {
            byte[] a = new byte[60 * 1024 * 1024]; //注意，这里有个代码块。a的作用域就在代码块中
        }
        int b = 10;
        System.gc();
    }


}
