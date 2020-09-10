/*
 * File Name:T05_FullGC_Problem is created on 2020-04-16 17:02 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.jvm.c5_gc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author tangwan
 * @Description : T05_FullGC_Problem
 * 作用：启动一个ScheduledThreadPoolExecutor定时器，每100秒执行一次modelFit方法
 * modelFit作用：
 * 每次取100个CardInfo出来，然后使用定时器执行，最开始推迟2秒，之后每3秒执行一次
 * @date 2020-04-16 17:02
 * @since JDK 1.8
 */
public class T05_FullGC_Problem {
    /**
     * 线程池new出来
     */
    private static ScheduledThreadPoolExecutor executor =
        new ScheduledThreadPoolExecutor(50, new ThreadPoolExecutor.DiscardOldestPolicy());

    public static void main(String[] args) throws InterruptedException {
        executor.setMaximumPoolSize(50);
        for (; ; ) {
            modelFit();
            Thread.sleep(100);
        }
    }

    private static void modelFit() {
        List<CardInfo> taskList = getAllCardInfo();
        taskList.forEach(info -> executor.scheduleAtFixedRate(info::m, 2, 3, TimeUnit.SECONDS));
    }

    private static List<CardInfo> getAllCardInfo() {
        List<CardInfo> taskList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            CardInfo c = new CardInfo();
            taskList.add(c);
        }
        return taskList;
    }

    private static class CardInfo {
        BigDecimal price = new BigDecimal(0.0);
        String name = "xx";
        int age = 5;
        Date birthdate = new Date();

        public void m() {
        }
    }

}
