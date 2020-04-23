/*
 * File Name:T08_Phaser is created on 2020-04-23 14:34 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c6_AQSLock;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @author Zhao Xiaoli
 * @Description : T08_Phaser
 * @date 2020-04-23 14:34
 * @since JDK 1.8
 */
public class T09_Phaser2 {
    static MarriagePhaser phaser = new MarriagePhaser();

    public static void main(String[] args) {
        phaser.bulkRegister(7);

        for (int i = 0; i < 5; i++) {
            new Thread(new Person("p" + i)).start();
        }

        new Thread(new Person("新郎")).start();
        new Thread(new Person("新娘")).start();
    }

    static class MarriagePhaser extends Phaser {
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase) {
                case 0:
                    System.out.println("所有人到齐了 " + registeredParties);
                    return false;
                case 1:
                    System.out.println("所有人吃完了" + registeredParties);
                    return false;
                case 2:
                    System.out.println("所有人离开了" + registeredParties);
                    return false;
                case 3:
                    System.out.println("婚礼结束，新郎新娘抱抱 " + registeredParties);
                    return true;
                default:
                    return true;
            }
        }
    }

    static class Person implements Runnable {
        String name;

        public Person(String name) {
            this.name = name;
        }

        public void arrive() {
            milliSleep();
            System.out.println(name + " 到达现场");

            phaser.arriveAndAwaitAdvance();
        }

        public void eat() {
            milliSleep();
            System.out.println(name + " 吃完");

            phaser.arriveAndAwaitAdvance();
        }

        public void leave() {
            milliSleep();
            System.out.println(name + " 离开");

            phaser.arriveAndAwaitAdvance();
        }

        private void hug() {
            if (name.equals("新郎") || name.equals("新娘")) {
                milliSleep();
                System.out.println(name + " 洞房");
                phaser.arriveAndAwaitAdvance();
            } else {
                phaser.arriveAndDeregister();
            }
        }

        @Override
        public void run() {
            arrive();
            eat();
            leave();
            hug();
        }
    }

    static Random random = new Random();

    static void milliSleep() {
        try {
            TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
