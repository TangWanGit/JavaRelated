/*
 * File Name:ReflectDemo is created on 2020-10-20 23:01 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.jdbc;

import java.lang.reflect.Field;

/**
 * @author Zhao Xiaoli
 * @Description : ReflectDemo
 * @date 2020-10-20 23:01
 * @since JDK 1.8
 */
public class ReflectDemo {

    static class Student {
        private int sno = 123;
        private String name = "init-name";
        private int age = 10;

        @Override
        public String toString() {
            return "Student{" + "sno=" + sno + ", name='" + name + '\'' + ", age=" + age + '}';
        }

        public int getSno() {
            return sno;
        }

        public void setSno(int sno) {
            this.sno = sno;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<Student> clazz = Student.class;
        // 通过反射是不是就可以为所欲为
        // eg：可以拿到private修饰的变量
        // clazz.getFields(): 获取非private的属性
        Field[] fields = clazz.getFields();

        //以前创建都是用new对象，那么有了反射之后，就不用new了
        /**
         * 使用这个方法必须提供一个午餐构造器，因为它就是调用无参构造器工作的
         * new Student()
         * class.newInstance()
         * 和上面一样，只不过必须给出一个无参构造器。
         * 如果要假如参数来创建对象那么这种方式不可取，得换另外一种方式
         */
        Student student = clazz.newInstance();
        Field declaredField = clazz.getDeclaredField("name");
        declaredField.setAccessible(true);

        /**
         * 这个obj参数，也就是第一个参数：
         * 1. 如果是静态变量，可以不用对象
         * 2. 如果不是静态变量，是final修饰的变量，则无法更改
         * 3. 如果是实例变量，则需要传入实例对象才能赋值
         */
        declaredField.set(student, "other name");

        System.out.println(student);
    }
}
