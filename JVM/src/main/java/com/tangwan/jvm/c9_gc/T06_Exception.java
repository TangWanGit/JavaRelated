/*
 * File Name:T06_Exception is created on 2020-10-29 11:13 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c9_gc;

/**
 * @author Zhao Xiaoli
 * @Description : T06_Exception
 * @date 2020-10-29 11:13
 * @since JDK 1.8
 */
@Ano
public class T06_Exception {
    static final Integer z = 100;
    int y = 999;

    static final int low = -128;
    static final int high;
    static final Integer cache[];

    static {
        // high value may be configured by property
        int h = 127;
        String integerCacheHighPropValue = sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
        if (integerCacheHighPropValue != null) {
            try {
                int i = parseInt(integerCacheHighPropValue);
                i = Math.max(i, 127);
                // Maximum array size is Integer.MAX_VALUE
                h = Math.min(i, Integer.MAX_VALUE - (-low) - 1);
            } catch (NumberFormatException nfe) {
                // If the property cannot be parsed into an int, ignore it.
            }
        }
        high = h;

        cache = new Integer[(high - low) + 1];
        int j = low;
        for (int k = 0; k < cache.length; k++) {
            cache[k] = new Integer(j++);
        }

    }

    private static int parseInt(String integerCacheHighPropValue) {
        return 0;
    }

    public static void main(String[] args) {
        //System.out.println(inc());
    }

    public int inc() {
        int x;
        try {
            x = 1;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
    }
}
