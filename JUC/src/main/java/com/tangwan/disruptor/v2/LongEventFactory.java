/*
 * File Name:LongEventFactory is created on 2020-05-08 16:56 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.disruptor.v2;

import com.lmax.disruptor.EventFactory;

/**
 * @author Zhao Xiaoli
 * @Description : LongEventFactory
 * @date 2020-05-08 16:56
 * @since JDK 1.8
 */
public class LongEventFactory implements EventFactory<LongEvent>{
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }

}
