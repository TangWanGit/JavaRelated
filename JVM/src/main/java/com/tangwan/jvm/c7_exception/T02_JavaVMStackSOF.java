/*
 * File Name:T02_JavaVMStackSOF is created on 2020-10-19 10:48 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jvm.c7_exception;

/**
 * @author Zhao Xiaoli
 * @Description : 测试本地方法栈和虚拟机栈
 * -Xss128k
 * The stack size specified is too small, Specify at least 160k
 * -Xss160k
 * <p/>
 * 实验结果表明: 无论是由于栈帧太大还是虚拟机容量太小，当新的栈帧内存无法分配的时候，HotSpot虚拟机抛出的都是StackOverflowError异常。
 * 可是如果在允许动态扩展栈容量大小的虚拟机上，相同代码则会导致不一样的情况。
 * @date 2020-10-19 10:48
 * @since JDK 1.8
 */
public class T02_JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        try {
            testLocalVariables();
        } catch (Throwable e) {
            System.out.println("stack length : " + stack);
            throw e;
        }
    }

    public static int stack = 0;

    public static void testLocalVariables() {
        long unused1, unused2, unused3, unused4, unused5, unused6, unused7, unused8, unused9, unused10, unused11,
            unused12, unused13, unused14, unused15, unused16, unused17, unused18, unused19, unused20, unused21,
            unused22, unused23, unused24, unused25, unused26, unused27, unused28, unused29, unused30, unused31,
            unused32, unused33, unused34, unused35, unused36, unused37, unused38, unused39, unused40, unused41,
            unused42, unused43, unused44, unused45, unused46, unused47, unused48, unused49, unused50, unuse5d1,
            unused52, unused53, unused54, unused55, u5nused6, un5used7, unu5sed8, unus5ed9, unuse5d60, u6nused1,
            u6nused2, u6nused3, u6nused4, u6nused5, u6nused6, u6nused7, u6nused8, u6nused9, unused70, u7nused1,
            un7used2, unu7sed3, unus7ed4, unuse7d5, unused76, unused77, unused78, unused79, u7nused80, unused81,
            unused82, unused83, unused84, unused85, unused86, unused87, unused88, unused89, unused90, unused181,
            unuse1d82, unuse1d83, unus1ed84, unus1ed85, unus1ed86, un1used87, un1used88, u1nused89, unused100;
        stack++;
        testLocalVariables();
        unused1 = unused2 = unused3 = unused4 = unused5 = unused6 = unused7 = unused8 = unused9 = unused10 = unused11 =
            unused12 = unused13 = unused14 = unused15 = unused16 = unused17 = unused18 = unused19 = unused20 =
                unused21 = unused22 = unused23 = unused24 = unused25 = unused26 = unused27 = unused28 = unused29 =
                    unused30 = unused31 = unused32 = unused33 = unused34 = unused35 = unused36 = unused37 = unused38 =
                        unused39 = unused40 = unused41 = unused42 = unused43 =
                            unused44 = unused45 = unused46 = unused47 = unused48 = unused49 = unused50 = unuse5d1 =
                                unused52 = unused53 = unused54 = unused55 = u5nused6 = un5used7 = unu5sed8 = unus5ed9 =
                                    unuse5d60 = u6nused1 = u6nused2 = u6nused3 = u6nused4 = u6nused5 = u6nused6 =
                                        u6nused7 = u6nused8 = u6nused9 = unused70 = u7nused1 = un7used2 = unu7sed3 =
                                            unus7ed4 = unuse7d5 = unused76 = unused77 = unused78 = unused79 =
                                                u7nused80 = unused81 = unused82 = unused83 = unused84 = unused85 =
                                                    unused86 = unused87 = unused88 = unused89 = unused90 = unused181 =
                                                        unuse1d82 = unuse1d83 = unus1ed84 = unus1ed85 = unus1ed86 =
                                                            un1used87 = un1used88 = u1nused89 = unused100 = 0;
    }

    /**
     * 栈帧
     */
    private static void stackLeakTest() {
        T02_JavaVMStackSOF sof = new T02_JavaVMStackSOF();
        try {
            sof.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length : " + sof.stackLength);
            throw e;
        }
    }
}
