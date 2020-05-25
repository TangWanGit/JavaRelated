/*
 * File Name:T02_TrieTree is created on 2020-05-22 16:20 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c05_trie;

import java.util.HashMap;
import java.util.Optional;

/**
 * @author Zhao Xiaoli
 * @Description : T02_TrieTree
 * @date 2020-05-22 16:20
 * @since JDK 1.8
 */
public class T02_TrieTree {
    public static void main(String[] args) {
        int arrLen = 100;
        int strLen = 20;
        int testTimes = 100_000;
        for (int i = 0; i < testTimes; i++) {
            String[] arr = generateRandomStringArray(arrLen, strLen);
            Trie1 trie1 = new Trie1();
            Trie2 trie2 = new Trie2();
            Right right = new Right();

            for (int j = 0; j < arr.length; j++) {
                double decide = Math.random();
                if (decide < 0.25) {
                    trie1.insert(arr[j]);
                    trie2.insert(arr[j]);
                    right.insert(arr[j]);
                } else if (decide < 0.5) {
                    trie1.delete(arr[j]);
                    trie2.delete(arr[j]);
                    right.delete(arr[j]);
                } else if (decide < 0.75) {
                    int ans1 = trie1.search(arr[j]);
                    int ans2 = trie2.search(arr[j]);
                    int ans3 = right.search(arr[j]);
                    if (ans1 != ans2 || ans2 != ans3) {
                        System.out.printf("search Oops %s %s %s %s\n", arr[j], ans1, ans2, ans3);
                    }
                } else {
                    int ans1 = trie1.prefixNumber(arr[j]);
                    int ans2 = trie2.prefixNumber(arr[j]);
                    int ans3 = right.prefixNumber(arr[j]);
                    if (ans1 != ans2 || ans2 != ans3) {
                        System.out.printf("prefixNumber Oops %s %s %s %s\n", arr[j], ans1, ans2, ans3);
                    }
                }
            }
        }
        System.out.println("finish");
    }

    public static class Node1 {
        public int pass;
        public int end;
        public Node1[] nexts;

        public Node1() {
            pass = 0;
            end = 0;
            // 0   a
            // 1   b
            // 2   c
            //....
            // 25   z
            // nexts[i] == null i方向的路不存在
            // nexts[i] != null i方向的路存在
            nexts = new Node1[26];
        }
    }

    public static class Trie1 {
        private Node1 root;

        public Trie1() {
            root = new Node1();
        }

        public void insert(String word) {
            if (word == null || "".equals(word)) {
                return;
            }

            char[] chars = word.toCharArray();
            Node1 node = root;
            node.pass++;

            int path;
            for (int i = 0; i < chars.length; i++) {
                path = chars[i] - 'a';
                // 如果该path不存在，则新创建
                if (node.nexts[path] == null) {
                    node.nexts[path] = new Node1();
                }
                node = node.nexts[path];
                // 经过的次数++
                node.pass++;
            }

            node.end++;
        }

        public void delete(String word) {
            if (search(word) != 0) {
                char[] chs = word.toCharArray();
                Node1 node = root;
                node.pass--;

                int path = 0;
                for (int i = 0; i < chs.length; i++) {
                    path = chs[i] - 'a';
                    // 如果这个字符是最后一个，则将该path置为null
                    if (--node.nexts[path].pass == 0) {
                        node.nexts[path] = null;
                        return;
                    }
                    node = node.nexts[path];
                }
                node.end--;
            }
        }

        private int search(String word) {
            if (word == null) {
                return 0;
            }

            char[] chs = word.toCharArray();
            Node1 node = this.root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }

            return node.end;
        }

        // 所有加入的字符串中，有几个是以pre这个字符串作为前缀的
        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chs = pre.toCharArray();
            Node1 node = this.root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }

            return node.pass;
        }
    }

    public static class Node2 {
        public int pass;
        public int end;
        public HashMap<Integer, Node2> nexts;

        public Node2() {
            pass = 0;
            end = 0;
            nexts = new HashMap<>();
        }
    }

    public static class Trie2 {
        private Node2 root;

        public Trie2() {
            root = new Node2();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }

            char[] chars = word.toCharArray();
            Node2 node = this.root;
            node.pass++;

            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (!node.nexts.containsKey(index)) {
                    node.nexts.put(index, new Node2());
                }
                node = node.nexts.get(index);
                node.pass++;
            }
            node.end++;
        }

        public void delete(String word) {
            if (search(word) == 0) {
                return;
            }

            char[] chars = word.toCharArray();
            Node2 node = root;
            node.pass--;

            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (--node.nexts.get(index).pass == 0) {
                    node.nexts.remove(index);
                    return;
                }
                node = node.nexts.get(index);
            }
            node.end--;
        }

        public int search(String word) {
            if (word == null) {
                return 0;
            }

            char[] chars = word.toCharArray();
            Node2 node = root;
            int index = 0;

            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (!node.nexts.containsKey(index)) {
                    return 0;
                }
                node = node.nexts.get(index);
            }
            return node.end;
        }

        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }

            char[] chars = pre.toCharArray();
            Node2 node = root;
            int index = 0;

            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (!node.nexts.containsKey(index)) {
                    return 0;
                }
                node = node.nexts.get(index);
            }
            return node.pass;
        }
    }

    public static class Right {
        private HashMap<String, Integer> box;

        public Right() {
            box = new HashMap<>();
        }

        public void insert(String word) {
            if (box.containsKey(word)) {
                box.put(word, box.get(word) + 1);
            } else {
                box.put(word, 1);
            }
        }

        public void delete(String word) {
            if (box.containsKey(word)) {

                if (box.get(word) == 1) {
                    box.remove(word);
                } else {
                    box.put(word, box.get(word) - 1);
                }
            }
        }

        public int search(String word) {
            Integer count = box.get(word);
            return Optional.ofNullable(count).orElse(0);
        }

        public int prefixNumber(String pre) {
            int count = 0;
            for (String cur : box.keySet()) {
                if (cur.startsWith(pre)) {
                    count += box.get(cur);
                }
            }
            return count;
        }
    }

    public static String generateRandomString(int strLen) {
        char[] ans = new char[(int)(Math.random() * strLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            int value = (int)(Math.random() * 26);
            ans[i] = (char)(97 + value);
        }
        return String.valueOf(ans);
    }

    public static String[] generateRandomStringArray(int arrLen, int strLen) {
        String[] ans = new String[(int)(Math.random() * arrLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = generateRandomString(strLen);
        }
        return ans;
    }
}
