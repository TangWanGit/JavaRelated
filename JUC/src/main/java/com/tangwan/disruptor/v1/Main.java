/*
 * File Name:Main is created on 2020-05-08 16:52 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.disruptor.v1;

import java.nio.ByteBuffer;
import java.util.concurrent.Executors;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

/**
 * @author Zhao Xiaoli
 * @Description : Main
 * @date 2020-05-08 16:52
 * @since JDK 1.8
 */
public class Main {
    public static void main(String[] args) {
        LongEventFactory eventFactory = new LongEventFactory();
        int ringBufferSize = 128;
        Disruptor<LongEvent> disruptor =
            new Disruptor<>(eventFactory, ringBufferSize, Executors.defaultThreadFactory());

        disruptor.handleEventsWith(new LongEventHandler());

        disruptor.start();

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        LongEventProducer producer = new LongEventProducer(ringBuffer);

        ByteBuffer bb = ByteBuffer.allocate(8);

        for (long i = 0; i < 200; i++) {
            bb.putLong(0, i << 1);
            producer.onData(bb);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        disruptor.shutdown();
    }
}
