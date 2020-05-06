/*
 * File Name:T10_Use_Exchanger_Not_Work is created on 2020-05-06 19:26 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c13_interview.A1B2C3;

import java.util.concurrent.Exchanger;

/**
 * @author Zhao Xiaoli
 * @Description : T10_Use_Exchanger_Not_Work
 * @date 2020-05-06 19:26
 * @since JDK 1.8
 */
public class T10_Use_Exchanger_Not_Work extends T00_Base {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        new Thread(() -> {
            try {
                for (char c : aI) {
                    System.out.print(exchanger.exchange(c + ""));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                for (char c : aC) {
                    System.out.print(exchanger.exchange(c + ""));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }
}
