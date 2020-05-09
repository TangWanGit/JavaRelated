/*
 * File Name:LongEventHandler is created on 2020-05-08 17:28 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.disruptor.v2;

import com.lmax.disruptor.EventHandler;

/**
 * @author Zhao Xiaoli
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
