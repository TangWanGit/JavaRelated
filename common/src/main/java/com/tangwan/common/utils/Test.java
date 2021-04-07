/*
 * File Name:Test is created on 2021/3/5 4:51 下午 by Zhao Xiaoli
 *
 * Copyright (c) 2021, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.common.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

/**
 * @author Zhao Xiaoli
 * @Description : Test
 * @date 2021/3/5 4:51 下午
 * @since JDK 1.8
 */
public class Test {
    public static void main(String[] args) {
        Instant now = Instant.now().minus(1, ChronoUnit.HOURS);
        long createEnd = now.getEpochSecond();

        LocalDateTime minus = LocalDateTime.now().minus(1, ChronoUnit.YEARS);
        long createBegin = minus.toInstant(ZoneOffset.of("+8")).getEpochSecond();

        //System.out.println(createBegin);
        //System.out.println(createEnd);

        testNum();
    }

    public static void testNum() {
        System.out.println(getNumeric(0, 2));
        System.out.println(getNumeric(9, 2));
        System.out.println(getNumeric(19, 2));
        System.out.println(getNumeric(199, 2));
        System.out.println(getNumeric(0, 3));
        System.out.println(getNumeric(9, 3));
        System.out.println(getNumeric(19, 3));
        System.out.println(getNumeric(199, 3));
        System.out.println(getNumeric(1990, 3));
        System.out.println(getNumeric(1990, 2));

        System.out.println(getNumeric(0, 4));
        System.out.println(getNumeric(9, 4));
        System.out.println(getNumeric(19, 4));
        System.out.println(getNumeric(199, 4));
        System.out.println(getNumeric(1990, 4));
        System.out.println(getNumeric(19980, 4));
    }

    private static String getNumeric(Integer number, Integer digits) {
        String res = String.format("%0%d", digits, number);
        return res.substring(res.length() - digits);
        //StringBuilder s = new StringBuilder(number.toString());
        //int abs = Math.abs(digits - s.length());
        //if (s.length() < digits) {
        //    for (int i = 0; i < abs; i++) {
        //        s.insert(0, "0");
        //    }
        //} else if (s.length() > digits) {
        //    s = new StringBuilder(s.substring(abs, s.length()));
        //}
        //return s.toString();
    }

}
