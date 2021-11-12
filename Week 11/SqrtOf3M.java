package com.rit.assignment11.A;

/**
 * Filename - SqrtOf3M.java
 * 
 * Problem Statement - Calculate sqrt(2) using BigDecimal objects and multiple 
 *                     threads. 
 *                              
 * @author Abhijeet Mulik      - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 * 
 */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class SqrtOf3M {
    public static void main(String[] args) throws InterruptedException {
        int noOfThreads = Integer.parseInt(args[0]);     
        int limit = Integer.parseInt(args[1]);           
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < noOfThreads; i++){
            int start = (limit / noOfThreads) * i;
            int end = (limit / noOfThreads)*(i+1);
            Thread sqrtCalc = new Thread(new Sqrt2(start, end));
            threads.add(sqrtCalc);
        }
        for (Thread thread: threads) {
            thread.start();
            thread.join();
        }

        System.out.println("Result: " + 
        (Sqrt2.OneByRootTwo.multiply(BigDecimal.valueOf(2))).
                                        setScale(33, RoundingMode.CEILING));
    }
}
