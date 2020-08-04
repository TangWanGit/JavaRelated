/*
 * File Name:T02_RemoveLastKthNode is created on 2020-08-03 15:59 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.zuochengyun.chapter02_List;

/**
 * @author Zhao Xiaoli
 * @Description : T02_RemoveLastKthNode
 * @date 2020-08-03 15:59
 * @since JDK 1.8
 */
public class T02_RemoveLastKthNode {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);

        Node result = removeLastKthNode(node, 3);
        T00_Util.print(result);

        DoubleNode doubleNode = new DoubleNode(1);
        doubleNode.next = new DoubleNode(3);
        doubleNode.next.last = doubleNode;
        doubleNode.next.next = new DoubleNode(4);
        doubleNode.next.next.last = doubleNode.next;
        doubleNode.next.next.next = new DoubleNode(7);
        doubleNode.next.next.next.last = doubleNode.next.next;
        DoubleNode removeLastKthNode = removeLastKthNode(doubleNode, 1);
        T00_Util.print(removeLastKthNode);
    }

    private static Node removeLastKthNode(Node head, int k) {
        if (head == null || k < 1) {
            return head;
        }

        Node cur = head;

        while (cur != null) {
            k--;
            cur = cur.next;
        }

        if (k == 0) {
            return head.next;
        }
        if (k < 0) {
            cur = head;
            while (++k < 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    private static DoubleNode removeLastKthNode(DoubleNode head, int k) {
        if (head == null || k < 1) {
            return head;
        }

        DoubleNode cur = head;

        while (cur != null) {
            k--;
            cur = cur.next;
        }

        if (k == 0) {
            DoubleNode next = head.next;
            next.last = null;
            return next;
        }
        if (k < 0) {
            cur = head;
            while (++k < 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            if (cur.next != null) {
                cur.next.last = cur;
            }
        }
        return head;
    }
}
