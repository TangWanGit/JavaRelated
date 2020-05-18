/*
 * File Name:Main is created on 2020-05-08 16:52 by tangwan
 *
 * tangwan
 *
 */
package com.tangwan.disruptor.v4;

import java.nio.ByteBuffer;
import java.util.concurrent.Executors;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

/**
 * @author tangwan
 * @Description : Main
 * @date 2020-05-08 16:52
 * @since JDK 1.8
 */
public class Main {

    public static void translator(LongEvent event, long sequence, ByteBuffer arg0) {
        event.setValue(arg0.getLong(0));
    }

    public static void handler(LongEvent event, long sequence, boolean endOfBatch) {
        System.out.println(event.getValue() + " " + sequence + " " + endOfBatch);
    }

    public static void main(String[] args) {
        int ringBufferSize = 128;

        // Construct the Disruptor
        Disruptor<LongEvent> disruptor =
            new Disruptor<>(LongEvent::new, ringBufferSize, Executors.defaultThreadFactory());

        // Connect the handler
        disruptor.handleEventsWith(Main::handler);

        // Start the Disruptor, starts all threads running
        disruptor.start();

        // Get the ring buffer from the Disruptor to be used for publishing.
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        ByteBuffer bb = ByteBuffer.allocate(8);

        for (long i = 0; i < 200; i++) {
            bb.putLong(0, i << 1);
            ringBuffer.publishEvent(Main::translator, bb);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        disruptor.shutdown();
    }
}
