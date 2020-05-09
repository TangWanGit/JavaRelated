/*
 * File Name:LongEventProducer is created on 2020-05-08 17:29 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.disruptor.v1;

import java.nio.ByteBuffer;

import com.lmax.disruptor.RingBuffer;

/**
 * @author Zhao Xiaoli
 * @Description : LongEventProducer
 * @date 2020-05-08 17:29
 * @since JDK 1.8
 */
public class LongEventProducer {
    private RingBuffer<LongEvent> ringBuffer;

    public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(ByteBuffer buffer) {
        long sequence = ringBuffer.next();
        try {
            LongEvent longEvent = ringBuffer.get(sequence);
            longEvent.setValue(buffer.getLong(0));
        } finally {
            ringBuffer.publish(sequence);
        }
    }
}
