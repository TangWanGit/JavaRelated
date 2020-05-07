/*
 * File Name:T0302_Disorder is created on 2020-04-16 14:37 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.jvm.c3_jmm;

/**
 * @author tangwan
 * @Description : T0302_Disorder
 * @date 2020-04-16 14:37
 * @since JDK 1.8
 */
public class T0302_Disorder {
    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        // 第89563次 (0,0)
        // 第1768133次 (0,0)

        int i = 0;
        for (; ; ) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;

            Thread one = new Thread(() -> {
                //由于线程one先启动，下面这句话让它等一等线程two. 读着可根据自己电脑的实际性能适当调整等待时间.
                shortWait(1000000);
                a = 1;
                x = b;
            });

            Thread other = new Thread(() -> {
                b = 1;
                y = a;
            });

            one.start();
            other.start();

            one.join();
            other.join();

            String result = "第" + i + "次 (" + x + "," + y + ") ";
            if (x == 0 && y == 0) {
                System.err.println(result);
                break;
            } else {
                //System.out.println(result);
            }
        }
    }

    private static void shortWait(long interval) {
        long start = System.nanoTime();
        long end;
        do {
            end = System.nanoTime();
        } while (start + interval >= end);
    }
}
