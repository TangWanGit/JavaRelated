/*
 * File Name:T04_SerializeAndReconstructTree is created on 2020-05-29 10:50 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c07_binary_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Zhao Xiaoli
 * @Description : T04_SerializeAndReconstructTree
 * <p>
 * 二叉树的序列化和反序列化
 * @date 2020-05-29 10:50
 * @since JDK 1.8
 */
public class T04_SerializeAndReconstructTree {

    /*
     * 二叉树可以通过先序、后序或者按层遍历的方式序列化和反序列化，
     * 以下代码全部实现了。
     * 但是，二叉树无法通过中序遍历的方式实现序列化和反序列化
     * 因为不同的两棵树，可能得到同样的中序序列，即便补了空位置也可能一样。
     * 比如如下两棵树
     *         __2
     *        /
     *       1
     *       和
     *       1__
     *          \
     *           2
     * 补足空位置的中序遍历结果都是{ null, 1, null, 2, null}
     *
     * */
    public static void main(String[] args) {
        int maxLevel = 3;
        int maxValue = 100;
        int testTimes = 1000_000;
        System.out.println("test begin");
        for (int i = 0; i < testTimes; i++) {
            BinaryTree head = generateRandomBST(maxLevel, maxValue);
            Queue<String> pre = preSerial(head);
            Queue<String> pos = posSerial(head);
            Queue<String> level = levelSerial(head);

            BinaryTree preBuild = buildByPreQueue(pre);
            BinaryTree posBuild = buildByPosQueue(pos);
            BinaryTree levelBuild = buildByLevelQueue(level);

            if (!isSameValueStructure(preBuild, posBuild) || !isSameValueStructure(posBuild, levelBuild)) {
                printTree(head);
                printTree(preBuild);
                printTree(posBuild);
                printTree(levelBuild);



                System.out.println("Oops");

                break;
            }
        }
        System.out.println("test finish");
    }

    private static void printTree(BinaryTree head) {
        System.out.println("Binary Tree: ");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    private static void printInOrder(BinaryTree head, int height, String to, int len) {
        if (head == null) {
            return;
        }

        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    private static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
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

    private static Queue<String> preSerial(BinaryTree head) {
        Queue<String> ans = new LinkedList<>();
        pres(head, ans);
        return ans;
    }

    private static void pres(BinaryTree head, Queue<String> ans) {
        if (head == null) {
            ans.add(null);
        } else {
            ans.add(String.valueOf(head.value));
            pres(head.left, ans);
            pres(head.right, ans);
        }
    }

    private static Queue<String> posSerial(BinaryTree head) {
        Queue<String> ans = new LinkedList<>();
        poss(head, ans);
        return ans;
    }

    private static void poss(BinaryTree head, Queue<String> ans) {
        if (head == null) {
            ans.add(null);
        } else {
            poss(head.left, ans);
            poss(head.right, ans);
            ans.add(String.valueOf(head.value));
        }
    }

    private static Queue<String> levelSerial(BinaryTree head) {
        Queue<String> ans = new LinkedList<>();
        if (head == null) {
            ans.add(null);
        } else {
            ans.add(String.valueOf(head.value));

            Queue<BinaryTree> queue = new LinkedList<>();
            queue.add(head);

            while (!queue.isEmpty()) {
                head = queue.poll();

                if (head.left != null) {
                    ans.add(String.valueOf(head.left.value));
                    queue.add(head.left);
                } else {
                    ans.add(null);
                }
                if (head.right != null) {
                    ans.add(String.valueOf(head.right.value));
                    queue.add(head.right);
                } else {
                    ans.add(null);
                }

            }
        }
        return ans;
    }

    private static BinaryTree buildByPreQueue(Queue<String> preList) {
        if (preList == null || preList.size() == 0) {
            return null;
        }
        return preb(preList);
    }

    private static BinaryTree preb(Queue<String> preList) {
        BinaryTree head = generateBinaryTree(preList.poll());
        if (head == null) {
            return null;
        }

        head.left = preb(preList);
        head.right = preb(preList);
        return head;
    }

    private static BinaryTree buildByPosQueue(Queue<String> posList) {
        if (posList == null || posList.size() == 0) {
            return null;
        }
        // 左右中  ->  stack(中右左)
        Stack<String> stack = new Stack<>();
        while (!posList.isEmpty()) {
            stack.push(posList.poll());
        }
        return posb(stack);
    }

    private static BinaryTree posb(Stack<String> stack) {
        String value = stack.pop();
        if (value == null) {
            return null;
        }
        BinaryTree head = new BinaryTree(Integer.valueOf(value));
        head.right = posb(stack);
        head.left = posb(stack);
        return head;
    }

    private static BinaryTree buildByLevelQueue(Queue<String> levelList) {
        if (levelList == null || levelList.size() == 0) {
            return null;
        }
        BinaryTree head = generateBinaryTree(levelList.poll());
        Queue<BinaryTree> queue = new LinkedList<>();
        if (head != null) {
            queue.add(head);
        }
        BinaryTree bt = null;
        while (!queue.isEmpty()) {
            bt = queue.poll();
            bt.left = generateBinaryTree(levelList.poll());
            bt.right = generateBinaryTree(levelList.poll());
            if (bt.left != null) {
                queue.add(bt.left);
            }
            if (bt.right != null) {
                queue.add(bt.right);
            }
        }
        return head;
    }

    private static BinaryTree generateBinaryTree(String value) {
        return value == null ? null : new BinaryTree(Integer.valueOf(value));
    }

    private static boolean isSameValueStructure(BinaryTree bt1, BinaryTree bt2) {
        if (bt1 == null && bt2 == null) {
            return true;
        }
        if (bt1 == null || bt2 == null) {
            return false;
        }
        if (bt1.value != bt2.value) {
            return false;
        }
        return isSameValueStructure(bt1.left, bt2.left) && isSameValueStructure(bt1.right, bt2.right);
    }

}
