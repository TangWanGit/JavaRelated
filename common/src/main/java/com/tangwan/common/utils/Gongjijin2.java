/*
 * File Name:Gongjijin is created on 2021-01-28 15:04 by Zhao Xiaoli
 *
 * Copyright (c) 2021, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.common.utils;

import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author Zhao Xiaoli
 * @Description : Gongjijin
 * @date 2021-01-28 15:04
 * @since JDK 1.8
 */
public class Gongjijin2 {
    public static void main(String[] args) {
        long sum = 798;
        long incr = 5000;
        long cur = 133;
        for (int i = 0; i < 12; i++) {
            cur = cur + incr;
            sum = sum + cur;
        }

        System.out.println(cur);
        System.out.println(sum);
        System.out.println(sum / 12);
        System.out.println(sum / 12 * 15);

        System.out.print(newOrderId());
    }

    public static Long newOrderId() {
        String random = RandomStringUtils.randomNumeric(5);

        String value = String.format("%s%s", TimeUtils.format(new Date(), "yyyyMMddHHmmss"), random);

        return Long.valueOf(value);
    }
}
