/*
 * File Name:T05_JavaMethodAreaOOM is created on 2020-10-20 11:35 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c7_exception;

/**
 * @author Zhao Xiaoli
 * @Description : T05_JavaMethodAreaOOM
 * -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 * @date 2020-10-20 11:35
 * @since JDK 1.8
 */
public class T05_JavaMethodAreaOOM {
    public static int i = 100;
    public static void main(String[] args) {
        //try {
        //    while (true) {
        //        Enhancer enhancer = new Enhancer();
        //        enhancer.setSuperclass(OOMObject.class);
        //        enhancer.setUseCache(false);
        //        enhancer.setCallback(
        //            (MethodInterceptor)(o, method, objects, methodProxy) -> methodProxy.invokeSuper(objects, args));
        //        enhancer.create();
        //    }
        //} catch (Throwable e) {
        //    e.printStackTrace();
        //}
        //Integer cacheBefore = IntegerCache.cache[0];
        //List<Integer> list = new ArrayList<>();
        //Integer i = new Integer(0);
        ////while (true) {
        //IntegerCache.cache[0] = new Integer(0);
        ////list.add(IntegerCache.cache[0]);
        ////}
        //
        ////Integer cacheAfter = IntegerCache.cache[0];
        ////System.out.println(cacheBefore == cacheAfter);
        String str2 = new String("ABC") + "ABC";
        System.out.println(str2);

        String s1 = new String("he") + new String("llo");    //第一句
        String s2 = new String("h") + new String("ello");    //第二句
        String s3 = s1.intern();                           //第三句
        String s4 = s2.intern();                           //第四句
        System.out.println(s1 == s3);                        //第五句
        System.out.println(s1 == s4);
        System.out.println(s2 == s4);
        System.out.println(s2 == s3);

        String w = "程序";
        String wechat3 = new String(w + "新视界");
        wechat3 = wechat3.intern();
        System.out.println();
        //System.out.println(T05_JavaMethodAreaOOM.i);
        //T05_JavaMethodAreaOOM.i = 120;
        //System.out.println(T05_JavaMethodAreaOOM.i);
    }

    static class OOMObject {
    }

    private static class IntegerCache {
        static final int low = -128;
        static final int high;
        static final Integer cache[];

        static {
            // high value may be configured by property
            int h = 127;
            String integerCacheHighPropValue = sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
            if (integerCacheHighPropValue != null) {
                try {
                    int i = 127;
                    // Maximum array size is Integer.MAX_VALUE
                    h = Math.min(i, Integer.MAX_VALUE - (-low) - 1);
                } catch (NumberFormatException nfe) {
                    // If the property cannot be parsed into an int, ignore it.
                }
            }
            high = h;

            cache = new Integer[(high - low) + 1];
            int j = low;
            for (int k = 0; k < cache.length; k++)
                cache[k] = new Integer(j++);

            // range [-128, 127] must be interned (JLS7 5.1.7)
            assert IntegerCache.high >= 127;
        }

        private IntegerCache() {
        }
    }
}
