package com.tangwan.common.utils.limiting;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Zhao Xiaoli
 * @Description : Counter
 * 控制单位时间内的请求数量
 * @date 2021/3/9 10:13 上午
 * @since JDK 1.8
 */
public class Counter {
    /**
     * 最大访问数量
     */
    private final int limit = 10;
    /**
     * 访问时间差
     */
    private final long timeout = 1000;
    /**
     * 请求时间
     */
    private long time;
    /**
     * 当前计数器
     */
    private AtomicInteger reqCount = new AtomicInteger(0);

    public boolean limit() {
        long now = System.currentTimeMillis();
        if (now < time + timeout) {
            // 单位时间内
            reqCount.addAndGet(1);
            return reqCount.get() <= limit;
        } else {
            // 超出单位时间
            time = now;
            reqCount = new AtomicInteger(0);
            return true;
        }
    }
}
