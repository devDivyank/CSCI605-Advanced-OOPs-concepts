package com.rit.hw.assignment7A;

/**
 * Filename - LivingThing.java
 *
 * LivingThing class used to create LivingThing objects to store in a BST.
 *
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */

public class LivingThing {
    int age;
    String name = "LivingThing";

    LivingThing(){
        this.age = 0;
    }

    LivingThing(int age){
        this.age = age;
    }

    @Override
    public String toString() {
        return "{" + name + ", age=" + age + '}';
    }
}
