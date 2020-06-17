/*
 * File Name:T03_TopologySort is created on 2020-06-16 16:59 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c10_dynamic_programming_0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Zhao Xiaoli
 * @Description : T03_TopologySort
 * 拓扑排序
 * @date 2020-06-16 16:59
 * @since JDK 1.8
 */
public class T03_TopologySort {
    public static void main(String[] args) {
        Graph graph = GraphGenerator.buildGraph();
        List<Node> nodes = sortedTopology(graph);
        printNode(nodes);
    }

    public static List<Node> sortedTopology(Graph graph) {
        // key：某一个node
        // value：剩余的入度
        HashMap<Node, Integer> inMap = new HashMap<>();
        // 剩余入度为0的点，才能进这个队列
        Queue<Node> zeroInQueue = new LinkedList<>();

        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }

        List<Node> result = new ArrayList<>(inMap.size());

        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }

    public static void printNode(List<Node> nodes) {
        for (Node node : nodes) {
            System.out.print(node.value + " ");
        }
        System.out.println();
    }

}
