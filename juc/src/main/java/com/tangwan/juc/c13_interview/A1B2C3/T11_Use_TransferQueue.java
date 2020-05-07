/*
 * File Name:T11_Use_TransferQueue is created on 2020-05-06 19:30 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c13_interview.A1B2C3;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * @author tangwan
 * @Description : T11_Use_TransferQueue
 * @date 2020-05-06 19:30
 * @since JDK 1.8
 */
public class T11_Use_TransferQueue extends T00_Base {

    public static void main(String[] args) {
        TransferQueue<String> queue = new LinkedTransferQueue<>();

        new Thread(() -> {
            try {
                for (char c : aI) {
                    queue.transfer(String.valueOf(c));
                    System.out.print(queue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                for (char c : aC) {
                    System.out.print(queue.take());
                    queue.transfer(String.valueOf(c));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }
}
