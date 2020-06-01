/*
 * File Name:T05_PrintBinaryTree is created on 2020-06-01 10:24 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c07_binary_tree;

/**
 * @author Zhao Xiaoli
 * @Description : T05_PrintBinaryTree
 * @date 2020-06-01 10:24
 * @since JDK 1.8
 */
public class T05_PrintBinaryTree {
    public static void main(String[] args) {
        BinaryTree head = new BinaryTree(1);
        head.left = new BinaryTree(-222222222);
        head.right = new BinaryTree(3);
        head.left.left = new BinaryTree(Integer.MIN_VALUE);
        head.right.left = new BinaryTree(55555555);
        head.right.right = new BinaryTree(66);
        head.left.left.right = new BinaryTree(777);
        printTree(head);

        head = new BinaryTree(1);
        head.left = new BinaryTree(2);
        head.right = new BinaryTree(3);
        head.left.left = new BinaryTree(4);
        head.right.left = new BinaryTree(5);
        head.right.right = new BinaryTree(6);
        head.left.left.right = new BinaryTree(7);
        printTree(head);

        head = new BinaryTree(1);
        head.left = new BinaryTree(1);
        head.right = new BinaryTree(1);
        head.left.left = new BinaryTree(1);
        head.right.left = new BinaryTree(1);
        head.right.right = new BinaryTree(1);
        head.left.left.right = new BinaryTree(1);
        printTree(head);
    }

    public static void printTree(BinaryTree head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();

    }

    private static void printInOrder(BinaryTree head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenL - lenM;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    private static String getSpace(int num) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
