/*
 * File Name:T09_Collection is created on 2020-09-22 14:45 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c0_basic;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Zhao Xiaoli
 * @Description : T09_Collection
 * @date 2020-09-22 14:45
 * @since JDK 1.8
 */
public class T09_Collection {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        list.add(11);
        for (Integer integer : list) {
            System.out.println(integer);
            list.remove(integer);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.remove(i));
        }

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
        }
    }
}
