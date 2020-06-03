/*
 * File Name:T07_LowestAncestor is created on 2020-06-03 10:51 by Zhao Xiaoli
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

/**
 * @author Zhao Xiaoli
 * @Description : T07_LowestAncestor
 * 最低的祖先
 * 两个节点，最近相交的祖先
 * @date 2020-06-03 10:51
 * @since JDK 1.8
 */
public class T07_LowestAncestor extends T00_ListBase {
    public static void main(String[] args) {
        logarithmicDetector(t -> {
            BinaryTree o1 = pickRandomOne(t);
            BinaryTree o2 = pickRandomOne(t);
            return lowestAncestor1(t, o1, o2) == lowestAncestor2(t, o1, o2);
        });
    }

    private static BinaryTree lowestAncestor1(BinaryTree head, BinaryTree o1, BinaryTree o2) {
        if (head == null) {
            return null;
        }
        Map<BinaryTree, BinaryTree> parentMap = getParentMap(head);

        Set<BinaryTree> o1Set = new HashSet<>();
        BinaryTree cur = o1;
        o1Set.add(cur);
        while (parentMap.get(cur) != null) {
            cur = parentMap.get(cur);
            o1Set.add(cur);
        }

        cur = o2;
        while (!o1Set.contains(cur)) {
            cur = parentMap.get(cur);
        }
        return cur;
    }

    private static BinaryTree pickRandomOne(BinaryTree head) {
        if (head == null) {
            return null;
        }

        List<BinaryTree> arr = getPrelist(head);

        Integer random = (int)Math.random() * arr.size();
        return arr.get(random);
    }

    private static BinaryTree lowestAncestor2(BinaryTree head, BinaryTree o1, BinaryTree o2) {
        if (head == null) {
            return null;
        }
        return process(head, o1, o2).ans;
    }

    private static Info process(BinaryTree X, BinaryTree o1, BinaryTree o2) {
        if (X == null) {
            return new Info(null, false, false);
        }

        Info leftInfo = process(X.left, o1, o2);
        Info rightInfo = process(X.right, o1, o2);

        boolean findO1 = X == o1 || leftInfo.findO1 || rightInfo.findO1;
        boolean findO2 = X == o2 || leftInfo.findO2 || rightInfo.findO2;

        BinaryTree ans = null;
        if (leftInfo.ans != null) {
            ans = leftInfo.ans;
        } else if (rightInfo.ans != null) {
            ans = rightInfo.ans;
        } else {
            if (findO1 && findO2) {
                ans = X;
            }
        }
        return new Info(ans, findO1, findO2);
    }

    public static class Info {
        public BinaryTree ans;
        public boolean findO1;
        public boolean findO2;

        public Info(BinaryTree ans, boolean findO1, boolean findO2) {
            this.ans = ans;
            this.findO1 = findO1;
            this.findO2 = findO2;
        }
    }

}
