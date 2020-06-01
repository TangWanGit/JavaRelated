/*
 * File Name:BinaryTree is created on 2020-05-29 10:44 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c07_binary_tree;

/**
 * @author Zhao Xiaoli
 * @Description : BinaryTree
 * @date 2020-05-29 10:44
 * @since JDK 1.8
 */
public class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree parent;

    public BinaryTree(int value) {
        this.value = value;
    }
}
