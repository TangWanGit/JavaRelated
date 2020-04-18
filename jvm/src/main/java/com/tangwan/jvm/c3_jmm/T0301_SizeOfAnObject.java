/*
 * File Name:T0301_SizeOfAnObject is created on 2020-04-16 11:22 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c3_jmm;

import com.tangwan.object.size.ObjectSizeAgent;

/**
 * @author Zhao Xiaoli
 * @Description : T0301_SizeOfAnObject
 * 启动参数：
 * -javaagent:ObjectSize/target/object-size-1.0.0-jar-with-dependencies.jar
 * @date 2020-04-16 11:22
 * @since JDK 1.8
 */
public class T0301_SizeOfAnObject {
    public static void main(String[] args) {
        /** 输出结果：
         * 16
         * 16
         * 32
         * */
        System.out.println(ObjectSizeAgent.sizeOf(new Object()));
        System.out.println(ObjectSizeAgent.sizeOf(new int[] {}));
        System.out.println(ObjectSizeAgent.sizeOf(new P()));
    }

    // 一个Object占多少个字节
    // -XX:+UseCompressedClassPointers -XX:+UseCompressedOops
    // Oops = ordinary object pointers
    private static class P {
        //              // 8 _markword
        //              // 4 _klass pointer
        int id;         // 4
        String name;    // 4
        int age;        // 4

        byte b1;        // 1
        byte b2;        // 1

        //Object o;       // 4
        byte b3;        // 1
    }
}
