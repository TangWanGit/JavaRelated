/*
 * File Name:T02_VolatileReference is created on 2020-04-21 16:02 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c2_volatile;

/**
 * @author Zhao Xiaoli
 * @Description : T02_VolatileReference
 * @date 2020-04-21 16:02
 * @since JDK 1.8
 */
public class T03_VolatileReference2 {
    private static class Data {
        int a, b;

        public Data(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    /**
     * volatile 引用类型（包括数组）只能保证引用本身的可见性，不能保证内部字段的可见性
     */
    volatile static Data data;

    public static void main(String[] args) throws InterruptedException {
        Thread writer = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                data = new Data(i, i);
            }
        });

        Thread reader = new Thread(() -> {
            while (data == null) {
            }

            int x = data.a;
            int y = data.b;
            if (x != y) {
                System.out.printf("a = %s, b = %s%n", x, y);
            }
        });

        reader.start();
        writer.start();

        reader.join();
        writer.join();

        System.out.println("end");
    }
}
