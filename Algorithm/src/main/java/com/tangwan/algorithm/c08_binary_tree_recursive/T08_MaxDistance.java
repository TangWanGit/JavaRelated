/*
 * File Name:T08_MaxDistance is created on 2020-06-03 11:58 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c08_binary_tree_recursive;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.tangwan.algorithm.c07_binary_tree.BinaryTree;
import com.tangwan.algorithm.c07_binary_tree.T05_PrintBinaryTree;

/**
 * @author Zhao Xiaoli
 * @Description : T08_MaxDistance
 * @date 2020-06-03 11:58
 * @since JDK 1.8
 */
public class T08_MaxDistance extends T00_ListBase {

    public static void main(String[] args) {
        logarithmicDetector(t -> {
            int d1 = maxDistance1(t);
            int d2 = maxDistance2(t);
            if (d1 != d2) {
                System.out.println("d1: " + d1);
                System.out.println("d2: " + d2);
                T05_PrintBinaryTree.printTree(t);
            }
            return d1 == d2;
        });
    }

    private static int maxDistance1(BinaryTree head) {
        if (head == null) {
            return 0;
        }
        List<BinaryTree> arr = getPrelist(head);
        Map<BinaryTree, BinaryTree> parentMap = getParentMap(head);

        int max = 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i; j < arr.size(); j++) {
                max = Math.max(max, distance(parentMap, arr.get(i), arr.get(j)));
            }
        }
        return max;
    }

    private static int distance(Map<BinaryTree, BinaryTree> parentMap, BinaryTree b1, BinaryTree b2) {
        // 1. 先获取最小相交祖先
        Set<BinaryTree> b1Set = new HashSet<>();
        b1Set.add(b1);
        BinaryTree cur = b1;
        while (parentMap.get(cur) != null) {
            cur = parentMap.get(cur);
            b1Set.add(cur);
        }
        cur = b2;
        while (!b1Set.contains(cur)) {
            cur = parentMap.get(cur);
        }

        BinaryTree lowestAncestor = cur;

        cur = b1;
        int distance1 = 1;
        // 2. 从祖先到b1的距离
        while (cur != lowestAncestor) {
            cur = parentMap.get(cur);
            distance1++;
        }

        cur = b2;
        int distance2 = 1;
        // 3. 从祖先到b2的距离
        while (cur != lowestAncestor) {
            cur = parentMap.get(cur);
            distance2++;
        }

        // 4. 两者距离相加-1，因为祖先参与了两次计算
        return distance1 + distance2 - 1;
    }

    private static int maxDistance2(BinaryTree head) {
        if (head == null) {
            return 0;
        }

        return process(head).maxDistance;
    }

    private static Info process(BinaryTree head) {
        if (head == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int maxDistance =
            Math.max(Math.max(leftInfo.maxDistance, rightInfo.maxDistance), leftInfo.height + rightInfo.height + 1);

        return new Info(height, maxDistance);
    }

    public static class Info {
        public int height;
        public int maxDistance;

        public Info(int height, int maxDistance) {
            this.height = height;
            this.maxDistance = maxDistance;
        }
    }
}
