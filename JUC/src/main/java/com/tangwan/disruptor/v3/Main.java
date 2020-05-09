/*
 * File Name:Main is created on 2020-05-08 16:52 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.disruptor.v3;

import java.nio.ByteBuffer;
import java.util.concurrent.Executors;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.tangwan.disruptor.v2.LongEvent;

/**
 * @author Zhao Xiaoli
 * @Description : Main
 * @date 2020-05-08 16:52
 * @since JDK 1.8
 */
public class Main {
    private static final EventTranslatorOneArg<LongEvent, ByteBuffer> TRANSLATOR =
        (event, sequence, arg0) -> event.setValue(arg0.getLong(0));

    public static void main(String[] args) {
        int ringBufferSize = 128;

        // Construct the Disruptor
        Disruptor<LongEvent> disruptor =
            new Disruptor<>(LongEvent::new, ringBufferSize, Executors.defaultThreadFactory());

        // Connect the handler
        disruptor.handleEventsWith((EventHandler<LongEvent>)(event, sequence, endOfBatch) -> System.out
            .println(event.getValue() + " " + sequence + " " + endOfBatch));

        // Start the Disruptor, starts all threads running
        disruptor.start();

        // Get the ring buffer from the Disruptor to be used for publishing.
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        ByteBuffer bb = ByteBuffer.allocate(8);

        for (long i = 0; i < 200; i++) {
            bb.putLong(0, i << 1);
            ringBuffer.publishEvent(TRANSLATOR, bb);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        disruptor.shutdown();
    }
}
