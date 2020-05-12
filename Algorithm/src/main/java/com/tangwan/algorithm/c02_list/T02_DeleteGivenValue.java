/*
 * File Name:T02_DeleteGivenValue is created on 2020-05-12 10:30 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c02_list;

/**
 * @author Zhao Xiaoli
 * @Description : T02_DeleteGivenValue
 * @date 2020-05-12 10:30
 * @since JDK 1.8
 */
public class T02_DeleteGivenValue {

    public static void main(String[] args) {
        int maxSize = 10;
        int maxValue = 100;
        Node head = generateRandNode(maxSize, maxValue);
        printNode(head);

        while (head != null) {
            head = removeValue(head, head.value);
            printNode(head);
        }
    }

    public static void printNode(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static Node generateRandNode(int maxSize, int maxValue) {
        if (maxSize == 0) {
            return null;
        }

        int N = (int)(Math.random() * (maxSize + 1));
        Node head = new Node((int)((maxValue + 1) * Math.random()) - (int)(Math.random() * maxValue));
        Node pre = head;
        N--;
        while (N > 0) {
            Node cur = new Node((int)((maxValue + 1) * Math.random()) - (int)(Math.random() * maxValue));
            pre.next = cur;
            pre = cur;
            N--;
        }
        return head;
    }

    public static Node removeValue(Node head, int num) {
        // 直接跳过从开始所有需要删的位置，因为需要保留head
        while (head != null) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }

        // head来到 第一个不需要删的位置
        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
