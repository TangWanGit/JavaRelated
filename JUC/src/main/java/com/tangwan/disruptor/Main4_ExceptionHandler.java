/*
 * File Name:Main_ProduerType is created on 2020-05-09 11:53 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.disruptor;

import java.util.concurrent.Executors;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.ExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SleepingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.tangwan.disruptor.v1.LongEvent;
import com.tangwan.disruptor.v1.LongEventFactory;

/**
 * @author Zhao Xiaoli
 * @Description : Main3_MultiConsumer
 * @date 2020-05-09 11:53
 * @since JDK 1.8
 */
public class Main4_ExceptionHandler extends Main0_Base {
    public static void main(String[] args) {
        LongEventFactory factory = new LongEventFactory();
        int ringBufferSize = 1024;

        Disruptor<LongEvent> disruptor =
            new Disruptor<>(factory, ringBufferSize, Executors.defaultThreadFactory(), ProducerType.MULTI,
                new SleepingWaitStrategy());

        EventHandler handler = (event, sequence, endOfBatch) -> {
            System.out.println(event);
            throw new Exception("消费者出异常");
        };
        disruptor.handleEventsWith(handler);

        disruptor.handleExceptionsFor(handler).with(new ExceptionHandler() {
            @Override
            public void handleEventException(Throwable ex, long sequence, Object event) {
                ex.printStackTrace();
            }

            @Override
            public void handleOnStartException(Throwable ex) {
                System.out.println("Exception Start to Handle!");
            }

            @Override
            public void handleOnShutdownException(Throwable ex) {
                System.out.println("Exception Handled!");
            }
        });

        disruptor.start();

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        test(ringBuffer);
    }
}
