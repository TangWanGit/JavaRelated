/*
 * File Name:T04_MaxSubBSTSize is created on 2020-06-02 18:44 by Zhao Xiaoli
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
 * @Description : T04_MaxSubBSTSize
 * 获取最大子搜索树的节点数
 * @date 2020-06-02 18:44
 * @since JDK 1.8
 */
public class T04_MaxSubBSTSize extends T00_ListBase {

    public static void main(String[] args) {
        logarithmicDetector(t -> {
            int r1 = maxSubBSTSize1(t);
            int r2 = maxSubBSTSize2(t);
            boolean ans = r1 == r2;
            if (!ans) {
                System.out.println("r1 " + r1);
                System.out.println("r2 " + r2);
                T05_PrintBinaryTree.printTree(t);
            }
            return ans;
        });
    }

    private static int maxSubBSTSize1(BinaryTree head) {
        if (head == null) {
            return 0;
        }

        int h = getBSTSize(head);
        if (h != 0) {
            return h;
        }
        return Math.max(maxSubBSTSize1(head.left), maxSubBSTSize1(head.right));
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

    private static int maxSubBSTSize2(BinaryTree head) {
        if (head == null) {
            return 0;
        }

        return process(head).maxSubBSTSize;
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
        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
            maxSubBSTSize = leftInfo.maxSubBSTSize;
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
            maxSubBSTSize = Math.max(maxSubBSTSize, rightInfo.maxSubBSTSize);
        }

        boolean isAllBST = false;
        if (// 左树整体需要是搜索二叉树
            (leftInfo == null || leftInfo.isAllBST) && (rightInfo == null || rightInfo.isAllBST) &&
                // 左树最大值<x
                (leftInfo == null || leftInfo.max < X.value) && (rightInfo == null || rightInfo.min > X.value)) {
            isAllBST = true;
            maxSubBSTSize =
                (leftInfo == null ? 0 : leftInfo.maxSubBSTSize) + (rightInfo == null ? 0 : rightInfo.maxSubBSTSize) + 1;
        }

        return new Info(min, max, maxSubBSTSize, isAllBST);
    }

    public static class Info {
        public int min;
        public int max;
        public int maxSubBSTSize;
        public boolean isAllBST;

        public Info(int min, int max, int maxSubBSTSize, boolean isAllBST) {
            this.min = min;
            this.max = max;
            this.maxSubBSTSize = maxSubBSTSize;
            this.isAllBST = isAllBST;
        }
    }

}
