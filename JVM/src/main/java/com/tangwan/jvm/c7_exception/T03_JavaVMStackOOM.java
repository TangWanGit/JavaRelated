/*
 * File Name:T03_JavaVMStackOOM is created on 2020-10-19 11:26 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c7_exception;

/**
 * @author Zhao Xiaoli
 * @Description : T03_JavaVMStackOOM
 * @date 2020-10-19 11:26
 * @since JDK 1.8
 */
public class T03_JavaVMStackOOM {
    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            new Thread(this::dontStop).start();
        }
    }

    public static void main(String[] args) {
        T03_JavaVMStackOOM oom = new T03_JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
