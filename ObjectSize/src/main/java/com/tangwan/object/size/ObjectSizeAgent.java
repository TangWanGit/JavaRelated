/*
 * File Name:ObjectSizeAgent is created on 2020-04-16 14:04 by tangwan
 *
 * Copyright (c) 2020, tangwan All Rights Reserved.
 *
 */
package com.tangwan.object.size;

import java.lang.instrument.Instrumentation;

/**
 * @author tangwan
 * @Description : ObjectSizeAgent
 * @date 2020-04-16 14:04
 * @since JDK 1.8
 */
public class ObjectSizeAgent {
    private static Instrumentation inst;

    public static void premain(String agentArgs, Instrumentation _inst) {
        inst = _inst;
    }

    public static long sizeOf(Object o) {
        return inst.getObjectSize(o);
    }
}
