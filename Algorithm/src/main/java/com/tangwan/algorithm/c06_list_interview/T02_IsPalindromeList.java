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
        if (head == null || head.next == null || head.next.next == null) {
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
     * @param head
     * @return
     */
    public static boolean isPalindrome3(Node head) {
        return true;
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
