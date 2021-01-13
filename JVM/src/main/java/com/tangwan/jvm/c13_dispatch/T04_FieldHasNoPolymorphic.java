/*
 * File Name:T04_FieldHasNoPolymorphic is created on 2021-01-11 16:01 by Zhao Xiaoli
 *
 * Copyright (c) 2021, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c13_dispatch;

/**
 * @author Zhao Xiaoli
 * @Description : 字段没有多态性
 * @date 2021-01-11 16:01
 * @since JDK 1.8
 */
public class T04_FieldHasNoPolymorphic {
    static class Father {
        public int money = 1;

        public Father() {
            this.money = 2;
            showMeTheMoney();
        }

        public void showMeTheMoney() {
            System.out.println("I am Father， I have $" + money);
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
            System.out.println("I am Son， I have $" + money);
        }
    }

    public static void main(String[] args) {
        Father guy = new Son();
        System.out.println("This guy has $" + guy.money);
        System.out.println("This son has $" + ((Son)guy).money);
    }
}
