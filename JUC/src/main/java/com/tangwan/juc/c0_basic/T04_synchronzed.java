/*
 * File Name:T04_synchronzed is created on 2020-05-07 16:28 by tangwan
 *
 * tangwan
 *
 */
package com.tangwan.juc.c0_basic;

/**
 * @author tangwan
 * @Description : T04_synchronzed
 * @date 2020-05-07 16:28
 * @since JDK 1.8
 */
public class T04_synchronzed {

    private int count = 10;
    private Object o = new Object();

    public void syncObject() {
        synchronized (o) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

    public void syncThis() {
        synchronized (this) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

    public synchronized void syncMethod1() {
        System.out.println("syncMethod1");
        normalMethod();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void syncMethod2() {
        System.out.println("syncMethod2");
    }

    public void normalMethod() {
        System.out.println("normal");
    }

    public static void main(String[] args) throws InterruptedException {
        T04_synchronzed t = new T04_synchronzed();
        Thread threadA = new Thread(t::syncMethod1);
        //Thread threadB = new Thread(t::syncMethod2);
        //Thread threadC = new Thread(t::normalMethod);

        threadA.start();
        //threadB.start();
        //threadC.start();
        //
        //threadA.join();
        //threadB.join();
        //threadC.join();
    }

}
