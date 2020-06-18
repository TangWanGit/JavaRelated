/*
 * File Name:T04_Kruskal is created on 2020-06-17 11:51 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c10_dynamic_programming_0;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

/**
 * @author Zhao Xiaoli
 * @Description : T04_Kruskal
 * @date 2020-06-17 11:51
 * @since JDK 1.8
 */
public class T04_Kruskal {
    public static void main(String[] args) {
        Set<Edge> edges = kruskalMST(GraphGenerator.buildGraph());
        printEdge(edges);
    }

    public static Set<Edge> kruskalMST(Graph graph) {
        UnionFind unionFind = new UnionFind();
        unionFind.makeSet(graph.nodes.values());

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        // M 条边
        for (Edge edge : graph.edges) {
            // O(logM)
            priorityQueue.add(edge);
        }

        Set<Edge> result = new HashSet<>();
        // M 条边
        while (!priorityQueue.isEmpty()) {
            // O(logM)
            Edge cur = priorityQueue.poll();
            // O(1)
            if (!unionFind.isSameSet(cur.from, cur.to)) {
                result.add(cur);
                unionFind.union(cur.from, cur.to);
            }
        }
        return result;
    }

    public static class UnionFind {
        public HashMap<Node, Node> parentMap;
        public HashMap<Node, Integer> sizeMap;

        public UnionFind() {
            parentMap = new HashMap<>();
            sizeMap = new HashMap<>();
        }

        public void makeSet(Collection<Node> nodes) {
            parentMap.clear();
            sizeMap.clear();
            for (Node node : nodes) {
                parentMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public boolean isSameSet(Node from, Node to) {

            return findFather(from) == findFather(to);
        }

        private Node findFather(Node node) {
            Stack<Node> path = new Stack<>();
            while (node != parentMap.get(node)) {
                path.add(node);
                node = parentMap.get(node);
            }

            while (!path.isEmpty()) {
                parentMap.put(path.pop(), node);
            }
            return node;
        }

        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            Node aHead = findFather(a);
            Node bHead = findFather(b);
            if (aHead != bHead) {
                Integer aSize = sizeMap.get(aHead);
                Integer bSize = sizeMap.get(bHead);
                Node big = aSize > bSize ? aHead : bHead;
                Node small = big == aHead ? bHead : aHead;

                parentMap.put(small, big);
                sizeMap.put(big, aSize + bSize);
                sizeMap.remove(small);
            }
        }
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
