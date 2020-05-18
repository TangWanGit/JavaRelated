/*
 * File Name:LongEventHandler is created on 2020-05-08 17:28 by tangwan
 *
 * tangwan
 *
 */
package com.tangwan.disruptor.v2;

import com.lmax.disruptor.EventHandler;

/**
 * @author tangwan
 * @Description : LongEventHandler
 * @date 2020-05-08 17:28
 * @since JDK 1.8
 */
public class LongEventHandler implements EventHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println(event.getValue() + " " + sequence + " " + endOfBatch);
    }
}
