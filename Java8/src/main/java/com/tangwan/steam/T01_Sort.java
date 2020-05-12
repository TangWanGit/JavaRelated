/*
 * File Name:T01_Sort is created on 2020-05-12 10:27 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.steam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Zhao Xiaoli
 * @Description : T01_Sort
 * @date 2020-05-12 10:27
 * @since JDK 1.8
 */
public class T01_Sort {
    public static void main(String[] args) {
        List<SortBean> rules = new ArrayList<>();
        for (long i = 0; i < 10; i++) {
            SortBean rule = new SortBean();
            rule.setId(i);
            rule.setLimit(i << 1);
            rules.add(rule);
        }

        List<SortBean> collect =
            rules.stream().sorted(Comparator.comparing(SortBean::getLimit).reversed()).collect(Collectors.toList());

        System.out.println(collect);
    }
}

