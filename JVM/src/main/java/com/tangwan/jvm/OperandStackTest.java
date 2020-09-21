package com.tangwan.jvm;

public class OperandStackTest {

    private int i = 9;

    public int sum(int a, int b) {
        System.out.println(this.i);
        return a + b;
    }

    public void f() {
        int i = 8;
        long l = 100000000L;

        System.out.println(i);
        System.out.println(l);
        Object hollis = new Object();
        synchronized (hollis) {
            System.out.println(hollis);
        }
    }

    public String helloStr(String name) {
        String str = "abc" + "def";
        str = name + "hello";

        System.out.println("hello " + name);
        return str;
    }
}