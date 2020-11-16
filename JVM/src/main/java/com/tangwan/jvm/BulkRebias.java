/*
 * File Name:BulkRebias is created on 2020-09-01 00:07 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm;

import java.util.ArrayList;
import java.util.List;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author Zhao Xiaoli
 * @Description : BulkRebias 批量锁撤销
 * @date 2020-09-01 00:07
 * @since JDK 1.8
 */
public class BulkRebias {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000L);

        List<A> listA = new ArrayList<>();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                A a = new A();
                synchronized (a) {
                    listA.add(a);
                }
            }
            try {
                //为了防止线程结束后JVM可能对对象进行的一些处理，在创建完对象后，保持线程t1状态为存活
                Thread.sleep(100000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();

        //睡眠3s，保证线程t1创建对象完成
        Thread.sleep(3000);
        System.out.println("打印t1线程，list中第20个对象的对象头：应该是101-偏向锁");
        System.out.println(ClassLayout.parseInstance(listA.get(19)).toPrintable());

        System.out.println("打印t1线程，list中第26个对象的对象头：应该是101-偏向锁");
        System.out.println(ClassLayout.parseInstance(listA.get(25)).toPrintable());

        //创建线程t2竞争线程1中已经退出同步块的锁
        Thread t2 = new Thread(() -> {
            //这里只循环了3次
            for (int i = 0; i < 30; i++) {
                A a = listA.get(i);
                synchronized (a) {
                    if (i == 18 || i == 19 || i == 25) {
                        System.out.println("t2线程：第 " + (i + 1) + " 次偏向结果");
                        System.out.println(ClassLayout.parseInstance(a).toPrintable());

                    }
                }
            }
            try {
                //为了防止线程结束后JVM可能对对象进行的一些处理，在创建完对象后，保持线程状态为存活
                Thread.sleep(100000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t2.start();

        //睡眠3s，保证线程t1创建对象完成
        Thread.sleep(3000);
        System.out.println("打印t1线程，list中第20个对象的对象头：应该是101-偏向锁");
        System.out.println(ClassLayout.parseInstance(listA.get(20)).toPrintable());

        System.out.println("打印t1线程，list中第41个对象的对象头：这里没有被t2线程触达（因为只循环40次），依然是偏向t1");
        System.out.println(ClassLayout.parseInstance(listA.get(40)).toPrintable());

        Thread t3 = new Thread(() -> {
            //这里只循环了3次
            for (int i = 20; i < 40; i++) {
                A a = listA.get(i);
                synchronized (a) {
                    if (i == 20 || i == 22) {
                        System.out.println("t3线程：第 " + (i) + " 次 这里触发了批量锁撤销");
                        System.out.println(ClassLayout.parseInstance(a).toPrintable());

                    }
                }
            }
            try {
                //为了防止线程结束后JVM可能对对象进行的一些处理，在创建完对象后，保持线程状态为存活
                Thread.sleep(100000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t3.start();

        Thread.sleep(10000);
        System.out.println("重新输出新实例A");
        System.out.println(ClassLayout.parseInstance(new A()).toPrintable());
    }

    public static class A {
    }
}
