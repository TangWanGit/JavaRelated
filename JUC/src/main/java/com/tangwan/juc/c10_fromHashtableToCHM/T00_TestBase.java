/*
 * File Name:T01_TestHashtable is created on 2020-04-28 16:22 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c10_fromHashtableToCHM;

import static com.tangwan.juc.c10_fromHashtableToCHM.Constants.COUNT;
import static com.tangwan.juc.c10_fromHashtableToCHM.Constants.THREAD_COUNT;

/**
 * @author tangwan
 * @Description : T01_TestHashtable
 * @date 2020-04-28 16:22
 * @since JDK 1.8
 */
public abstract class T00_TestBase {

    public void test() {
        long start = System.currentTimeMillis();

        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread(i * (Constants.COUNT / THREAD_COUNT));
        }

        try {
            for (Thread t : threads) {
                t.start();
                t.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("write consuming : " + (end - start));

        System.out.println("size: " + getSize());

        //-----------------------------------

        start = System.currentTimeMillis();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000000; j++) {
                    get(10);
                }
            });
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        end = System.currentTimeMillis();
        System.out.println("get consuming : " + (end - start));
    }

    protected abstract int getSize();

    protected abstract Object get(int index);

    protected abstract Object put(int index);

    class MyThread extends Thread {
        int start;
        int gap = COUNT / THREAD_COUNT;

        public MyThread(int start) {
            this.start = start;
        }

        @Override
        public void run() {
            System.out.println(start + " " + gap);
            for (int i = start; i < start + gap; i++) {
                put(i);
            }
        }
    }

}
