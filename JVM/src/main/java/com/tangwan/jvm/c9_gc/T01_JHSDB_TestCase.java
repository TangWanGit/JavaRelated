/*
 * File Name:T01_JHSDB_TestCase is created on 2020-10-27 10:40 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c9_gc;

/**
 * @author Zhao Xiaoli
 * @Description : T01_JHSDB_TestCase
 * -Xmx10m -XX:+UseSerialGC -XX:-UseCompressedOops -XX:+PrintCommandLineFlags
 * @date 2020-10-27 10:40
 * @since JDK 1.8
 */
public class T01_JHSDB_TestCase {
    static class Test {
        // staticObbj随着Test的类型信息存放在方法区
        static ObjectHolder staticObbj = new ObjectHolder();
        // instatnceObj随着Test的对象实例存放在java堆
        ObjectHolder instatnceObj = new ObjectHolder();

        void foo() {
            // localObj则是存在foo()方法栈帧的局部变量表中
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done");
        }
    }

    private static class ObjectHolder {
    }

    public static void main(String[] args) {
        Test test = new T01_JHSDB_TestCase.Test();
        test.foo();
    }
}
