/*
 * File Name:T03_SmallerEqualBigger is created on 2020-05-26 18:48 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c06_list_interview;

/**
 * @author Zhao Xiaoli
 * @Description : T03_SmallerEqualBigger
 * 将一个array分成三个部分，参数为pivot 轴
 * 小于pivot    等于pivot   大于pivot
 * @date 2020-05-26 18:48
 * @since JDK 1.8
 */
public class T03_SmallerEqualBigger {
    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);

        printLinkedList(head1);

        head1 = listPartition1(head1, 5);
        //head1 = listPartition2(head1, 5);
        printLinkedList(head1);

    }

    public static Node listPartition1(Node head, int pivot) {
        if (head == null) {
            return head;
        }

        Node cur = head;
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }

        Node[] nodeArr = new Node[i];
        i = 0;
        cur = head;
        for (i = 0; i != nodeArr.length; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodeArr, pivot);
        for (i = 1; i != nodeArr.length; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }

    private static void arrPartition(Node[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index != big) {
            if (nodeArr[index].value < pivot) {
                swap(nodeArr, ++small, index++);
            } else if (nodeArr[index].value == pivot) {
                index++;
            } else {
                swap(nodeArr, --big, index);
            }
        }
    }

    private static void swap(Node[] nodeArr, int i, int j) {
        Node tmp = nodeArr[i];
        nodeArr[i] = nodeArr[j];
        nodeArr[j] = tmp;
    }

    public static Node listPartition2(Node head, int pivot) {
        // small head
        Node sH = null;
        // small tail
        Node sT = null;
        // equal head
        Node eH = null;
        // equal tail
        Node eT = null;
        // big head
        Node mH = null;
        // big tail
        Node mT = null;

        // save next node
        Node next = null;
        // every node distributed to three lists
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (mH == null) {

                    mH = head;
                    mT = head;
                } else {
                    mT.next = head;
                    mT = head;
                }
            }

            head = next;
        }
        // 小于区域的尾巴，连等于区域的头，等于区域的尾巴连大于区域的头
        // 如果有小于区域
        if (sT != null) {
            sT.next = eH;
            // 下一步，谁去连大于区域的头，谁就变成eT
            eT = eT == null ? sT : eT;
        }
        // 上面的if，不管跑了没有，et
        // all reconnect
        // 如果小于区域和等于区域，不是都没有
        if (eT != null) {
            eT.next = mH;
        }
        return sH != null ? sH : (eH != null ? eH : mH);
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
