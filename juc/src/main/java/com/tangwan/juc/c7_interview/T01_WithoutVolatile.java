/*
 * File Name:T01_WithoutVolatile is created on 2020-04-24 14:45 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c7_interview;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Zhao Xiaoli
 * @Description : T01_WithoutVolatile
 * <p>
 * 曾经的面试题：（淘宝？）
 * 实现一个容器，提供两个方法，add，size
 * 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束
 * <p>
 * 分析下面这个程序，能完成这个功能吗？
 * 不能，lists在线程间隔离，第二个线程无法获取到size准确值
 * @date 2020-04-24 14:45
 * @since JDK 1.8
 */
public class T01_WithoutVolatile {
    List lists = new ArrayList();

    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {

        System.out
            .println(ChronoUnit.MINUTES.between(Instant.ofEpochSecond(1587710892), Instant.ofEpochSecond(1587721692)));

        T01_WithoutVolatile c = new T01_WithoutVolatile();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                c.add(new Object());
                System.out.println("add " + i);

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();

        new Thread(() -> {
            while (true) {
                if (c.size() == 5) {
                    break;
                }
            }
            System.out.println("t2 结束");
        }, "t2").start();
    }
}
