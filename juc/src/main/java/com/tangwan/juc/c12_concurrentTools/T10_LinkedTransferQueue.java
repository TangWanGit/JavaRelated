/*
 * File Name:T10_LinkedTransferQueue is created on 2020-05-06 17:14 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c12_concurrentTools;

import java.util.concurrent.LinkedTransferQueue;

/**
 * @author tangwan
 * @Description : T10_LinkedTransferQueue
 * @date 2020-05-06 17:14
 * @since JDK 1.8
 */
public class T10_LinkedTransferQueue {
    public static void main(String[] args) {
        LinkedTransferQueue<String> transferQueue = new LinkedTransferQueue();

        new Thread(() -> {
            try {
                System.out.println(transferQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        transferQueue.put("aaa");
    }
}
