/*
 * File Name:T01_TestHashtable is created on 2020-04-28 16:22 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.juc.c10_fromHashtableToCHM;

import java.util.Hashtable;
import java.util.UUID;

/**
 * @author tangwan
 * @Description : T01_TestHashtable
 * 读：慢
 * 写：较快
 * @date 2020-04-28 16:22
 * @since JDK 1.8
 */
public class T01_TestHashtable extends T00_TestBase {
    static Hashtable<UUID, UUID> m = new Hashtable<>();
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
        T01_TestHashtable t = new T01_TestHashtable();
        t.test();
    }
}
