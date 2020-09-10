/*
 * File Name:TerminationCondition is created on 2020-08-30 19:05 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm;

/**
 * @author Zhao Xiaoli
 * @Description : TerminationCondition
 * @date 2020-08-30 19:05
 * @since JDK 1.8
 */
public class TerminationCondition {
    public static void main(String[] args) {
        Book novel = new Book(true);
        novel.checkIn();
        new Book(true);
        System.gc();
    }

    static class Book {
        boolean checkedOut = false;

        public Book(boolean checkedOut) {
            this.checkedOut = checkedOut;
        }

        void checkIn() {
            checkedOut = false;
        }

        @Override
        protected void finalize() throws Throwable {
            if (checkedOut) {
                System.out.println("Error: checked out");
                super.finalize();
            }
        }
    }
}
