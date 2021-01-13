/*
 * File Name:T05_Dispatch is created on 2021-01-11 16:25 by Zhao Xiaoli
 *
 * Copyright (c) 2021, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c13_dispatch;

/**
 * @author Zhao Xiaoli
 * @Description : 单分派和多分派
 * @date 2021-01-11 16:25
 * @since JDK 1.8
 */
public class T05_Dispatch {

    static class QQ {
    }

    static class _360 {
    }

    public static class Father {
        public void hardChoice(QQ arg) {
            System.out.println("father choose qq");
        }

        public void hardChoice(_360 arg) {
            System.out.println("father choose 360");
        }
    }

    public static class Son extends Father {
        @Override
        public void hardChoice(QQ arg) {
            System.out.println("son choose qq");
        }

        @Override
        public void hardChoice(_360 arg) {
            System.out.println("son choose 360");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        father.hardChoice(new _360());
        son.hardChoice(new QQ());
    }
}
