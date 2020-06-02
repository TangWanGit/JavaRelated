/*
 * File Name:T02_IsFull is created on 2020-06-02 17:02 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c08_binary_tree_recursive;

import com.tangwan.algorithm.c07_binary_tree.BinaryTree;

/**
 * @author Zhao Xiaoli
 * @Description : T02_IsFull
 * 是否为满二叉树
 * @date 2020-06-02 17:02
 * @since JDK 1.8
 */
public class T02_IsFull extends T00_ListBase {

    public static void main(String[] args) {
        logarithmicDetector((head) -> isFull1(head) == isFull2(head));
    }

    public static boolean isFull1(BinaryTree head) {
        if (head == null) {
            return true;
        }

        int h = height(head);
        int n = nodes(head);
        return (1 << h) - 1 == n;
    }

    private static int nodes(BinaryTree head) {
        if (head == null) {
            return 0;
        }

        return nodes(head.left) + nodes(head.right) + 1;
    }

    private static int height(BinaryTree head) {
        if (head == null) {
            return 0;
        }

        return Math.max(height(head.left), height(head.right)) + 1;
    }

    public static boolean isFull2(BinaryTree head) {
        if (head == null) {
            return true;
        }
        Info all = process2(head);
        return (1 << all.height) - 1 == all.nodes;
    }

    private static Info process2(BinaryTree head) {
        if (head == null) {
            return new Info(0, 0);
        }

        Info left = process2(head.left);
        Info right = process2(head.right);

        return new Info(Math.max(left.height, right.height) + 1, left.nodes + right.nodes + 1);
    }

    public static class Info {
        public int height;
        public int nodes;

        public Info(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }
}
