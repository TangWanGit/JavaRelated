/*
 * File Name:StopWatcher is created on 2020-05-06 09:36 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc;

/**
 * @author tangwan
 * @Description : StopWatcher
 * @date 2020-05-06 09:36
 * @since JDK 1.8
 */
public class StopWatcher {

    private long start;
    private long end;

    public void start() {
        start = System.currentTimeMillis();
    }

    public void end() {
        end = System.currentTimeMillis();
    }

    public void finish() {
        System.out.println("consuming : " + (end - start));
    }

    public void endAndFinish() {
        end();
        finish();
    }

}
