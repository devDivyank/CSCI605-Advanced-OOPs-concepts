package com.practice.abhijeet;
/**
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 *
 * Filename - PatterMatcher.java
 *
 * Problem Statement - PatternMatcher object runs all the pattern checks on a string
 */

import java.util.regex.Pattern;

public class PatternMatcher {
    String inputWord;

    // string to be checked
    public PatternMatcher(String input){
        this.inputWord = input;
    }

    // pattern = .. - a word which is two characters long
    public static boolean patternOne(String inputWord){
        return Pattern.matches("..", inputWord);
    }

    // pattern = ..+ - a word which is two or more characters long
    public static boolean patternTwo(String inputWord){
        return Pattern.matches("..+", inputWord);
    }

    // pattern = [^(aeiou)]*a[^(aeiou)]*e[^(aeiou)]*i[^(aeiou)]*o[^(aeiou)]*u[^(aeiou)]* -
    //                      a word with the vowels ’aeiou’ in order and each vowel can appear only once
    public static boolean patternThree(String inputWord){
        return Pattern.matches("[^(aeiou)]*a[^(aeiou)]*e[^(aeiou)]*i[^(aeiou)]*o[^(aeiou)]*u[^(aeiou)]*", inputWord);
    }

    // pattern = .*(ac/dc|AC/DC).* - includes ac/dc or AC/DC
    public static boolean patternFour(String inputWord){
        return Pattern.matches(".*(ac/dc|AC/DC).*", inputWord);
    }

    // pattern = [ac-gi-oq-z]+ - includes only lower case characters, but not the character ’h’, ’p’, and ’b’
    public static boolean patternFive(String inputWord){
        return Pattern.matches("[ac-gi-oq-z]+", inputWord);
    }

    // pattern = ^\\((one|uno|eins)\\)$ - starts with ’(’, followed by ’one’ or ’uno’, or ’eins’, followed by ’)’
    public static boolean patternSix(String inputWord) {
        return Pattern.matches("^\\((one|uno|eins)\\)$", inputWord);
    }

    // pattern = ^[Mm]oma$ - starts with ’M’ or ’m’ followed ’oma’
    public static boolean patternSeven(String inputWord) {
        return Pattern.matches("^[Mm]oma$", inputWord);
    }

    // pattern = ^\[(a-m|O-Z)\]$ - starts with ’[’, followed by ’a-m’ or ’O-Z’, followed by ’]’
    public static boolean patternEight(String inputWord){
        return Pattern.matches("^\\[(a-m|O-Z)\\]$", inputWord);
    }

    // pattern = ^a[1-3]{2}$ - starts with ’a’ followed by 2 digits in the range between 1 to 3 only
    public static boolean patternNine(String inputWord){
        return Pattern.matches("^a[1-3]{2}$", inputWord);
    }

    // pattern = ^a[0-9]+$ - starts with ’a’ followed by one digit or more digits
    public static boolean patternTen(String inputWord){
        return Pattern.matches("^a[0-9]+$", inputWord);
    }

    // pattern = ^[a-z]{2}[0-9]{3}$ - starts with 2 lower case characters’ followed by 3 digits
    public static boolean patternEleven(String inputWord){
        return Pattern.matches("^[a-z]{2}[0-9]{3}$", inputWord);
    }

    // runs all the above functions
    public void runCheck(){
        if (patternOne(this.inputWord)){
            System.out.println("This regular expression '..' matches the following input: " + this.inputWord +
                    "\nDescription: a word which is two characters long\n");
        }
        if (patternTwo(this.inputWord)){
            System.out.println("This regular expression '..+' matches the following input: " + this.inputWord +
                    "\nDescription: a word which is two or more characters long\n");
        }
        if (patternThree(this.inputWord)){
            System.out.println("This regular expression '[^(aeiou)]*a[^(aeiou)]*e[^(aeiou)]*i[^(aeiou)]*o[^(aeiou)]*u[^(aeiou)]*'" +
                                                            " matches the following input: " + this.inputWord +
                    "\nDescription: a word with the vowels ’aeiou’ in order and each vowel can appear only once\n");
        }
        if (patternFour(this.inputWord)){
            System.out.println("This regular expression '.*(ac/dc|AC/DC).*' matches the following input: " + this.inputWord +
                    "\nDescription: includes ac/dc or AC/DC\n");
        }
        if (patternFive(this.inputWord)){
            System.out.println("This regular expression '[ac-gi-oq-z]+' matches the following input: " + this.inputWord +
                    "\nDescription: includes only lower case characters, but not the character ’h’, ’p’, and ’b’\n");
        }
        if (patternSix(this.inputWord)){
            System.out.println("This regular expression '^\\((one|uno|eins)\\)$' matches the following input: " + this.inputWord +
                    "\nDescription: starts with ’(’, followed by ’one’ or ’uno’, or ’eins’, followed by ’)’\n");
        }
        if (patternSeven(this.inputWord)){
            System.out.println("This regular expression '^[Mm]oma$' matches the following input: " + this.inputWord +
                    "\nDescription: starts with ’M’ or ’m’ followed ’oma’\n");
        }
        if (patternEight(this.inputWord)){
            System.out.println("This regular expression '^\\[(a-m|O-Z)\\]$' matches the following input: " + this.inputWord +
                    "\nDescription: starts with ’[’, followed by ’a-m’ or ’O-Z’, followed by ’]’\n");
        }
        if (patternNine(this.inputWord)){
            System.out.println("This regular expression '^a[1-3]{2}$' matches the following input: " + this.inputWord +
                    "\nDescription: starts with ’a’ followed by 2 digits in the range between 1 to 3 only\n");
        }
        if (patternTen(this.inputWord)){
            System.out.println("This regular expression '^a[0-9]+$' matches the following input: " + this.inputWord +
                    "\nDescription: starts with ’a’ followed by one digit or more digits\n");
        }
        if (patternEleven(this.inputWord)){
            System.out.println("This regular expression '^[a-z]{2}[0-9]{3}$' matches the following input: " + this.inputWord +
                    "\nDescription: starts with 2 lower case characters’ followed by 3 digits\n");
        }
    }
}