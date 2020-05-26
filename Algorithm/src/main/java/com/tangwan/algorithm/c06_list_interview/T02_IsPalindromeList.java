/*
 * File Name:T02_IsPalindromeList is created on 2020-05-25 11:45 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c06_list_interview;

import java.util.Stack;

/**
 * @author Zhao Xiaoli
 * @Description : T02_IsPalindromeList
 * 是否回文结构
 * @date 2020-05-25 11:45
 * @since JDK 1.8
 */
public class T02_IsPalindromeList {
    public static void main(String[] args) {
        Node head = null;
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        System.out.println("==========================");

        head = new Node(1);
        test(head);

        head = new Node(1);
        head.next = new Node(2);
        test(head);

        head = new Node(1);
        head.next = new Node(1);
        test(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        test(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        test(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        test(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        test(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        test(head);
    }

    private static void test(Node head) {
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("==========================");
    }
    // need n extra space

    /**
     * 使用栈，先将数据push进栈，然后再pop出来的时候和head相比
     * need n extra space
     *
     * @param head
     *
     * @return
     */
    public static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            if (cur.value != stack.pop().value) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    /**
     * 先找到中位，然后从中位向stack中push，然后再用pop和head相比
     * need n/2 extra space
     *
     * @param head
     *
     * @return
     */
    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Node slow = head;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Stack<Node> stack = new Stack<>();
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }

        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * need O(1) extra space
     *
     * @param head
     *
     * @return
     */
    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        // n1 mid

        n2 = n1.next;
        n1.next = null;

        Node n3 = null;
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }

        n3 = n1;
        n2 = head;
        boolean res = true;
        while (n1 != null && n2 != null) {
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        n1 = n3.next;
        n3.next = null;
        while (n1 != null) {

            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }

    public static void printLinkedList(Node node) {
        System.out.println("Linked list: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
