package com.tangwan.jvm.c8_constant_pool;

public class DemoTest {
    String s = "abc";

    //int y; // 变量和值均在堆上

    //public static void main(String[] args) {
    //    int x = 1; // 变量和值分配在栈上
    //    String name = new String("cat"); // 数据在堆上，name变量的指针在栈上
    //    String address = "北京"; // 数据在常量池，属于堆空间，指针在栈上
    //    Integer price = 4; // 包装类型为引用类型，编译时会自动装拆箱，数据在堆上，指针在栈
    //}

    static class Fruit {
        static int x = 10;
        static BigWaterMelon bigWaterMelon_1 = new BigWaterMelon(x);

        int y = 20;
        BigWaterMelon bigWaterMelon_2 = new BigWaterMelon(y);

        @Override
        public String toString() {
            return "Fruit{" + "y=" + y + ", bigWaterMelon_2=" + bigWaterMelon_2 + '}';
        }
    }

    public static void main(String[] args) {
        Fruit fruit = new Fruit();
        System.out.println(fruit);

        //int z = 30;
        //BigWaterMelon bigWaterMelon_3 = new BigWaterMelon(z);

        new Thread() {
            @Override
            public void run() {
                int k = 100;
                setWeight(k);
            }

            void setWeight(int waterMelonWeight) {
                //fruit.bigWaterMelon_2.weight = waterMelonWeight;
                //System.out.println(fruit);
            }
        }.start();
    }

    static class BigWaterMelon {
        public BigWaterMelon(int weight) {
            this.weight = weight;
        }

        public int weight;

        @Override
        public String toString() {
            return "BigWaterMelon{" + "weight=" + weight + '}';
        }
    }
}