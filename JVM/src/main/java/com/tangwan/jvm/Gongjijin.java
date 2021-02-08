/*
 * File Name:Gongjijin is created on 2021-01-28 15:04 by Zhao Xiaoli
 *
 * Copyright (c) 2021, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Zhao Xiaoli
 * @Description : Gongjijin
 * @date 2021-01-28 15:04
 * @since JDK 1.8
 */
public class Gongjijin {
    public static void main(String[] args) {
        LinkedList<Long> alr = new LinkedList<>();
        alr.addLast(22773L);
        alr.addLast(18693L);
        alr.addLast(14613L);
        alr.addLast(10553L);
        alr.addLast(2373L);
        alr.addLast(14373L);
        alr.addLast(10293L);
        alr.addLast(9220L);
        alr.addLast(9220L);
        alr.addLast(8256L);
        alr.addLast(8256L);
        alr.addLast(7292L);

        ;

        long x = 22773;
        long y = 4080;
        long c = 11325;

        long cc = 11325 * 12;

        long s = 170000;
        int count = 0;

        while (s < 500000) {
            x = x + y;
            cc = cc - alr.removeLast() + x;
            s = cc / 12 * 15;
            count++;
        }
        System.out.println(count);
        System.out.println(s);
        System.out.println(cc);
    }
}
