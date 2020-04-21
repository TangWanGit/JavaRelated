/*
 * File Name:T04_VolatileNotSync is created on 2020-04-21 16:44 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c2_volatile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhao Xiaoli
 * @Description : T04_VolatileNotSync
 * <p>
 * @date 2020-04-21 16:44
 * @since JDK 1.8
 */
public class T05_VolatileVsSync {

    /**
     * 加了volatile的程序，执行时间更快
     */
    /*volatile*/ int count = 0;

    synchronized void m() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        T05_VolatileVsSync t = new T05_VolatileVsSync();
        long start = System.currentTimeMillis();
        List<Thread> threads = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m, "thread-" + i));
        }

        threads.forEach(Thread::start);
        threads.forEach(s -> {
            try {
                s.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.count + "  " + (System.currentTimeMillis() - start));
    }

}
