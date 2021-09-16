package com.rit.csci.assignment3.c;

/**
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 *
 * Filename - ManyQuestions.java
 *
 * Problem Statement - re-writing this code in such a way that it is elegant
 */

import java.util.Random;
import java.lang.Math;

public class ManyQuestions {
    public static String sumUpFromLowerToLarger(int a, int b)	{
        String rValue = "";
        if ( a < b )	{
            for (int index = a; index < b; index ++ )
                rValue += a + ": " + index + " ";
        } else {
            for (int index = b; index < a; index ++ )
                rValue += b + ": " + index + " ";
        }
        return rValue;
    }
    /**
     * @param a - first number
     * @param b - second number
     *
     * A better version of the given function 'SumUpFromLowerToLarger' above
     */
    public static String sumUpFromLowerToLargerBetter(int a, int b)	{
        String rValue = "";
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        for (int i = min; i < max; i++){
            rValue += min + ": " + i + " ";
        }
        return rValue;
    }

    public static String printBitRepresentation(int a)	{
        String rValue = "";
        for ( int index = 31; index >= 0; index -- )	{
            if ( (  ( a )  & ( 1 << index ) ) == ( 1 << index ) )
                rValue += "1";
            else
                rValue += "0";
        }
        return rValue;
    }
    /**
     * @param aInt - number to represent in bits
     * @return     - bit representation of input
     *
     * A better version of the given function 'printBitRepresentation' above
     */
    public static String printBitRepresentationBetter(int aInt)	{
        String rValue = "";
        for ( int index = 31; index >= 0; index -- )	{
            rValue += (( aInt )  & ( 1 << index ) ) == ( 1 << index ) ?
            		   "1" : "0";
        }
        return rValue;
    }

    public static int findMaximum(int a, int b, int c, int d)	{
        int rValue;
        int maxAndB = 0;
        int maxCndD = 0;
        if ( a > b )
            maxAndB = a;
        else
            maxAndB = b;
        if ( c > d )
            maxCndD = a;
        else
            maxCndD = b;
        if ( maxAndB > maxCndD )
            rValue = maxAndB;
        else
            rValue = maxCndD;
        return rValue;
    }
    /**
     * @param a - one of the numbers to be compared
     * @param b - one of the numbers to be compared
     * @param c - one of the numbers to be compared
     * @param d - one of the numbers to be compared
     * @return  - Max value from all inputs
     *
     * A better version of the given function 'findMaximum' above
     */
    public static int findMaximumBetter(int a, int b, int c, int d) {
        return (a > b) ? a : (b > c && b > d) ? b : (c > d) ? c : d;
    }


    public static String reverseString(String original) {                           
        String rValue = "";
        for ( int index = original.length(); index > 0; index -- )
            rValue += original.substring(index -1, index);
        return rValue;
    }

    public static String reverseStringBetter(String original) {
        String rValue = "";
        for ( int index = original.length() - 1; index >= 0; index -- )
            rValue += original.charAt(index);
        return rValue;
    }

    public static String reverseStringR(String original) {
        if ( original.length() == 1 ) {
            return original;
        }
        return reverseStringR(original.substring(1)) + original.substring(0, 1);
    }
    /**
     * @param original - string to be reversed
     * @return         - reversed input string
     *
     * A better version of the given function 'reverseString' above
     */
    public static String reverseStringRBetter(String original) {                        
        return original = (original.length() == 1) ? original
                : reverseStringR(original.substring(1)) + 
                  original.substring(0, 1);
    }

    /**
     * @param args - default main argument
     *
     * The main method calls the above methods for testing them
     */
    public static void main( String[] args ) {
        int a = 5;
        int b = 1;
        int c = 2;
        int d = 1;
        String aString = "abcde";
        long foundThisOneMissing;
        int soManyBits = 31;
        boolean useConstantAlgorithm = false;

        if ( args.length > 0 )
            soManyBits = Integer.parseInt(args[0]);
        useConstantAlgorithm = ( args.length > 1 );
        useConstantAlgorithm = true;

        long thisNumberIsMissing = (long)new Random().nextInt((int)Math.pow(2, 
        		                    soManyBits));
        thisNumberIsMissing += ( thisNumberIsMissing == 0 ) ? 1 : 0;

        System.out.println("printFromLowerToLarger(" + a + "," + b + ") = " + 
                           sumUpFromLowerToLarger(a, b ) );
        System.out.println("sumUpFromLowerToLargerBetter(" + a + "," + b + ")"
        		+ " = " + sumUpFromLowerToLargerBetter(a, b ) );
        System.out.println("printBitRepresentation(" + a + "):		" +
        		printBitRepresentation(a));
        System.out.println("printBitRepresentationBetter(" + a + "):	" + 
        		printBitRepresentationBetter(a));
        System.out.println("findMaximum(" + a + ", " + b + ", " + c + ", " + 
        		d + " ) = " + findMaximum(a, b, c, d ) );
        System.out.println("findMaximumBetter(" + a + ", " + b + ", " + c +
        		", " + d + " ) = " + findMaximumBetter(a, b, c, d ) );
        System.out.println("reverseString(" + aString + ") =	" + 
        		reverseString(aString) );
        System.out.println("reverseStringR(" + aString + ") =	" + 
        		reverseStringR(aString) );
        System.out.println("reverseStringBetter(" + aString + ") =	" + 
        		reverseStringBetter(aString) );
    }
}