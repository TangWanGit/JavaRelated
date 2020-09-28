package com.tangwan.juc.c0_basic;

public class DemoForClass {
    private static int i = 100;
    private int j = 101;

    public static void main(String[] args) {
        //java中的类的定义方式有哪几种？
        DemoForClass.StaticClass.print();

        /*
         * 普通定义
         * 静态内部类
         * 普通内部类
         * 匿名类
         */
        new DemoForClass().new NotStaticClass().print();
    }

    //静态内部类
    //都说了他是静态的内部类，那么从字面上来讲它是不是和静态的方法和属性一样
    //也就是可以通过类名.类名来使用，而且都说了他是内部类，所谓内部是啥意思？是不是
    //说这个类定义在一个类的内部。
    //内部类的好处：可以共享所在类的内部中的变量，而不用像访问普通类一样需要把
    //共享的参数传递过去
    static class StaticClass {
        public static void print() {
            System.out.println(i);
        }

        static {
            System.out.println("StaticClass");
        }
    }

    class NotStaticClass {
        public void print() {
            System.out.println(i);
            System.out.println(j);
        }
    }

}

//普通类
class NormalClass {
    public static void print(int i) {
        System.out.println(i);
    }

    static {
        System.out.println("NormalClass");
    }
}
