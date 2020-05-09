/*
 * File Name:LongEventHandler is created on 2020-05-08 17:28 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.disruptor.v1;

import java.util.concurrent.atomic.AtomicLong;

import com.lmax.disruptor.EventHandler;

/**
 * @author Zhao Xiaoli
 * @Description : LongEventHandler
 * @date 2020-05-08 17:28
 * @since JDK 1.8
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    public static AtomicLong count = new AtomicLong();

    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        count.incrementAndGet();
        System.out.println("[" + Thread.currentThread().getName() + "]" + event + " 序号：" + sequence);
    }
}
