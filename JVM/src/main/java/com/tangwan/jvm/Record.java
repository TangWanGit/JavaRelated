/*
 * File Name:Record is created on 2020-08-17 17:05 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author Zhao Xiaoli
 * @Description : Record
 * @date 2020-08-17 17:05
 * @since JDK 1.8
 */
public class Record {

    private byte a;
    private int b;
    private boolean c;
    private float d;
    private Object e;

    public static void main(String[] args) {
        System.out.println(ClassLayout.parseClass(Record.class).toPrintable());
    }

}
