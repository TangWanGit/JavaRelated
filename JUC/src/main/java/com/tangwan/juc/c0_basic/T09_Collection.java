/*
 * File Name:T09_Collection is created on 2020-09-22 14:45 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.juc.c0_basic;

/**
 * @author Zhao Xiaoli
 * @Description : T09_Collection
 * @date 2020-09-22 14:45
 * @since JDK 1.8
 */
public class T09_Collection {
    public static void main(String[] args) {
        //ArrayList<Integer> list = new ArrayList<>();
        //for (int i = 0; i < 10; i++) {
        //    list.add(i);
        //}
        //
        //ArrayList<Integer> contains = new ArrayList<>();
        //contains.add(1);
        //contains.add(11);
        //
        //System.out.println(list.removeAll(contains));
        //
        //for (Integer integer : list) {
        //    System.out.println(integer);
        //}

        Node node1 = new Node();
        node1.value = 1;

        Node node2 = new Node();
        node2.value = 2;

        Node node3 = new Node();
        node3.value = 3;

        Node node4 = new Node();
        node4.value = 4;

        insert(node1);
        insert(node2);
        insert(node3);
        insert(node4);

        getAll();
    }

    static Node head = new Node();

    static void insert(Node node) {
        Node current = T09_Collection.head;
        Node pNode;
        while ((pNode = current.next) != null) {
            current = pNode;
        }
        current.next = node;
    }

    static void getAll() {
        Node current = T09_Collection.head;
        Node pNode;
        while ((pNode = current.next) != null) {
            System.out.println(pNode.value);
            current = pNode;
        }
    }
}

class Node {
    int value;
    Node next;

}
