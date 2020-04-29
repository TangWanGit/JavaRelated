/*
 * File Name:T01_TestHashtable is created on 2020-04-28 16:22 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c10_fromHashtableToCHM;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Zhao Xiaoli
 * @Description : T01_TestHashtable
 * 读：较快
 * 写：较快
 * @date 2020-04-28 16:22
 * @since JDK 1.8
 */
public class T03_TestSynchronizedHashMap extends T00_TestBase {
    static Map<UUID, UUID> m = Collections.synchronizedMap(new HashMap<>());

    static int count = Constants.COUNT;
    static UUID[] keys = new UUID[count];
    static UUID[] values = new UUID[count];

    static {
        for (int i = 0; i < count; i++) {
            keys[i] = UUID.randomUUID();
            values[i] = UUID.randomUUID();
        }
    }

    @Override
    protected int getSize() {
        return m.size();
    }

    @Override
    protected Object get(int index) {
        return m.get(keys[index]);
    }

    @Override
    protected Object put(int index) {
        return m.put(keys[index], values[index]);
    }

    public static void main(String[] args) {
        T03_TestSynchronizedHashMap t = new T03_TestSynchronizedHashMap();
        t.test();
    }
}
