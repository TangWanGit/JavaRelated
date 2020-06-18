/*
 * File Name:T05_Prim is created on 2020-06-18 11:28 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c10_dynamic_programming_0;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Zhao Xiaoli
 * @Description : T05_Prim
 * @date 2020-06-18 11:28
 * @since JDK 1.8
 */
public class T05_Prim {
    public static void main(String[] args) {
        Set<Edge> prim = prim(GraphGenerator.buildGraph());
        printEdge(prim);

        int minPrim = prim(GraphGenerator.graph());
        int count = 0;
        for (Edge edge : prim) {
            count += edge.weight;
        }

        System.out.println(minPrim == count);
        System.out.println(minPrim);
        System.out.println(count);
    }

    public static Set<Edge> prim(Graph graph) {
        // 解锁的边进入小根堆
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        // 哪些点被解锁出来了
        HashSet<Node> nodeSet = new HashSet<>();
        // 依次挑选的的边在result里
        HashSet<Edge> result = new HashSet<>();
        // 随便挑了一个点
        for (Node cur : graph.nodes.values()) {
            // cur 是开始点
            if (!nodeSet.contains(cur)) {
                nodeSet.add(cur);
                // 由一个点，解锁所有相连的边
                for (Edge edge : cur.edges) {
                    priorityQueue.add(edge);
                }

                while (!priorityQueue.isEmpty()) {
                    // 弹出解锁的边中，最小的边
                    Edge edge = priorityQueue.poll();
                    // 可能的一个新的点
                    Node toNode = edge.to;
                    // 不含有的时候，就是新的点
                    if (!nodeSet.contains(toNode)) {
                        nodeSet.add(toNode);
                        result.add(edge);

                        for (Edge nextEdge : toNode.edges) {
                            priorityQueue.add(nextEdge);
                        }
                    }
                }
            }
        }
        return result;
    }

    // 请保证graph是连通图
    // graph[i][j]表示点i到点j的距离，如果是系统最大值代表无路
    // 返回值是最小连通图的路径之和
    public static int prim(int[][] graph) {
        int size = graph.length;
        int[] distance = new int[size];
        boolean[] visit = new boolean[size];
        visit[0] = true;
        for (int i = 0; i < size; i++) {
            distance[i] = graph[0][i];
        }
        int sum = 0;
        for (int i = 1; i < size; i++) {
            int minPath = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = 0; j < size; j++) {
                if (!visit[j] && distance[j] < minPath) {
                    minPath = distance[j];
                    minIndex = j;
                }
            }
            if (minIndex == -1) {
                return sum;
            }
            visit[minIndex] = true;
            sum += minPath;
            for (int j = 0; j < size; j++) {
                if (!visit[j] && distance[j] > graph[minIndex][j]) {
                    distance[j] = graph[minIndex][j];
                }
            }
        }
        return sum;
    }

    public static class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }

    }

    private static void printEdge(Set<Edge> edges) {
        Iterator<Edge> iterator = edges.iterator();
        while (iterator.hasNext()) {
            Edge next = iterator.next();
            System.out.println(next.weight + " " + next.from.value + " " + next.to.value);
        }
    }

}
