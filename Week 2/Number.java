package com.rit.assignment2;

/**
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 *
 * Filename - Number.java
 *
 * Problem Statement - Program to identify all numbers between 1 and 1000
 *                     who have the following property - repeated sum of
 *                     squares of the digits of a number give the final value 1.
 *
 *                     FOR EXAMPLE - The number 19 has this property.
 *                     1^2 + 9^2 = 1 + 81 = 82;
 *                     8^2 + 2^2 = 64 + 4 = 68;
 *                     6^2 + 8 ^ 2 = 36 + 64 = 100;
 *                     1^2 + 0^2 + 0^2 = 1;
 */

import java.util.Arrays;

public class Number {

    /**
     * @param args - default main argument
     *
     * The main method calls the method 'checkForProperty' for finding and
     * displaying the numbers, if any, that have the desired property and
     * prints out the digits which make it a perfect number.
     */
    public static void main(String[] args){

        // calls function to check all numbers between 1 and 1000
        checkForProperty(1000);
    }

    /**
     * @param num - the number being checked for the desired property
     *
     * This method checks if a number is a perfect number and also prints
     * all the digits that make it a perfect number.
     */

    public static void checkForANumber(int num){

        // string that is printed if 'num' is a perfect number
        String fullString = num + ": ";
        // array to store all the intermediate sums we get
        int[] numsSeen = {};
        // to store the current sum of squares of the digits
        int squaredDigitsSum = 0;

        while (num != 1){
            squaredDigitsSum = sumOfSquaredDigits(num);
            // if sum is not seen before, it is added to the 'numsSeen' array
            // and the array is then sorted
            if (Arrays.binarySearch(numsSeen, squaredDigitsSum) < 0){
                numsSeen = Arrays.copyOf(numsSeen, numsSeen.length+1);
                numsSeen[numsSeen.length-1] = squaredDigitsSum;
                Arrays.sort(numsSeen);
            }
            // if sum is already in the array, 'num' is not a perfect number
            // and thus, the function is stopped
            else if (Arrays.binarySearch(numsSeen, squaredDigitsSum) >= 0){
                return;
            }
            // string representation of the current number and its squared
            // digits being added is appended to the main string
            fullString += getStringRepr(num) + " | ";
            // 'num' is reassigned to the value obtained from
            // squaring and adding the digits of 'num'
            num = squaredDigitsSum;
        }
        System.out.println(fullString);
    }

    /**
     * @param limit - limit upto which the numbers are being checked
     *                starting with 1
     *
     * This method calls 'checkForANumber' method on and checks 
     * all values between 1 and 1000 (inclusive) for the desired property.
     */
    public static void checkForProperty(int limit){
        for (int i=2; i<limit; i++){
            checkForANumber(i);
        }
    }

    /**
     * @param num - number whose digits are being squared and added
     *
     * This method returns the sum of square of the digits of 'num'.
     */
    public static Integer sumOfSquaredDigits(int num){
        int ans = 0;
        while (num > 0){
            // digit is assigned the last digit of 'num' as its value
            // and squared and added to 'ans'
            int digit = num % 10;
            ans += digit * digit;
            // last digit of 'num' is dropped
            num /= 10;
        }
        // sum of square of the digits is returned
        return ans;
    }

    /**
     * @param num - number whose digits are being squared and added
     *
     * This method returns a mathematical expression for the digits 
     * of a number being squared and added, as a string.
     */
    public static String getStringRepr(int num){
        int rhs = sumOfSquaredDigits(num);
        String mystr = "";
        while (num > 0){
            int digit = num % 10;
            mystr = "+ " + digit + "^2 " + mystr;
            num /= 10;
        }
        return mystr.substring(2) + "= " + rhs;
    }


}