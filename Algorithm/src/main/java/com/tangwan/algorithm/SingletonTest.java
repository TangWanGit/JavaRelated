/*
 * File Name:SingletonTest is created on 2020-05-22 09:08 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.algorithm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author Zhao Xiaoli
 * @Description : SingletonTest
 * @date 2020-05-22 09:08
 * @since JDK 1.8
 */
public class SingletonTest {
    public static void main(String[] args) {
        long monthAgo = LocalDateTime.ofInstant(Instant.ofEpochSecond(1585559351), ZoneOffset.UTC).minusMonths(1).toInstant(ZoneOffset.UTC)
            .getEpochSecond();
        System.out.println(monthAgo);

        //useIO();
    }

    public static void userReflect() {
        try {
            Singleton singleton1 = Singleton.getSingleton();
            Class<Singleton> singleClass = (Class<Singleton>)Class.forName("com.tangwan.algorithm.Singleton");
            Constructor<Singleton> construcotor = singleClass.getDeclaredConstructor(null);
            construcotor.setAccessible(true);

            Singleton singleton = construcotor.newInstance();

            System.out.println(singleton);
            System.out.println(singleton == singleton1);
            System.out.println(singleton1);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void useIO() {
        Singleton singleton = Singleton.getSingleton();
        try {
            ObjectOutputStream oos = null;
            oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
            oos.writeObject(singleton);

            File file = new File("tempFile");

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            Singleton singletonBySerialize = (Singleton)ois.readObject();

            System.out.println(singleton);
            System.out.println(singletonBySerialize);
            System.out.println(singleton == singletonBySerialize);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
