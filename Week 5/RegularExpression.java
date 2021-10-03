package com.practice.abhijeet;
/**
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 *
 * Filename - PatterMatcher.java
 *
 * Problem Statement - creating patterns which will match a particular set of words
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RegularExpression {
    public static void main(String[] args) throws FileNotFoundException {
        // if no commandline argument is given input is taken from user
        if (args.length == 0){
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the string to test: ");
            String inputLine = sc.next();
            // PatternMatcher object is created, which runs the check on the input
            PatternMatcher myString = new PatternMatcher(inputLine);
            myString.runCheck();
            sc.close();
        } else {
            // if commandline argument is given (delimiter & file name)
            File file = new File(args[3]);
            Scanner sc = new Scanner(file);
            sc.useDelimiter(args[1]);
            // loops through the strings in file input
            System.out.println("_____________________________________\n");
            while (sc.hasNext()){
                String inputWord = sc.next();
                if (inputWord.length() > 1){
                    System.out.println("Input: " + inputWord);
                }
                // PatternMatcher object is created, which runs the check on the input
                PatternMatcher myString = new PatternMatcher(inputWord);
                myString.runCheck();
                System.out.println("___________________________________\n");
            }
            sc.close();
        }
    }
}
