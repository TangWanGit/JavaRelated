/*
 * File Name:T01_RecursiveTraversalBT is created on 2020-05-28 17:40 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c07_binary_tree;

/**
 * @author Zhao Xiaoli
 * @Description : T01_RecursiveTraversalBT
 * 前序 中序  后序  遍历二叉树
 * 使用递归方式
 * @date 2020-05-28 17:40
 * @since JDK 1.8
 */
public class T01_RecursiveTraversalBT {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        pre(head);
        System.out.println("\n===========================");
        in(head);
        System.out.println("\n===========================");
        pos(head);
        System.out.println("\n===========================");
    }

    public static void f(Node head) {
        if (head == null) {
            return;
        }
        // 1 前序遍历
        f(head.left);
        // 2 中序遍历
        f(head.right);
        // 3 后序遍历
    }

    public static void pre(Node head) {
        if (head == null) {
            return;
        }
        // 1 前序遍历
        System.out.print(head.value + " ");
        pre(head.left);
        pre(head.right);
    }

    public static void in(Node head) {
        if (head == null) {
            return;
        }
        in(head.left);
        // 2 中序遍历
        System.out.print(head.value + " ");
        in(head.right);
    }

    public static void pos(Node head) {
        if (head == null) {
            return;
        }
        pos(head.left);
        pos(head.right);
        // 3 后序遍历
        System.out.print(head.value + " ");
    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

}
