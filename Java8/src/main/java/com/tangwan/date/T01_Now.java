/*
 * File Name:T01_Now is created on 2020-05-12 10:24 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author Zhao Xiaoli
 * @Description : T01_Now
 * @date 2020-05-12 10:24
 * @since JDK 1.8
 */
public class T01_Now {
    private static final DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
        // 当前时间，加1秒为了后面的while循环能拿到当前的天
        LocalDateTime now = LocalDateTime.now().plus(1, ChronoUnit.SECONDS);
        // duration天以前
        LocalDateTime daysBefore = LocalDateTime.now().minus(5, ChronoUnit.DAYS);

        while (daysBefore.isBefore(now)) {
            String format = daysBefore.format(pattern);
            daysBefore = daysBefore.plus(1, ChronoUnit.DAYS);
            System.out.println(format);
        }

    }
}
