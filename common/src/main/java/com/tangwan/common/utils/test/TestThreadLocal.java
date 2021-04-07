package com.tangwan.common.utils.test;

public class TestThreadLocal {

    //线程本地存储变量
    private static final ThreadLocal<Integer> THREAD_LOCAL_NUM = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public static void main(String[] args) {
        //启动三个线程
        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(() -> add10ByThreadLocal());
            t.start();
        }
    }

    /**
     * 线程本地存储变量加 5
     */
    private static void add10ByThreadLocal() {
        for (int i = 0; i < 5; i++) {
            Integer n = THREAD_LOCAL_NUM.get();
            n += 1;
            System.gc();

            THREAD_LOCAL_NUM.set(n);



            System.out.println(Thread.currentThread().getName() + " : ThreadLocal num=" + n);
        }
    }
}