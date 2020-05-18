/*
 * File Name:Main_Base is created on 2020-05-09 11:56 by tangwan
 *
 * tangwan
 *
 */
package com.tangwan.disruptor;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.lmax.disruptor.RingBuffer;
import com.tangwan.disruptor.v1.LongEvent;
import com.tangwan.disruptor.v1.LongEventHandler;

/**
 * @author tangwan
 * @Description : Main_Base
 * @date 2020-05-09 11:56
 * @since JDK 1.8
 */
public class Main0_Base {

    public static void test(RingBuffer<LongEvent> ringBuffer) {
        final int threadCount = 50;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadCount);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadCount; i++) {
            int threadNum = i;
            executorService.submit(() -> {
                System.out.printf("Thraed %s ready to start\n", threadNum);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

                for (int j = 0; j < 100; j++) {
                    ringBuffer.publishEvent((event, sequent) -> {
                        event.setValue(threadNum);
                        System.out.println("生产了 " + threadNum);
                    });
                }
            });
        }

        executorService.shutdown();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(LongEventHandler.count.get());
    }
}
