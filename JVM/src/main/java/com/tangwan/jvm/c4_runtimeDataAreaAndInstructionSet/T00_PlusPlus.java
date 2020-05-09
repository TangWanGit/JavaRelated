/*
 * File Name:T00_PlusPlus is created on 2020-04-16 15:30 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.jvm.c4_runtimeDataAreaAndInstructionSet;

/**
 * @author tangwan
 * @Description : T00_PlusPlus
 * @date 2020-04-16 15:30
 * @since JDK 1.8
 */
public class T00_PlusPlus {
    public static void main(String[] args) {
        int i = 8;
        i = i++;
        int j = 8;
        j = ++j;

        System.out.println(i);
        System.out.println(j);
    }
}
