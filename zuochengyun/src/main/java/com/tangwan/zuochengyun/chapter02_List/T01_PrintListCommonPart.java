/*
 * File Name:T01_PrintListCommonPart is created on 2020-08-03 15:21 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.zuochengyun.chapter02_List;

/**
 * @author Zhao Xiaoli
 * @Description : T01_PrintListCommonPart
 * @date 2020-08-03 15:21
 * @since JDK 1.8
 */
public class T01_PrintListCommonPart {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);

        Node node2 = new Node(5);
        node2.next = new Node(7);
        node2.next.next = new Node(8);
        node2.next.next.next = new Node(9);
        node2.next.next.next.next = new Node(10);

        Node common = new Node(11);
        common.next = new Node(12);
        common.next.next = new Node(13);

        node.next.next.next.next.next = common;
        node2.next.next.next.next.next = common;

        printCommonPart(node, node2);
    }

    private static void printCommonPart(Node node1, Node node2) {
        Node common = null;
        while (node1 != null && node2 != null) {
            if (node1 == node2) {
                // 因为两个链表只要相交，后面的Node肯定都一致，所以只要打印后面的所有数据即可
                common = node1;
                break;
            } else if (node1.value < node2.value) {
                node1 = node1.next;
            } else {
                node2 = node2.next;
            }
        }

        while (common != null) {
            System.out.println(common.value);
            common = common.next;
        }
    }

}
