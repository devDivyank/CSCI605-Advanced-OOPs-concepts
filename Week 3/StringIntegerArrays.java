package com.rit.csci.assignment3.b;

/**
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 *
 * Filename - StringIntegerArrays.java
 *
 * Problem Statement - a program which performs the required operations I to IX
 *                     using the classes String, Integer, Arrays, Pattern and
 *                     a char array.
 */

import java.util.Arrays;

public class StringIntegerArrays {
    public static void main(String[] args){
        // inputs given(based on the commandline arguments, if any)
    	String aString,bString,cString,dString,eString,fString,gString,hString,iString;
    	
        if ( args.length == 1 ) {
             aString = "123425" + "25";
             bString = "12342525";
             cString = "5";
             dString = "25" + "2" + cString;
             eString = "a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p,"
            		+ " q, r, s, t, u, v, w, x, y, z";
             fString = "A, B, C, D, E, F, G, H, I, J, K, *, M, N, O, P,"
            		+ " Q, R, S, T, U, V, W, X, Y, Z";
             gString = aString + ( bString + cString ) + dString;
             hString = "2525" +  "+" + "2525";
             iString = "2525+2525";
        } else {
             aString = "12342" + new String("" + 5) +  "25";
             bString = "12342525";
             cString = "5";
             dString = "" + "25" + "" + "2" + cString;
             eString = "b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r,"
            		+ " s, t, u, v, w, x, y, z";
             fString = "B, C, D, E, F, G, H, I, J, K, *, M, N, O, P, Q, R,"
            		+ " S, T, U, V, W, X, Y, Z";
             gString = ( ( aString + bString )  + "" + 5 ) + dString;
             hString = "2525" +  "+" + "2525";
             iString = "25" + ( 2 + 5 ) + "+2525";
        }

        // I. Determine if aString and bString are equal.
        System.out.print("I. ");
        System.out.println(aString.equals(bString));

        // II. Determine if aString and bString are identical.
        System.out.print("II. ");
        System.out.println(aString == bString);

        // III. Determine if aString and dString are equal.
        System.out.print("III. ");
        System.out.println(aString.equals(dString));

        // IV. Determine if aString and dString are identical.
        System.out.print("IV. ");
        System.out.println(aString == dString);

        // V. Determine if hString and iString are equal.
        System.out.print("V. ");
        System.out.println(hString.equals(iString));

        // VI. Determine if hString and iString are identical.
        System.out.print("VI. ");
        System.out.println(hString == iString);

        // VII. Extract from dString the string starting at the number defined
        //      at the first position in aString and ending at the number 
        //      defined at the second position in aString. 
        char[] aArray = aString.toCharArray();
        int start = Integer.parseInt(String.valueOf(aArray[0]));
        int end = Integer.parseInt(String.valueOf(aArray[1]));
        System.out.println("VII. " + dString.substring(start, end+1));

        // VIII. Extract the character of eString which is at the position of *
        //       in fString. 
        System.out.print("VIII. ");
        System.out.println(eString.substring(fString.indexOf('*'), 
        		           fString.indexOf('*') + 1));

        // IX. Sort the digits in bString, and extract out of dString between
        //     the 3 and 4 lowest number. In this example the numbers would be 
        //     2 and 3.
        int [] bArraySorted = new int[bString.length()];
        for (int i = 0; i < bString.length(); i++) {
            bArraySorted[i] = Integer.valueOf(bString.substring(i, i+1));
        }
        Arrays.sort(bArraySorted);
        System.out.print("IX. ");
        System.out.println(dString.
        		substring(Integer.parseInt(String.valueOf(bArraySorted[3])),
                Integer.parseInt(String.valueOf(bArraySorted[4]))));
    }
}