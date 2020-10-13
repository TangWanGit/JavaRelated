/*
 * File Name:DBUtils is created on 2020-10-13 12:30 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Zhao Xiaoli
 * @Description : DBUtils
 * @date 2020-10-13 12:30
 * @since JDK 1.8
 */
public class DBUtils {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager
                .getConnection("jdbc:mysql://localhost:3306/demo?characterEncoding=UTF-8", "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
