/*
 * File Name:T02_BFSandDFS is created on 2020-06-16 16:37 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c10_dynamic_programming_0;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Zhao Xiaoli
 * @Description : T02_BFSandDFS
 * @date 2020-06-16 16:37
 * @since JDK 1.8
 */
public class T02_BFSandDFS {
    public static void main(String[] args) {
        Node head = new Node(1);

        head.addNext(new Node(2));

        Node next = new Node(3);
        head.addNext(next);

        head.addNext(new Node(4));
        head.addNext(new Node(5));

        next.addNext(new Node(6));
        next.addNext(new Node(7));

        dfs(head);
        bfs(head);
    }

    /**
     * 深度优先遍历
     * Depth First Search
     *
     * @param node
     */
    public static void dfs(Node node) {
        if (node == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();

        stack.add(node);
        set.add(node);

        System.out.print(node.value + " ");
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.print(next.value + " ");
                    break;
                }
            }
        }
        System.out.println();
    }

    public static void bfs(Node node) {
        if (node == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.value + " ");

            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
        System.out.println();
    }

}
