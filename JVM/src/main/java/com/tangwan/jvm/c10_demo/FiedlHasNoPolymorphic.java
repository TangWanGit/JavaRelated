/*
 * File Name:FiedlHasNoPolymorphic is created on 2020-10-30 17:30 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c10_demo;

/**
 * @author Zhao Xiaoli
 * @Description : FiedlHasNoPolymorphic
 * @date 2020-10-30 17:30
 * @since JDK 1.8
 */
public class FiedlHasNoPolymorphic {
    static class Father {
        public int money = 1;

        public Father() {
            money = 2;
            showMeTheMoney();
        }

        public void showMeTheMoney() {
            System.out.println("I am Father, i have $" + money);
        }
    }

    static class Son extends Father {
        public int money = 3;

        public Son() {
            money = 4;
            showMeTheMoney();
        }

        @Override
        public void showMeTheMoney() {
            System.out.println("I am Son, i have $" + money);
        }
    }

    public static void main(String[] args) {
        Son son = new Son();
        System.out.println("This guy has $" + son.money);
    }
}
