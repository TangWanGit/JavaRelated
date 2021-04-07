package com.tangwan.common.utils.limiting;

/**
 * @author Zhao Xiaoli
 * @Description : LeakBucket
 * Leaky Bucket 漏桶
 * 规定固定容量的桶, 有水进入, 有水流出. 对于流进的水我们无法估计进来的数量、速度, 对于流出的水我们可以控制速度.
 * @date 2021/3/9 10:13 上午
 * @since JDK 1.8
 */
public class LeakBucket {
    /**
     * 时间
     */
    private long time;
    /**
     * 总量
     */
    private Double total;
    /**
     * 水流出去的速度
     */
    private Double rate;
    /**
     * 当前总量
     */
    private Double nowSize;

    public boolean limit() {
        long now = System.currentTimeMillis();
        nowSize = Math.max(0, (nowSize - (now - time) * rate));
        time = now;
        if ((nowSize + 1) < total) {
            nowSize++;
            return true;
        } else {
            return false;
        }

    }

}
