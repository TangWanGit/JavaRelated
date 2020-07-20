/*
 * File Name:T08_GetMaxTree is created on 2020-07-20 14:02 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.zuochengyun.chapter01_StackAndQueue;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Zhao Xiaoli
 * @Description : T08_GetMaxTree
 * 构造数组的MaxTree
 * @date 2020-07-20 14:02
 * @since JDK 1.8
 */
public class T08_GetMaxTree {

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        Node maxTree = getMaxTree(arr);
        print(maxTree);
    }

    public static Node getMaxTree(int[] arr) {
        Node[] nArr = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nArr[i] = new Node(arr[i]);
        }

        Stack<Node> stack = new Stack<>();
        HashMap<Node, Node> lBigMap = new HashMap<>();
        HashMap<Node, Node> rBigMap = new HashMap<>();
        for (int i = 0; i != nArr.length; i++) {
            Node curNode = nArr[i];
            while ((!stack.isEmpty()) && stack.peek().value < curNode.value) {
                popStackSetMap(stack, lBigMap);
            }
            stack.push(curNode);
        }

        while (!stack.isEmpty()) {
            popStackSetMap(stack, lBigMap);
        }

        for (int i = nArr.length - 1; i != -1; i--) {
            Node curNode = nArr[i];
            while (((!stack.isEmpty()) && stack.peek().value < curNode.value)) {
                popStackSetMap(stack, rBigMap);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(stack, rBigMap);
        }

        Node head = null;
        for (int i = 0; i < nArr.length; i++) {
            Node curNode = nArr[i];
            Node left = lBigMap.get(curNode);
            Node right = rBigMap.get(curNode);
            if (left == null && right == null) {
                head = curNode;
            } else if (left == null) {
                if (right.left == null) {
                    right.left = curNode;
                } else {
                    right.right = curNode;
                }
            } else if (right == null) {
                if (left.left == null) {
                    left.left = curNode;
                } else {
                    left.right = curNode;
                }
            } else {
                Node parent = left.value < right.value ? left : right;
                if (parent.left == null) {
                    parent.left = curNode;
                } else {
                    parent.right = curNode;
                }
            }
        }
        return head;
    }

    private static void popStackSetMap(Stack<Node> stack, HashMap<Node, Node> map) {
        Node popNode = stack.pop();
        if (stack.isEmpty()) {
            map.put(popNode, null);
        } else {
            map.put(popNode, stack.peek());
        }
    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private static void print(Node node) {
        if (node != null) {
            System.out.println(node.value + " ");
            print(node.left);
            print(node.right);
        }
    }
}
