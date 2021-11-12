package com.rit.assignment11B;

/**
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 *
 * Filename - Number.java
 *
 * Problem Statement - Program to identify all numbers between 1 and 1000
 *                     who have the following property - repeated sum of
 *                     squares of the digits of a number give the final value 1,
 *                     using threads.
 *
 */

public class Number {
    public static void main(String[] args) throws InterruptedException {
        if (args[2].equals("local")) {
            Local.start(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        } else if (args[2].equals("global")){
            Global.start(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        } else {
            System.out.println("Incorrect arguments!!");
        }
    }
}