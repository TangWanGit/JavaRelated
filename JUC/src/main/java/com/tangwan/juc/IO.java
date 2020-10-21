/*
 * File Name:IO is created on 2020-10-19 13:02 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Zhao Xiaoli
 * @Description : IO
 * @date 2020-10-19 13:02
 * @since JDK 1.8
 */
public class IO {
    public static void main(String[] args) throws IOException {
        new FileOutputStream("/Users/sunshine/Documents/xx.txt").write("i love china kkk".getBytes());
    }
}
