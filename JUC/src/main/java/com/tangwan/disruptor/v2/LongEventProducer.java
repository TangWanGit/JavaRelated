/*
 * File Name:LongEventProducer is created on 2020-05-08 17:29 by tangwan
 *
 * tangwan
 *
 */
package com.tangwan.disruptor.v2;

import java.nio.ByteBuffer;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

/**
 * @author tangwan
 * @Description : LongEventProducer
 * @date 2020-05-08 17:29
 * @since JDK 1.8
 */
public class LongEventProducer {
    private RingBuffer<LongEvent> ringBuffer;

    private static final EventTranslatorOneArg<LongEvent, ByteBuffer> TRANSLATOR =
        (event, sequence, arg0) -> event.setValue(arg0.getLong(0));

    public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(ByteBuffer buffer) {
        ringBuffer.publishEvent(TRANSLATOR, buffer);
    }
}
