/*
 * File Name:MethodHandleTest2 is created on 2020-11-06 11:19 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c10_demo;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * @author Zhao Xiaoli
 * @Description : MethodHandleTest2
 * @date 2020-11-06 11:19
 * @since JDK 1.8
 */
public class GrandFatherTestCase_1 {

    class GrandFather {
        void thinking() {
            System.out.println("i am grandfather");
        }
    }

    class Father extends GrandFather {
        @Override
        void thinking() {
            System.out.println("i am father");
        }
    }

    class Son extends Father {
        @Override
        void thinking() {
            try {
                MethodType mt = MethodType.methodType(void.class);
                MethodHandle mh = lookup().findSpecial(GrandFather.class, "thinking", mt, getClass());
                mh.invoke(this);
            } catch (Throwable e) {
            }
        }
    }

    public static void main(String[] args) {
        // 在JDK7 Update9之前的Hotspot虚拟机运行，会得到：i am grandfather
        // 但是这根逻辑在JDK7 Update9之后被视作一个潜在的安全性缺陷修正了，
        // 原因是必须保证findSpecial查找方法版本时受到的访问约束（譬如对访问控制的限制、对参数类型的限制）应与使用invokespecial指令一样，两者必须保持精确对等，
        // 包括在上面的场景中它只能访问到其直接付了中的方法版本、

        // 输出i am father，在jdk7 Update10 之后
        (new GrandFatherTestCase_1().new Son()).thinking();
    }
}
