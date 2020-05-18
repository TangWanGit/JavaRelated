/*
 * File Name:LongEventHandler is created on 2020-05-08 17:28 by tangwan
 *
 * tangwan
 *
 */
package com.tangwan.disruptor.v1;

import java.util.concurrent.atomic.AtomicLong;

import com.lmax.disruptor.EventHandler;

/**
 * @author tangwan
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
