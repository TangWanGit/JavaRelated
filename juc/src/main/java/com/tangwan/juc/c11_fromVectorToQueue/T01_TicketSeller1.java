/*
 * File Name:T01_TicketSeller1 is created on 2020-04-29 11:49 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c11_fromVectorToQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhao Xiaoli
 * @Description : T01_TicketSeller1
 * <p>
 * 有N张火车票，每张票都有一个编号
 * 同时有10个窗口对外售票
 * 请写一个模拟程序
 * <p>
 * 分析下面的程序可能会产生哪些问题？
 * 重复销售？超量销售？
 *
 * <p>
 * @date 2020-04-29 11:49
 * @since JDK 1.8
 */
public class T01_TicketSeller1 {

    static List<String> tickets = new ArrayList<>();

    static {
        for (int i = 0; i < 10000; i++) {
            tickets.add("票编号：" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (tickets.size() > 0) {
                    System.out.println("销售了--" + tickets.remove(0));
                }
            }).start();
        }
    }
}
