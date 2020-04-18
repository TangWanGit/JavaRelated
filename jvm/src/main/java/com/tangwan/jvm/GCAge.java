/*
 * File Name:GCAge is created on 2020-04-16 17:52 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author Zhao Xiaoli
 * @Description : GCAge
 * <p>
 * com.tangwan.jvm.Person object internals:
 * OFFSET  SIZE      TYPE DESCRIPTION                               VALUE
 * 0 0000 0         01
 * 年龄  偏向锁标记 标志位
 * hashcode
 * 0     4           (object header)                           01 93 3b e5 (00000001 10010011 00111011 11100101) (-449080575)
 * hashcode
 * 4     4           (object header)                           60 00 00 00 (01100000 00000000 00000000 00000000) (96)
 * <p>
 * 4个字节：Klass Pointer
 * 8     4           (object header)                           43 c1 00 f8 (01000011 11000001 00000000 11111000) (-134168253)
 * 1个字节：boolean flag 属性，属于实例数据，占用1字节
 * 12     1   boolean Person.flag                               false
 * 对齐字节，不保存数据
 * JVM的规范要求对象的大小必须是8的整数倍
 * 13     3           (loss due to the next object alignment)
 * Instance size: 16 bytes
 * Space losses: 0 bytes internal + 3 bytes external = 3 bytes total
 *
 * <p>
 * -XX:-UseCompressedOops
 * 不压缩的版本，Klass Pointer是8个字节
 * <p>
 * com.tangwan.jvm.Person object internals:
 * OFFSET  SIZE      TYPE DESCRIPTION                               VALUE
 * 0     4           (object header)                           01 93 3b e5 (00000001 10010011 00111011 11100101) (-449080575)
 * 4     4           (object header)                           60 00 00 00 (01100000 00000000 00000000 00000000) (96)
 * 8     4           (object header)                           d8 f6 a6 0a (11011000 11110110 10100110 00001010) (178714328)
 * 12     4           (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
 * 16     1   boolean Person.flag                               false
 * 17     7           (loss due to the next object alignment)
 * Instance size: 24 bytes
 * Space losses: 0 bytes internal + 7 bytes external = 7 bytes total
 * @date 2020-04-16 17:52
 * @since JDK 1.8
 */
public class GCAge {
    public static void main(String[] args) throws InterruptedException {
        testP();

        //testUser();

        //System.out.println("-------------------");

        //testPersen();
    }

    static void testP() {
        P user = new P();
        //不调用hashCode() 不会记录哈希码
        int hashCode = user.hashCode();
        //转16进制输出，与头信息中HashCode进行比较
        String hex = Integer.toHexString(hashCode);
        System.out.println("HashCode十六进制:" + hex);
        System.err.println(ClassLayout.parseInstance(user).toPrintable());
    }

    static void testUser() {
        User user = new User();
        //不调用hashCode() 不会记录哈希码
        int hashCode = user.hashCode();
        //转16进制输出，与头信息中HashCode进行比较
        String hex = Integer.toHexString(hashCode);
        System.out.println("HashCode十六进制:" + hex);
        System.err.println(ClassLayout.parseInstance(user).toPrintable());
    }

    static void testPersen() {
        Person p = new Person();
        //不调用hashCode() 不会记录哈希码
        int hashCode = p.hashCode();
        //转16进制输出，与头信息中HashCode进行比较
        String hex = Integer.toHexString(hashCode);
        System.out.println("HashCode十六进制:" + hex);
        print(p);

        System.gc();
        System.out.println("------------------------");

        print(p);
    }

    static void print(Person p) {
        System.err.println(ClassLayout.parseInstance(p).toPrintable());
    }
}

class Person {
    private boolean flag;
}

class User {

    //private String name;
    private Integer age;
    private boolean sex;
    private boolean flag;
}

class P {
    //              // 8 _markword
    //              // 4 _klass pointer
    Integer id;         // 4
    String name;    // 4
    Integer age;        // 4

    byte b1;        // 1
    byte b2;        // 1

    //Object o;       // 4
    byte b3;        // 1
}