/*
 * File Name:T06_TreeMaxWidth is created on 2020-06-01 10:33 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c07_binary_tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author Zhao Xiaoli
 * @Description : T06_TreeMaxWidth
 * 获取node数量最多的层
 * @date 2020-06-01 10:33
 * @since JDK 1.8
 */
public class T06_TreeMaxWidth {

    public static void main(String[] args) {
        int maxValue = 100;
        int maxLevel = 5;
        int testTimes = 1000_000;
        for (int i = 0; i < testTimes; i++) {
            BinaryTree head = generateRandomBST(maxLevel, maxValue);
            if (maxWidthNoMap(head) != maxWidthUseMap(head)) {
                System.out.println("Oops");
                break;
            }
        }
    }

    public static int maxWidthUseMap(BinaryTree head) {
        if (head == null) {
            return 0;
        }

        Map<BinaryTree, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);

        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(head);

        int curLevel = 1;
        int curLevelNodes = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            head = queue.poll();
            Integer curTreeLevel = levelMap.get(head);
            if (head.left != null) {
                levelMap.put(head.left, curTreeLevel + 1);
                queue.add(head.left);
            }
            if (head.right != null) {
                levelMap.put(head.right, curTreeLevel + 1);
                queue.add(head.right);
            }

            if (curTreeLevel == curLevel) {
                curLevelNodes++;
            } else {
                max = Math.max(max, curLevelNodes);
                curLevel = curTreeLevel;
                curLevelNodes = 1;
            }
        }

        max = Math.max(max, curLevelNodes);
        return max;
    }

    public static int maxWidthNoMap(BinaryTree head) {
        if (head == null) {
            return 0;
        }
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(head);

        BinaryTree curEnd = head;
        BinaryTree nextEnd = null;
        int max = 0;
        int curLevelNodes = 0;
        while (!queue.isEmpty()) {
            head = queue.poll();
            if (head.left != null) {
                queue.add(head.left);
                nextEnd = head.left;
            }
            if (head.right != null) {
                queue.add(head.right);
                nextEnd = head.right;
            }
            curLevelNodes++;
            if (head == curEnd) {
                max = Math.max(max, curLevelNodes);
                curLevelNodes = 0;
                curEnd = nextEnd;
            }
        }
        max = Math.max(max, curLevelNodes);
        return max;
    }

    private static BinaryTree generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    private static BinaryTree generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        BinaryTree head = new BinaryTree((int)(Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }
}
