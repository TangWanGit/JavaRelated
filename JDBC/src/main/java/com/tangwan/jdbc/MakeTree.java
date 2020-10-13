/*
 * File Name:MakeTree is created on 2020-10-13 12:35 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jdbc;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhao Xiaoli
 * @Description : MakeTree
 * @date 2020-10-13 12:35
 * @since JDK 1.8
 */
public class MakeTree {
    public static void main(String[] args) throws IOException {
        makeDir(0, "/Users/sunshine/Documents/test");
    }

    public static void makeDir(int pid, String path) throws IOException {
        List<Node> listNode = getListNode(pid);
        for (Node node : listNode) {
            File file = new File(path + File.separator + node.name);
            if (!file.exists()) {
                file.mkdirs();
            }
            makeDir(node.id, file.getCanonicalPath());
        }
    }

    public static List<Node> getListNode(int pid) {
        ResultSet rs = getRS("select * from tree where pid = ?", pid);
        List<Node> nodes = new ArrayList<>(16);
        try {
            while (rs.next()) {
                nodes.add(new Node(rs.getInt(1), rs.getInt(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nodes;
    }

    public static ResultSet getRS(String sql, Object... params) {
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static class Node {
        private int id;
        private int pid;
        private String name;

        public Node(int id, int pid, String name) {
            this.id = id;
            this.pid = pid;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Node{" + "id=" + id + ", pid=" + pid + ", name='" + name + '\'' + '}';
        }
    }
}
