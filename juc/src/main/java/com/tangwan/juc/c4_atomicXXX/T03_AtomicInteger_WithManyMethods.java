/*
 * File Name:T01_AtomicInteger is created on 2020-04-21 17:03 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c4_atomicXXX;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tangwan
 * @Description : 写一个程序证明AtomXXX类的多个方法并不构成原子性
 * @date 2020-04-21 17:03
 * @since JDK 1.8
 */
public class T03_AtomicInteger_WithManyMethods {
    AtomicInteger count = new AtomicInteger();

    void m() {
        for (int i = 0; i < 10000; i++) {
            int get = count.get();
            count.set(++get);
        }
    }

    public static void main(String[] args) {
        T03_AtomicInteger_WithManyMethods t = new T03_AtomicInteger_WithManyMethods();

        List<Thread> threads = new ArrayList<Thread>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m, "thread-" + i));
        }

        threads.forEach(Thread::start);

        threads.forEach((o) -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.count);
    }
}
