/*
 * File Name:T03_ThreadState is created on 2020-04-21 15:33 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c0_basic;

/**
 * @author tangwan
 * @Description : T03_ThreadState
 * @date 2020-04-21 15:33
 * @since JDK 1.8
 */
public class T03_ThreadState {
    static class MtThread extends Thread {
        @Override
        public void run() {
            System.out.println(this.getState());

            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new MtThread();

        System.out.println(t.getState());

        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(t.getState());
    }
}
