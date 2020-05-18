/*
 * File Name:LongEventFactory is created on 2020-05-08 16:56 by tangwan
 *
 * tangwan
 *
 */
package com.tangwan.disruptor.v1;

import com.lmax.disruptor.EventFactory;

/**
 * @author tangwan
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
