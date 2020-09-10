/*
 * File Name:T11_SchedulePool is created on 2020-05-07 10:09 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c14_ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author tangwan
 * @Description : T11_SchedulePool
 * @date 2020-05-07 10:09
 * @since JDK 1.8
 */
public class T11_SchedulePool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
        //// 每个周期固定
        //scheduledExecutorService.scheduleAtFixedRate(() -> {
        //    System.out
        //        .println("scheduleAtFixedRate " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
        //    try {
        //        TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    }
        //}, 0, 500, TimeUnit.MILLISECONDS);

        // 周期间隔固定，如果线程任务时间过长，那么下次的任务会顺延
        //scheduledExecutorService.scheduleWithFixedDelay(() -> {
        //    System.out.println(
        //        "scheduleWithFixedDelay1 " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
        //    try {
        //        TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    }
        //}, 0, 500, TimeUnit.MILLISECONDS);
        //
        //scheduledExecutorService.scheduleWithFixedDelay(() -> {
        //    System.out.println(
        //        "scheduleWithFixedDelay2 " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
        //    try {
        //        TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    }
        //}, 0, 500, TimeUnit.MILLISECONDS);

        scheduledExecutorService.scheduleWithFixedDelay(T11_SchedulePool::reset, 10, 60, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleWithFixedDelay(T11_SchedulePool::scheduleRequest, 10, 1, TimeUnit.SECONDS);
    }

    public static void reset() {
        System.out.println("reset");
    }

    public static final AtomicLong ac = new AtomicLong();
    public static void scheduleRequest() {
        System.out.println("scheduleRequest" + ac.incrementAndGet());
    }
}
