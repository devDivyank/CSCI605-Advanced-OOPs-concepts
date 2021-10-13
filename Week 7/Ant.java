package com.rit.hw.assignment7A;

/**
 * Filename - Ant.java
 *
 * Ant class used to create Ant objects to store in a BST.
 *
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */

public class Ant extends LivingThing{

    Ant(int age){
        this.age = age;
        this.name = "Ant";
    }

    @Override
    public String toString() {
        return "{" + name + ", age=" + age + '}';
    }
}
