/*
 * File Name:T04_InvokeInterface is created on 2020-04-16 15:42 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.jvm.c4_runtimeDataAreaAndInstructionSet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tangwan
 * @Description : T04_InvokeInterface
 * @date 2020-04-16 15:42
 * @since JDK 1.8
 */
public class T04_InvokeInterface {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Hello");
    }
}
