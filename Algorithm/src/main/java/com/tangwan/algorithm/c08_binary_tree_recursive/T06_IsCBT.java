/*
 * File Name:T06_IsCBT is created on 2020-06-03 10:19 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c08_binary_tree_recursive;

import java.util.LinkedList;
import java.util.Queue;

import com.tangwan.algorithm.c07_binary_tree.BinaryTree;

/**
 * @author Zhao Xiaoli
 * @Description : T06_IsCBT
 * 是否为完全二叉树
 * @date 2020-06-03 10:19
 * @since JDK 1.8
 */
public class T06_IsCBT extends T00_ListBase {
    public static void main(String[] args) {
        logarithmicDetector(t -> isCBT1(t).equals(isCBT2(t)));
    }

    private static Boolean isCBT1(BinaryTree head) {
        if (head == null) {
            return true;
        }

        // 是否遇到过左右两个孩子不双全的节点
        boolean leaf = false;
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(head);
        BinaryTree l = null;
        BinaryTree r = null;
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;

            // 如果遇到了不双全的节点之后，又发现当前节点不是叶节点
            if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                queue.add(l);
            }

            if (r != null) {
                queue.add(r);
            }
            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }

    private static Boolean isCBT2(BinaryTree head) {
        if (head == null) {
            return true;
        }
        return process(head).isCBT;
    }

    private static Info process(BinaryTree X) {
        if (X == null) {
            return new Info(true, true, 0);
        }
        Info leftInfo = process(X.left);
        Info rightInfo = process(X.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        boolean isFull = leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height;

        boolean isCBT = false;
        if (isFull) {
            isCBT = true;
        } else {
            if (leftInfo.isCBT && rightInfo.isCBT) {
                if (leftInfo.isCBT && rightInfo.isFull && leftInfo.height == rightInfo.height + 1) {
                    isCBT = true;
                }

                if (leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height + 1) {
                    isCBT = true;
                }
                if (leftInfo.isFull && rightInfo.isCBT && leftInfo.height == rightInfo.height) {
                    isCBT = true;
                }
            }
        }
        return new Info(isFull, isCBT, height);
    }

    public static class Info {
        // 对每一棵子树，是否是满二叉树、是否是完全二叉树、高度
        public boolean isFull;
        public boolean isCBT;
        public int height;

        public Info(boolean isFull, boolean isCBT, int height) {
            this.isFull = isFull;
            this.isCBT = isCBT;
            this.height = height;
        }
    }
}
