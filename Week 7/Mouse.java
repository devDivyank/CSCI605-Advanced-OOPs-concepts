package com.rit.hw.assignment7A;
/**
 * Filename - Mouse.java
 *
 * Mouse class used to create Mouse objects to store in a BST.
 *
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */
public class Mouse extends LivingThing{

    Mouse(int age){
        this.age = age;
        this.name = "Mouse";
    }

    @Override
    public String toString() {
        return "{" + name + ", age=" + age + '}';
    }
}
