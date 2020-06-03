/*
 * File Name:T05_MaxSubBSTHead is created on 2020-06-03 09:44 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c08_binary_tree_recursive;

import java.util.ArrayList;
import java.util.List;

import com.tangwan.algorithm.c07_binary_tree.BinaryTree;
import com.tangwan.algorithm.c07_binary_tree.T05_PrintBinaryTree;

/**
 * @author Zhao Xiaoli
 * @Description : T05_MaxSubBSTHead
 * 最大子搜索树的头
 * @date 2020-06-03 09:44
 * @since JDK 1.8
 */
public class T05_MaxSubBSTHead extends T00_ListBase {

    public static void main(String[] args) {
        logarithmicDetector(t -> {
            BinaryTree r1 = maxSubBSTHead1(t);
            BinaryTree r2 = maxSubBSTHead2(t);
            boolean ans = r1 == r2;
            if (!ans) {
                T05_PrintBinaryTree.printTree(t);
                T05_PrintBinaryTree.printTree(r1);
                T05_PrintBinaryTree.printTree(r2);
            }
            return ans;
        });
    }

    public static BinaryTree maxSubBSTHead1(BinaryTree head) {
        if (head == null) {
            return null;
        }
        if (getBSTSize(head) != 0) {
            return head;
        }
        BinaryTree leftAns = maxSubBSTHead1(head.left);
        BinaryTree rightAns = maxSubBSTHead1(head.right);
        return getBSTSize(leftAns) >= getBSTSize(rightAns) ? leftAns : rightAns;
    }

    private static int getBSTSize(BinaryTree head) {
        if (head == null) {
            return 0;
        }
        List<BinaryTree> arr = new ArrayList<>();
        in(head, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).value <= arr.get(i - 1).value) {
                return 0;
            }
        }
        return arr.size();
    }

    private static void in(BinaryTree head, List<BinaryTree> arr) {
        if (head == null) {
            return;
        }
        in(head.left, arr);
        arr.add(head);
        in(head.right, arr);
    }

    private static BinaryTree maxSubBSTHead2(BinaryTree head) {
        if (head == null) {
            return null;
        }
        return process(head).maxSubBSTHead;
    }

    private static Info process(BinaryTree X) {
        if (X == null) {
            return null;
        }
        Info leftInfo = process(X.left);
        Info rightInfo = process(X.right);

        int min = X.value;
        int max = X.value;
        int maxSubBSTSize = 0;
        BinaryTree maxSubBSTHead = null;

        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
            maxSubBSTSize = leftInfo.maxSubBSTSize;
            maxSubBSTHead = leftInfo.maxSubBSTHead;
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
            if (rightInfo.maxSubBSTSize > maxSubBSTSize) {
                maxSubBSTSize = rightInfo.maxSubBSTSize;
                maxSubBSTHead = rightInfo.maxSubBSTHead;
            }
        }

        if (// 左树整体需要是搜索二叉树
            (leftInfo == null || leftInfo.maxSubBSTHead == X.left) && (rightInfo == null
                || rightInfo.maxSubBSTHead == X.right) &&
                // 左树最大值<x
                (leftInfo == null || leftInfo.max < X.value) && (rightInfo == null || rightInfo.min > X.value)) {
            maxSubBSTSize =
                (leftInfo == null ? 0 : leftInfo.maxSubBSTSize) + (rightInfo == null ? 0 : rightInfo.maxSubBSTSize) + 1;
            maxSubBSTHead = X;
        }

        return new Info(min, max, maxSubBSTSize, maxSubBSTHead);
    }

    public static class Info {
        public BinaryTree maxSubBSTHead;
        public int maxSubBSTSize;
        public int min;
        public int max;

        public Info(int min, int max, int maxSubBSTSize, BinaryTree maxSubBSTHead) {
            this.maxSubBSTHead = maxSubBSTHead;
            this.maxSubBSTSize = maxSubBSTSize;
            this.min = min;
            this.max = max;
        }
    }
}
