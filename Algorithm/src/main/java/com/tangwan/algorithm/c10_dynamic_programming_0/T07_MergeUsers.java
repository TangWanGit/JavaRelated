/*
 * File Name:T07_MergeUsers is created on 2020-06-18 17:45 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm.c10_dynamic_programming_0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Zhao Xiaoli
 * @Description : T07_MergeUsers
 * @date 2020-06-18 17:45
 * @since JDK 1.8
 */
public class T07_MergeUsers {
    public static void main(String[] args) {
        //(1,10,13) (2,10,37) (400,500,37)
        List<User> users = new ArrayList<>();
        users.add(new User("1", "10", "13"));
        users.add(new User("2", "10", "37"));
        users.add(new User("400", "500", "37"));
        int i = mergeUsers(users);
        System.out.println(i);
    }

    public static int mergeUsers(List<User> users) {
        T01_UnionFind.UnionSet<User> unionFind = new T01_UnionFind.UnionSet<>(users);
        HashMap<String, User> mapA = new HashMap<>();
        HashMap<String, User> mapB = new HashMap<>();
        HashMap<String, User> mapC = new HashMap<>();
        for (User user : users) {
            if (mapA.containsKey(user.a)) {
                unionFind.union(user, mapA.get(user.a));
            } else {
                mapA.put(user.a, user);
            }

            if (mapB.containsKey(user.b)) {
                unionFind.union(user, mapB.get(user.b));
            } else {
                mapB.put(user.b, user);
            }
            if (mapC.containsKey(user.c)) {
                unionFind.union(user, mapC.get(user.c));
            } else {
                mapC.put(user.c, user);
            }
        }
        // 向并查集询问，合并之后，还有多少个集合？
        return unionFind.getSetNum();
    }

    public static class User {
        String a, b, c;

        public User(String a, String b, String c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
