/*
 * File Name:T07_SuccessorBinaryTree is created on 2020-06-01 10:52 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c07_binary_tree;

/**
 * @author Zhao Xiaoli
 * @Description : T07_SuccessorBinaryTree
 * 获取继承者
 * @date 2020-06-01 10:52
 * @since JDK 1.8
 */
public class T07_SuccessorNode {
    public static void main(String[] args) {
        BinaryTree head = new BinaryTree(6);
        head.parent = null;
        head.left = new BinaryTree(3);
        head.left.parent = head;
        head.left.left = new BinaryTree(1);
        head.left.left.parent = head.left;
        head.left.left.right = new BinaryTree(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new BinaryTree(4);
        head.left.right.parent = head.left;
        head.left.right.right = new BinaryTree(5);
        head.left.right.right.parent = head.left.right;
        head.right = new BinaryTree(9);
        head.right.parent = head;
        head.right.left = new BinaryTree(8);
        head.right.left.parent = head.right;
        head.right.left.left = new BinaryTree(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new BinaryTree(10);
        head.right.right.parent = head.right;

        BinaryTree test = head.left.left;
        System.out.println(test.value + " next: " + getSuccessorBinaryTree(test).value);
        test = head.left.left.right;
        System.out.println(test.value + " next: " + getSuccessorBinaryTree(test).value);
        test = head.left;
        System.out.println(test.value + " next: " + getSuccessorBinaryTree(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + getSuccessorBinaryTree(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + getSuccessorBinaryTree(test).value);
        test = head;
        System.out.println(test.value + " next: " + getSuccessorBinaryTree(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + getSuccessorBinaryTree(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + getSuccessorBinaryTree(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + getSuccessorBinaryTree(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + getSuccessorBinaryTree(test));

        T05_PrintBinaryTree.printTree(head);
    }

    public static BinaryTree getSuccessorBinaryTree(BinaryTree bt) {
        if (bt == null) {
            return null;
        }
        if (bt.right != null) {
            return getLeftMost(bt.right);
        } else {
            BinaryTree parent = bt.parent;
            while (parent != null && parent.right == bt) {
                bt = parent;
                parent = bt.parent;
            }
            return parent;
        }
    }

    private static BinaryTree getLeftMost(BinaryTree binaryTree) {
        if (binaryTree == null) {
            return null;
        }
        while (binaryTree.left != null) {
            binaryTree = binaryTree.left;
        }

        return binaryTree;
    }

}
