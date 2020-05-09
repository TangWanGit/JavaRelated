/*
 * File Name:T08_DelayQueue is created on 2020-05-06 17:04 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c12_concurrentTools;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author tangwan
 * @Description : T08_DelayQueue
 * @date 2020-05-06 17:04
 * @since JDK 1.8
 */
public class T08_DelayQueue {

    static BlockingQueue<MyTask> tasks = new DelayQueue<>();

    static class MyTask implements Delayed {

        String name;
        long runningTime;

        public MyTask(String name, long runningTime) {
            this.name = name;
            this.runningTime = runningTime;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(runningTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
                return -1;
            }
            if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
                return 1;
            }
            return 0;
        }

        @Override
        public String toString() {
            return "MyTask{" + "name='" + name + '\'' + ", runningTime=" + runningTime + '}';
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long now = System.currentTimeMillis();
        tasks.put(new MyTask("t1", now + 1000));
        tasks.put(new MyTask("t2", now + 2000));
        tasks.put(new MyTask("t3", now + 1500));
        tasks.put(new MyTask("t4", now + 2500));
        tasks.put(new MyTask("t5", now + 500));

        System.out.println(tasks);

        for (int i = 0; i < 5; i++) {
            System.out.println(tasks.take() + " " + System.currentTimeMillis());
        }
    }
}
