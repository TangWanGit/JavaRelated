/*
 * File Name:T01_WriteCombining is created on 2020-05-07 15:54 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c16_writeCombining;

/**
 * @author Zhao Xiaoli
 * @Description : T01_WriteCombining
 * <p>
 * 合并行
 * @date 2020-05-07 15:54
 * @since JDK 1.8
 */
public class T01_WriteCombining {
    private static final int ITERAtiONS = Integer.MAX_VALUE;

    private static final int ITEMS = 1 << 24;
    public static final int MASK = ITEMS - 1;

    public static final byte[] arrayA = new byte[ITEMS];
    public static final byte[] arrayB = new byte[ITEMS];
    public static final byte[] arrayC = new byte[ITEMS];
    public static final byte[] arrayD = new byte[ITEMS];
    public static final byte[] arrayE = new byte[ITEMS];
    public static final byte[] arrayF = new byte[ITEMS];
    public static final byte[] arrayG = new byte[ITEMS];
    public static final byte[] arrayH = new byte[ITEMS];
    public static final byte[] arrayI = new byte[ITEMS];

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.println(i + " SingleLoop duration (ns) = " + runCaseOne());
            System.out.println(i + " SplitLoop  duration (ns) = " + runCaseTwo());
        }
    }

    private static long runCaseOne() {
        long start = System.nanoTime();
        int i = ITERAtiONS;
        while (--i != 0) {
            int slot = i & MASK;
            byte b = (byte)i;
            arrayA[slot] = b;
            arrayB[slot] = b;
            arrayC[slot] = b;
            arrayD[slot] = b;
            arrayE[slot] = b;
            arrayF[slot] = b;
            arrayG[slot] = b;
            arrayH[slot] = b;
            arrayI[slot] = b;
        }
        return System.nanoTime() - start;
    }

    private static long runCaseTwo() {
        long start = System.nanoTime();
        int i = ITERAtiONS;
        while (--i != 0) {
            int slot = i & MASK;
            byte b = (byte)i;
            arrayA[slot] = b;
            arrayB[slot] = b;
            arrayC[slot] = b;
        }

        i = ITERAtiONS;
        while (--i != 0) {
            int slot = i & MASK;
            byte b = (byte)i;
            arrayD[slot] = b;
            arrayE[slot] = b;
            arrayF[slot] = b;
        }

        i = ITERAtiONS;
        while (--i != 0) {
            int slot = i & MASK;
            byte b = (byte)i;
            arrayG[slot] = b;
            arrayH[slot] = b;
            arrayI[slot] = b;
        }
        return System.nanoTime() - start;
    }
}
