/*
 * File Name:T01_IsBalanced is created on 2020-06-02 16:47 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c08_binary_tree_recursive;

import com.tangwan.algorithm.c07_binary_tree.BinaryTree;

/**
 * @author Zhao Xiaoli
 * @Description : T01_IsBalanced
 * 平衡树
 * @date 2020-06-02 16:47
 * @since JDK 1.8
 */
public class T01_IsBalanced extends T00_ListBase {
    public static void main(String[] args) {
        logarithmicDetector((t) -> isBalanced1(t) == isBalanced2(t));
    }

    public static boolean isBalanced1(BinaryTree head) {
        boolean[] ans = new boolean[1];
        ans[0] = true;
        process1(ans, head);
        return ans[0];
    }

    private static int process1(boolean[] ans, BinaryTree head) {
        if (!ans[0] || head == null) {
            return 0;
        }

        int leftHeight = process1(ans, head.left);
        int rightHeight = process1(ans, head.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            ans[0] = false;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static boolean isBalanced2(BinaryTree head) {
        return process2(head).isBalanced;
    }

    private static Info process2(BinaryTree x) {
        if (x == null) {
            return new Info(true, 0);
        }
        Info leftInfo = process2(x.left);
        Info rightInfo = process2(x.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBalanced = true;
        if (!leftInfo.isBalanced || !rightInfo.isBalanced || Math.abs(rightInfo.height - leftInfo.height) > 1) {
            isBalanced = false;
        }
        return new Info(isBalanced, height);
    }

    private static class Info {
        public boolean isBalanced;
        public int height;

        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

}
