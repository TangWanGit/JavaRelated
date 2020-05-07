/*
 * File Name:T09_Container_WithNotify is created on 2020-04-28 14:19 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c7_interview;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * @author tangwan
 * @Description : T09_Container_WithNotify
 * <p>
 * 面试题：写一个固定容量同步容器，拥有put和get方法，以及getCount方法，
 * 能够支持2个生产者线程以及10个消费者线程的阻塞调用
 * <p>
 * 使用wait和notify/notifyAll来实现
 * @date 2020-04-28 14:19
 * @since JDK 1.8
 */
public class T09_Container_WithNotify<T> {

    private LinkedList<T> elementData = new LinkedList<>();
    private Integer MAX_CAPACITY = 10;

    public synchronized void put(T t) {
        while (elementData.size() == MAX_CAPACITY) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        elementData.add(t);
        // 通知消费者线程进行消费
        this.notifyAll();
    }

    public synchronized T get() {
        while (elementData.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        T t = elementData.removeFirst();
        this.notifyAll();
        return t;
    }

    public static void main(String[] args) {
        T09_Container_WithNotify<String> container = new T09_Container_WithNotify<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println(container.get());
                }
            }, "c" + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 25; j++) {
                    container.put(Thread.currentThread().getName() + " " + j);
                }
            }, "p" + i).start();
        }
    }
}
