/*
 * File Name:Main_ProduerType is created on 2020-05-09 11:53 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.disruptor;

import java.util.concurrent.Executors;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SleepingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.tangwan.disruptor.Main0_Base;
import com.tangwan.disruptor.v1.LongEvent;
import com.tangwan.disruptor.v1.LongEventFactory;
import com.tangwan.disruptor.v1.LongEventHandler;

/**
 * @author Zhao Xiaoli
 * @Description : Main2_WaitStrategy
 * @date 2020-05-09 11:53
 * @since JDK 1.8
 */
public class Main2_WaitStrategy extends Main0_Base {
    public static void main(String[] args) {
        LongEventFactory factory = new LongEventFactory();
        int ringBufferSize = 1024;

        Disruptor<LongEvent> disruptor =
            new Disruptor<>(factory, ringBufferSize, Executors.defaultThreadFactory(), ProducerType.MULTI,
                new SleepingWaitStrategy());

        disruptor.handleEventsWith(new LongEventHandler());
        disruptor.start();

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        test(ringBuffer);
    }
}
