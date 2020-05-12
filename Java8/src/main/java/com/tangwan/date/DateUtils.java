/*
 * File Name:DateUtils is created on 2020-05-12 10:25 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Zhao Xiaoli
 * @Description : DateUtils
 * @date 2020-05-12 10:25
 * @since JDK 1.8
 */
public class DateUtils {
    private static final DateTimeFormatter PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String format(LocalDateTime localDateTime) {
        return localDateTime.format(PATTERN);
    }
}
