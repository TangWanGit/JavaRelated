package com.tangwan.jvm.c12_loadclass;

import java.util.HashMap;
import java.util.Map;

public class Blog {
    public static String s = "static string";
    public static final int I = 100;

    //基本数据类型
    private int a = 10;
    private int b = 20;
    //基本数据类型数组
    private int[] aArray = new int[10];
    //引用数据类型数组
    private Integer[] bArray = new Integer[10];
    //普通对象
    private Map<String, Object> mapObj = new HashMap<>(16);

    public static void main(String[] args) {
        Blog blog = new Blog();
        int[] typeArray = new int[10];
        Integer[] objArray = new Integer[10];
        while (true) {
        }
    }
}