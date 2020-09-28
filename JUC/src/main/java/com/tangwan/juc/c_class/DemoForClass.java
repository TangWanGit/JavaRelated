package com.tangwan.juc.c_class;

import java.util.ArrayList;

public class DemoForClass {
    private static int i = 100;
    private int j = 101;

    public void show() {
        new A() {
            @Override
            public void print() {
                System.out.println(i);
                System.out.println(j);
            }
        }.print();
    }

    public static void main(String[] args) {
        new DemoForClass().show();

        ArrayList<Number> arrayList = new ArrayList<>();
        arrayList.add(1);

        ArrayList<?> allList = arrayList;
        // 会报错
        //allList.add(124);
        Object o = allList.get(0);
        System.out.println(o);

        ArrayList<? super Number> superList = arrayList;
        superList.add(124);
        Object object = superList.get(0);
        System.out.println(object);

        ArrayList<? extends Number> extendsList = arrayList;
        // 会报错
        //extendsList.add(123);
        Number number = extendsList.get(0);
        System.out.println(number);

    }
}

class A {
    public void print() {
        System.out.println("print a");
    }
}