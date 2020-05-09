/*
 * File Name:T01_MyExecutor is created on 2020-05-06 19:37 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c14_ThreadPool;

import java.util.concurrent.Executor;

/**
 * @author tangwan
 * @Description : T01_MyExecutor
 * 认识Executor
 * @date 2020-05-06 19:37
 * @since JDK 1.8
 */
public class T01_MyExecutor implements Executor {

    @Override
    public void execute(Runnable command) {
        command.run();
    }

    public static void main(String[] args) {
        new T01_MyExecutor().execute(() -> System.out.println("hello executor"));
    }
}
