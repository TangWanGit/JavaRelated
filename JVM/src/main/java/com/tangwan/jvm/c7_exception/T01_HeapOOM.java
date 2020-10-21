/*
 * File Name:T01_HeapOOM is created on 2020-10-19 10:13 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c7_exception;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhao Xiaoli
 * @Description : 测试内存溢出
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @date 2020-10-19 10:13
 * @since JDK 1.8
 */
public class T01_HeapOOM {
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
