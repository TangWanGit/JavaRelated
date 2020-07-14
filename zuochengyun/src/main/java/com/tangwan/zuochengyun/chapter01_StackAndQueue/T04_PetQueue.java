/*
 * File Name:T04_PetQueue is created on 2020-07-14 16:16 by Zhao Xiaoli
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */
package com.tangwan.zuochengyun.chapter01_StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Zhao Xiaoli
 * @Description : T04_PetQueue
 * @date 2020-07-14 16:16
 * @since JDK 1.8
 */
public class T04_PetQueue {
    public static void main(String[] args) {
        PetQueue petQueue = new PetQueue();
        petQueue.add(new Cat());
        petQueue.add(new Dog());
        petQueue.add(new Cat());
        petQueue.add(new Dog());
        petQueue.add(new Cat());
        petQueue.add(new Dog());

        Dog dog = petQueue.pollDog();
        System.out.println("poll dog : " + dog);

        Cat cat = petQueue.pollCat();
        System.out.println("poll cat : " + cat);

        while (!petQueue.isCatEmpty()) {
            System.out.println("poll cat : " + petQueue.pollCat());
        }

        while (!petQueue.isDogEmpty()) {
            System.out.println("poll dog : " + petQueue.pollDog());
        }

        petQueue.add(new Cat());
        petQueue.add(new Dog());

        while (!petQueue.isEmpty()) {
            System.out.println("poll pet : " + petQueue.pollAll());
        }
    }

    public static class PetQueue {
        private Queue<PetEnterQueue> dogQ;
        private Queue<PetEnterQueue> catQ;
        private long count;

        public PetQueue() {
            dogQ = new LinkedList<>();
            catQ = new LinkedList<>();
            count = 0;
        }

        public void add(Pet pet) {
            if (isCat(pet)) {
                catQ.add(new PetEnterQueue(pet, this.count++));
            } else if (isDog(pet)) {
                dogQ.add(new PetEnterQueue(pet, this.count++));
            } else {
                throw new RuntimeException("err,not dog or cat");
            }
        }

        public Pet pollAll() {
            if (!dogQ.isEmpty() && !catQ.isEmpty()) {
                if (dogQ.peek().count > catQ.peek().count) {
                    return dogQ.poll().pet;
                } else {
                    return catQ.poll().pet;
                }
            } else if (!dogQ.isEmpty()) {
                return dogQ.poll().pet;
            } else if (!catQ.isEmpty()) {
                return catQ.poll().pet;
            } else {
                throw new RuntimeException("err,not dog or cat");
            }
        }

        public Cat pollCat() {
            if (catQ.isEmpty()) {
                throw new RuntimeException("Cat Queue is empty");
            }
            return (Cat)catQ.poll().pet;
        }

        public Dog pollDog() {
            if (dogQ.isEmpty()) {
                throw new RuntimeException("Dog Queue is empty");
            }
            return (Dog)dogQ.poll().pet;
        }

        public boolean isEmpty() {
            return isDogEmpty() && isCatEmpty();
        }

        public boolean isDogEmpty() {
            return dogQ.isEmpty();
        }

        public boolean isCatEmpty() {
            return catQ.isEmpty();
        }

        private boolean isCat(Pet pet) {
            return pet instanceof Cat;
        }

        private boolean isDog(Pet pet) {
            return pet instanceof Dog;
        }
    }

    public static class PetEnterQueue {
        private Pet pet;
        private long count;

        public PetEnterQueue(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }
    }

    public static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        @Override
        public String toString() {
            return "Pet{" + "type='" + type + '\'' + '}';
        }
    }

    public static class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }

    public static class Cat extends Pet {

        public Cat() {
            super("cat");
        }
    }
}
