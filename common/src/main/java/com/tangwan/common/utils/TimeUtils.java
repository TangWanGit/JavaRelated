package com.tangwan.common.utils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TimeUtils {
    public static ConcurrentMap<String, SimpleDateFormat> cache = new ConcurrentHashMap();

    public TimeUtils() {
    }

    public static String format(Date time, String pattern) {
        SimpleDateFormat format = getFormat(pattern);
        return format.format(time);
    }

    public static SimpleDateFormat getFormat(String pattern) {
        SimpleDateFormat format = (SimpleDateFormat)cache.get(pattern);
        if (format == null) {
            format = new SimpleDateFormat(pattern);
            cache.putIfAbsent(pattern, format);
        }

        return format;
    }

    static {
        cache.put("yyyyMMddHHmmssSSS", new SimpleDateFormat("yyyyMMddHHmmssSSS"));
        cache.put("yyyyMMddHHmmss", new SimpleDateFormat("yyyyMMddHHmmss"));
    }

    public static void main(String[] args) {
        System.out.println(ChronoUnit.HOURS.between(Instant.ofEpochSecond(0), Instant.now()));
    }
}
