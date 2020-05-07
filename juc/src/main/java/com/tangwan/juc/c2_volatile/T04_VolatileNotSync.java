/*
 * File Name:T04_VolatileNotSync is created on 2020-04-21 16:44 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c2_volatile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tangwan
 * @Description : T04_VolatileNotSync
 * <p>
 * volatile只保证线程间可见性，不保证同步
 * @date 2020-04-21 16:44
 * @since JDK 1.8
 */
public class T04_VolatileNotSync {

    volatile int count = 0;

    void m() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        T04_VolatileNotSync t = new T04_VolatileNotSync();

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

        System.out.println(t.count);
    }
}
