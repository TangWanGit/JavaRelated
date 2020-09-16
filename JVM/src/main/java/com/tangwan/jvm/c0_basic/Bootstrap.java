package com.tangwan.jvm.c0_basic;

public class Bootstrap {

    public static void main(String[] args) {
        String name = "Louis";
        greeting(name);
    }

    public static void greeting(String name) {
        System.out.println("Hello," + name);
    }
}
	
