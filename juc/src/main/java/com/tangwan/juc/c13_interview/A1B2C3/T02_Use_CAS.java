/*
 * File Name:T01_Use_LockSupport is created on 2020-05-06 17:50 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c13_interview.A1B2C3;

/**
 * @author Zhao Xiaoli
 * @Description : T01_Use_LockSupport
 * @date 2020-05-06 17:50
 * @since JDK 1.8
 */
public class T02_Use_CAS extends T00_Base {

    enum ReadyToRun {
        T1,
        T2
    }

    static volatile ReadyToRun readyToRun = ReadyToRun.T1;

    public static void main(String[] args) {

        new Thread(() -> {
            for (char c : aI) {
                while (readyToRun != ReadyToRun.T1) {
                }
                System.out.print(c);
                readyToRun = ReadyToRun.T2;
            }
        }, "t1").start();

        new Thread(() -> {
            for (char c : aC) {
                while (readyToRun != ReadyToRun.T2) {
                }
                System.out.print(c);

                readyToRun = ReadyToRun.T1;
            }
        }, "t2").start();
    }

}
