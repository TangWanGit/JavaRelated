/*
 * File Name:MethodHandleTest2 is created on 2020-11-06 11:19 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c10_demo;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

/**
 * @author Zhao Xiaoli
 * @Description : MethodHandleTest2
 * @date 2020-11-06 11:19
 * @since JDK 1.8
 */
public class GrandFatherTestCase_2 {

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
                Field lookupImpl = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
                lookupImpl.setAccessible(true);

                MethodHandle mh = ((MethodHandles.Lookup)lookupImpl.get(null))
                    .findSpecial(GrandFather.class, "thinking", mt, GrandFather.class);
                mh.invoke(this);
            } catch (Throwable e) {
            }
        }
    }

    public static void main(String[] args) {
        // 输出i am grandfather，在jdk7之后
        //  Field lookupImpl = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
        //  lookupImpl.setAccessible(true);
        //  绕过约束
        (new GrandFatherTestCase_2().new Son()).thinking();
    }
}
