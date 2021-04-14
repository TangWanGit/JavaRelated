/*
 * File Name:Gongjijin is created on 2021-01-28 15:04 by Zhao Xiaoli
 *
 * Copyright (c) 2021, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm;

import java.util.LinkedList;

/**
 * @author Zhao Xiaoli
 * @Description : Gongjijin
 * @date 2021-01-28 15:04
 * @since JDK 1.8
 */
public class Gongjijin {
    public static void main(String[] args) {
        LinkedList<Long> alr = new LinkedList<>();
        alr.addLast(3257L);
        alr.addLast(3590L);

        ;

        long cur = 3590;
        long incr = 1600;

        long cc = 3590;

        long s = 3590;
        int count = 0;

        while (s < 500000) {
            cur = cur + incr;
            alr.addLast(cc);
            cc = cc - alr.removeFirst() + cur;
            s = cc / 12 * 15;
            count++;
        }
        System.out.println(count);
        System.out.println(s);
        System.out.println(cc);
    }
}
