/*
 * File Name:DateUtils is created on 2020-05-12 10:25 by tangwan
 *
 * tangwan
 *
 */
package com.tangwan.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author tangwan
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
