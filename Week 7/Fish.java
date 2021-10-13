package com.rit.hw.assignment7A;

/**
 * Filename - Fish.java
 *
 * Fish class used to create Fish objects to store in a BST.
 *
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */
public class Fish extends LivingThing{

    Fish(int age){
        this.age = age;
        this.name = "Fish";
    }

    @Override
    public String toString() {
        return "{" + name + ", age=" + age + '}';
    }
}
