package com.tangwan.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * @author 黄俊
 * @Date 2017年10月7日
 * JDBC:这是用来干嘛的？answer：使用jdbc提供一个一对多的关系。
 * 数据库：SQL SERVER,ORCALE,MYSQL,DB2，MARIDB,DERBY....
 * 设计思路：
 * Connection接口：提供连接数据库的操作
 * 根据OOP的原则：接口隔离
 * Statement,PrepareStatement,ResultSet
 * http://www.baidu.com/xx/xx/xx
 */
public class JDBC_Demo {

    public static void main(String[] args) throws Exception {
        /**
         * 一、反射是什么？就是为了在运行时能够获取到本身类信息的一种技术
         * 还可以动态加载类（在运行一个程序的时候，允许动态的加载类进入JVM）
         * 反射机制它的核心点在哪？？？？-》》》》自然而然想到一个对象：在类加载进入JVM并且已经经过加载，验证，准备，解析
         * 初始化<clinit>后的Class对象（这个对象我讲过代表了一个类本身）。那么拿到这个对象 我就能获取到类的所有信息。
         * 那么怎么拿？1.对象.getClass()2.类名.class
         * 3.4. TYPE = (Class<Integer>) Class.getPrimitiveClass("int");
         *
         *
         * 二、JAVA的类加载机制
         * 怎样保证加载的类的安全性？
         * 你不可能 让危害计算机的代码 也就是类 进入JVM导致用户信息泄露或者信息被删除。。。。恶意操作行为的发生。
         * 所以 java 引入了 JAVA的加载机制：采用双亲委派机制和JAVA安全沙箱来保证JVM的安全
         * 双亲委派：Bootstrap Classloader,Ext Classloader,System Classloader,用户自定义
         */
        Class.forName("com.mysql.jdbc.Driver");//这个方法加载一个类返回一个类的实例对象：class
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        System.out.println(connection);

        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet rs = metaData.getTables("test", null, null, null);
        while (rs.next()) {
            // 下标从1开始，这样会报错
            //String s0 = rs.getString(0);
            String s1 = rs.getString(1);
            String s2 = rs.getString(2);
            String s3 = rs.getString(3);
            
        }
    }

}