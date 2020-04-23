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
public class T08_Phaser {

    public static void main(String[] args) {
        MarriagePhaser phaser = new MarriagePhaser();
        phaser.bulkRegister(5);

        for (int i = 0; i < 5; i++) {
            final int nameIndex = i;
            new Thread(() -> {
                Person p = new Person("person " + nameIndex);
                p.arrive();
                phaser.arriveAndAwaitAdvance();

                p.eat();
                phaser.arriveAndAwaitAdvance();

                p.leave();
                phaser.arriveAndAwaitAdvance();
            }).start();
        }
    }

    static class MarriagePhaser extends Phaser {
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase) {
                case 0:
                    System.out.println("所有人到齐了");
                    return false;
                case 1:
                    System.out.println("所有人吃完了");
                    return false;
                case 2:
                    System.out.println("所有人离开了");
                    System.out.println("婚礼结束");
                    return true;
                default:
                    return true;
            }
        }
    }

    static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }

        public void arrive() {
            milliSleep();
            System.out.println(name + " 到达现场");
        }

        public void eat() {
            milliSleep();
            System.out.println(name + " 吃完");
        }

        public void leave() {
            milliSleep();
            System.out.println(name + " 离开");
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
