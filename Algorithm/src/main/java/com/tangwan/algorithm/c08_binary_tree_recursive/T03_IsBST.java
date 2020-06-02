/*
 * File Name:T03_IsBST is created on 2020-06-02 17:40 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c08_binary_tree_recursive;

import java.util.ArrayList;
import java.util.List;

import com.tangwan.algorithm.c07_binary_tree.BinaryTree;

/**
 * @author Zhao Xiaoli
 * @Description : T03_IsBST
 * 搜索二叉树
 * @date 2020-06-02 17:40
 * @since JDK 1.8
 */
public class T03_IsBST extends T00_ListBase {

    public static void main(String[] args) {
        logarithmicDetector(t -> isBST1(t) == isBST2(t));
    }

    public static boolean isBST1(BinaryTree head) {
        if (head == null) {
            return true;
        }

        List<BinaryTree> arr = new ArrayList<>();
        in(head, arr);

        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).value <= arr.get(i - 1).value) {
                return false;
            }
        }
        return true;
    }

    private static void in(BinaryTree head, List<BinaryTree> arr) {
        if (head == null) {
            return;
        }
        in(head.left, arr);
        arr.add(head);
        in(head.right, arr);
    }

    public static boolean isBST2(BinaryTree head) {
        if (head == null) {
            return true;
        }
        return process(head).isBST;
    }

    private static Info process(BinaryTree head) {
        if (head == null) {
            return null;
        }

        Info left = process(head.left);
        Info right = process(head.right);

        int min = head.value;
        int max = head.value;
        if (left != null) {
            min = Math.min(min, left.min);
            max = Math.max(max, left.max);
        }
        if (right != null) {
            min = Math.min(min, right.min);
            max = Math.max(max, right.max);
        }

        boolean isBST = false;
        if ((left == null ? true : (left.isBST && left.max < head.value))
            &&
            (right == null ? true :
            (right.isBST && right.min > head.value))) {
            isBST = true;
        }
        return new Info(isBST, min, max);
    }

    public static class Info {
        public boolean isBST;
        public int min;
        public int max;

        public Info(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }

}
