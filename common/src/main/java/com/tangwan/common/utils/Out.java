package com.tangwan.common.utils;

public class Out {
    private static int a;
    private int b;

    public void test(final int c) {
        final int d = 1;
        class Inner {
            public void print() {
                System.out.println(c);
            }
        }
    }
}