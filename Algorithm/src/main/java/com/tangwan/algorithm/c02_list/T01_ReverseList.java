/*
 * File Name:T01_ReverseList is created on 2020-05-11 09:40 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c02_list;

import java.util.ArrayList;

/**
 * @author Zhao Xiaoli
 * @Description : T01_ReverseList
 * 反转链表
 * @date 2020-05-11 09:40
 * @since JDK 1.8
 */
public class T01_ReverseList {

    public static void main(String[] args) {
        int testTime = 100_000;
        int len = 50;
        int value = 100;
        for (int i = 0; i < testTime; i++) {
            Node node1 = generateRandomLinkedList(len, value);
            Node reverse1 = reverseLinkedList(node1);
            Node back1 = testReverseLinkedList(reverse1);
            if (!checkLinkedListEqual(node1, back1)) {
                System.out.println("oops! linkedList");
                break;
            }

            DoubleNode node2 = generateRandomDoubleList(len, value);
            DoubleNode reverse2 = reverseDoubleList(node2);
            DoubleNode back2 = testReverseDoubleList(reverse2);
            if (!checkDoubleListEqual(node2, back2)) {
                System.out.println("oops! doubleList");
                break;
            }
        }

        System.out.println("finish");
    }

    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;

        /**
         * 单链表逆序
         * 反转过程：
         * 链表结构：1->2->3
         * 第一轮：pre=null,head=1
         *        next = head.next = 2
         *        head.next = pre = null
         *        pre = head = 1
         *        head = next = 2
         * 此时链表结构为： null<-1 2->3
         *
         * 第二轮：pre=1,head=2
         *        next = head.next = 3
         *        head.next = pre = 1
         *        pre = head = 2
         *        head = next = 3
         * 此时链表结构为： null<-1<-2 3
         *
         * 第三轮：pre=2,head=3
         *        next = head.next = null
         *        head.next = pre = 2
         *        pre = head = 3
         *        head = next = null
         * 此时链表结构为： null<-1<-2<-3
         *
         * 输出pre，此时pre的结构为：3->2->1->null
         *
         */
        while (head != null) {
            // 保留next节点
            next = head.next;
            // 将当前节点的next指向pre
            head.next = pre;
            // pre移到head节点
            pre = head;
            // head节点移到next
            head = next;
        }

        return pre;
    }

    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;

        while (head != null) {
            next = head.next;
            // head的next指向pre
            head.next = pre;
            // head的last指向next
            head.last = next;

            pre = head;
            head = next;
        }
        return pre;
    }

    public static Node testReverseLinkedList(Node head) {
        if (head == null) {
            return null;
        }
        ArrayList<Node> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        list.get(0).next = null;
        int N = list.size();
        for (int i = 1; i < N; i++) {
            list.get(i).next = list.get(i - 1);
        }
        return list.get(N - 1);
    }

    public static DoubleNode testReverseDoubleList(DoubleNode head) {
        if (head == null) {
            return null;
        }

        ArrayList<DoubleNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        list.get(0).next = null;
        DoubleNode pre = list.get(0);
        int N = list.size();
        for (int i = 1; i < N; i++) {
            DoubleNode cur = list.get(i);
            cur.last = null;
            cur.next = pre;
            pre.last = cur;
            pre = cur;
        }

        return list.get(N - 1);
    }

    public static Node generateRandomLinkedList(int len, int value) {
        int size = (int)(Math.random() * (len + 1));
        if (size == 0) {
            return null;
        }

        size--;
        Node head = new Node((int)(Math.random() * (value + 1)));
        Node pre = head;
        while (size != 0) {
            Node cur = new Node((int)(Math.random() * (value + 1)));
            pre.next = cur;
            pre = cur;
            size--;
        }
        return head;
    }

    public static DoubleNode generateRandomDoubleList(int len, int value) {

        int size = (int)(Math.random() * (len + 1));
        if (size == 0) {
            return null;
        }

        size--;
        DoubleNode head = new DoubleNode((int)(Math.random() * (value + 1)));
        DoubleNode pre = head;
        while (size != 0) {
            DoubleNode cur = new DoubleNode((int)(Math.random() * (value + 1)));
            pre.next = cur;
            cur.last = pre;

            pre = cur;
            size--;
        }
        return head;
    }

    /**
     * 要求无环，有环别用这个函数
     *
     * @param hea1
     * @param head2
     *
     * @return
     */
    public static boolean checkLinkedListEqual(Node hea1, Node head2) {
        while (hea1 != null && head2 != null) {
            if (hea1.value != head2.value) {
                return false;
            }
            hea1 = hea1.next;
            head2 = head2.next;
        }
        return hea1 == null && head2 == null;
    }

    /**
     * 要求无环，有环别用这个函数
     *
     * @param hea1
     * @param head2
     *
     * @return
     */
    public static boolean checkDoubleListEqual(DoubleNode hea1, DoubleNode head2) {
        boolean null1 = hea1 == null;
        boolean null2 = head2 == null;
        if (null1 && null2) {
            return true;
        }
        if (null1 ^ null2) {
            return false;
        }
        if (hea1.last != null || head2.last != null) {
            return false;
        }

        DoubleNode tail1 = null;
        DoubleNode tail2 = null;

        while (hea1 != null && head2 != null) {
            if (hea1.value != head2.value) {
                return false;
            }
            tail1 = hea1;
            tail2 = head2;
            hea1 = hea1.next;
            head2 = head2.next;
        }
        if (hea1 != null || head2 != null) {
            return false;
        }

        while (tail1 != null && tail2 != null) {
            if (tail1.value != tail2.value) {
                return false;
            }
            tail1 = tail1.last;
            tail2 = tail2.last;
        }
        return tail1 == null && tail2 == null;
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode next;
        public DoubleNode last;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

}
