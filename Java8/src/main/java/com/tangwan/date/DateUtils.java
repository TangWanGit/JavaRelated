/*
 * File Name:DateUtils is created on 2020-05-12 10:25 by tangwan
 *
 * tangwan
 *
 */
package com.tangwan.date;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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

    /**
     * 获取当前时间的，四舍五入秒数，获取整点的分钟数
     * 例如：
     * <li>2020-01-01 10:59:59 ，转换成 020-01-01 11:00:00</li>
     * <li>2020-01-01 10:59:10 ，转换成 020-01-01 10:59:00</li>
     *
     * @return
     */
    public static long getRoundedMinuteFromNow() {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC);
        int second = localDateTime.getSecond();
        if (second >= 30) {
            localDateTime = localDateTime.plus(60 - second, ChronoUnit.SECONDS);
        } else {
            localDateTime = localDateTime.minus(second, ChronoUnit.SECONDS);
        }

        return localDateTime.toInstant(ZoneOffset.UTC).getEpochSecond();
    }

    public static String left(Long gmt) {
        Duration of = Duration.ofSeconds(Instant.now().getEpochSecond() - gmt);
        long days = of.toDays();
        of = of.minus(days, ChronoUnit.DAYS);
        long hours = of.toHours();
        of = of.minus(hours, ChronoUnit.HOURS);
        long minutes = of.toMinutes();
        of = of.minus(minutes, ChronoUnit.MINUTES);

        return String.format("%s天%s时%s分%s秒", days, hours, minutes, of.getSeconds());
    }

    public static void main(String[] args) {

        System.out.println(left(1602432898L));
    }
}
