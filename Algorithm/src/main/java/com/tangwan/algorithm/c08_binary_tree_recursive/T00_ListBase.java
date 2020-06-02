/*
 * File Name:T00_ListBase is created on 2020-06-02 16:44 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c08_binary_tree_recursive;

import java.util.function.Function;

import com.tangwan.algorithm.c07_binary_tree.BinaryTree;

/**
 * @author Zhao Xiaoli
 * @Description : T00_ListBase
 * @date 2020-06-02 16:44
 * @since JDK 1.8
 */
public class T00_ListBase {

    public static void logarithmicDetector(Function<BinaryTree, Boolean> function) {
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 1000_000;
        System.out.println("test begin");

        for (int i = 0; i < testTimes; i++) {
            BinaryTree binaryTree = generateRandomTree(maxLevel, maxValue);
            Boolean result = function.apply(binaryTree);
            if (!result) {
                System.out.println("Oops");
                break;
            }
        }

        System.out.println("test end");
    }

    public static BinaryTree generateRandomTree(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    public static BinaryTree generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        BinaryTree head = new BinaryTree((int)(Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }
}
