/*
 * File Name:T05_ThreadLocal is created on 2020-04-28 16:12 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c9_RefTypeAndThreadLocal;

import java.util.concurrent.TimeUnit;

/**
 * @author tangwan
 * @Description : T05_ThreadLocal
 * <p>
 * ThreadLocal线程局部变量
 * <p>
 * ThreadLocal是使用空间换时间，synchronized是使用时间换空间
 * 比如在hibernate中session就存在与ThreadLocal中，避免synchronized的使用
 * <p>
 * 运行下面的程序，理解ThreadLocal
 * @date 2020-04-28 16:12
 * @since JDK 1.8
 */
public class T05_ThreadLocal {
    static ThreadLocal<Person> tl = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 线程局部变量，故tl拿不到t2的值
            System.out.println(tl.get());
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tl.set(new Person());
        }).start();
    }

    static class Person{
        String name = "zhagnsan";
    }
}

