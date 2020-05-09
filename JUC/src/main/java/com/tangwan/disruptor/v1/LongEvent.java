/*
 * File Name:LongEvent is created on 2020-05-08 16:53 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.disruptor.v1;

/**
 * @author Zhao Xiaoli
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

    @Override
    public String toString() {
        return "LongEvent{" +
            "value=" + value +
            '}';
    }
}
