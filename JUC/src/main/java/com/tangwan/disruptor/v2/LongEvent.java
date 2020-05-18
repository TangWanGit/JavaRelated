/*
 * File Name:LongEvent is created on 2020-05-08 16:53 by tangwan
 *
 * tangwan
 *
 */
package com.tangwan.disruptor.v2;

/**
 * @author tangwan
 * @Description : LongEvent
 * @date 2020-05-08 16:53
 * @since JDK 1.8
 */
public class LongEvent {

    private long value;

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
