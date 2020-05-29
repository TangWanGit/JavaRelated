/*
 * File Name:T03_LevelTraversalBT is created on 2020-05-29 10:44 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c07_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Zhao Xiaoli
 * @Description : T03_LevelTraversalBT
 * <p>
 * 按层输出二叉树
 * @date 2020-05-29 10:44
 * @since JDK 1.8
 */
public class T03_LevelTraversalBT {

    public static void main(String[] args) {
        BinaryTree head = new BinaryTree(1);
        head.left = new BinaryTree(2);
        head.right = new BinaryTree(3);
        head.left.left = new BinaryTree(4);
        head.left.right = new BinaryTree(5);
        head.right.left = new BinaryTree(6);
        head.right.right = new BinaryTree(7);

        levelTraversal(head);
    }

    public static void levelTraversal(BinaryTree bt) {
        if (bt != null) {
            Queue<BinaryTree> queue = new LinkedList<>();
            queue.offer(bt);
            while (!queue.isEmpty()) {
                bt = queue.poll();
                System.out.print(bt.value + " ");
                if (bt.left != null) {
                    queue.offer(bt.left);
                }
                if (bt.right != null) {
                    queue.offer(bt.right);
                }
            }
        }
    }

}
