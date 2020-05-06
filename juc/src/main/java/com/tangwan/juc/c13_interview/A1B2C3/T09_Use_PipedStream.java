/*
 * File Name:T03_Use_BlockingQueue is created on 2020-05-06 18:59 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c13_interview.A1B2C3;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author Zhao Xiaoli
 * @Description : T04_Use_AtomicInteger
 * @date 2020-05-06 18:59
 * @since JDK 1.8
 */
public class T09_Use_PipedStream extends T00_Base {

    public static void main(String[] args) throws IOException {
        PipedInputStream input1 = new PipedInputStream();
        PipedInputStream input2 = new PipedInputStream();
        PipedOutputStream output1 = new PipedOutputStream();
        PipedOutputStream output2 = new PipedOutputStream();

        input1.connect(output2);
        input2.connect(output1);

        String msg = "Your Turn";
        new Thread(() -> {
            byte[] buffer = new byte[9];

            try {
                for (char c : aI) {
                    input1.read(buffer);

                    if (msg.equals(new String(buffer))) {

                        System.out.print(c);
                    }
                    output1.write(msg.getBytes());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            byte[] buffer = new byte[9];

            try {
                for (char c : aC) {
                    System.out.print(c);

                    output2.write(msg.getBytes());
                    input2.read(buffer);

                    if (msg.equals(new String(buffer))) {
                        continue;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }
}
