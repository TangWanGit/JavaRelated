/*
 * File Name:T07_DirtyRead is created on 2020-09-12 11:43 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c0_basic;

import java.util.concurrent.TimeUnit;

/**
 * @author Zhao Xiaoli
 * @Description : T07_DirtyRead
 * @date 2020-09-12 11:43
 * @since JDK 1.8
 */
public class T07_DirtyRead {

    public static class Account {
        String name;
        double balance;

        public synchronized void set(String name, double balance) {
            this.name = name;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.balance = balance;
        }

        public double getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();
        new Thread(() -> account.set("zhangsan", 100.0)).start();

        TimeUnit.SECONDS.sleep(1);

        System.out.println(account.getBalance());

        TimeUnit.SECONDS.sleep(2);

        System.out.println(account.getBalance());
    }
}
