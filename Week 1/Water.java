/**
 *
 * Filename - Water.java
 *
 * Problem Statement - program to find out if an empty bucket can be filled
 *                     completely using all the water of some buckets in a given
 *                     set of buckets.
 *
 * @author Abhijeet Mulik      - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */

import java.util.Arrays;

public class Water {

    /**
     * @param args - default main argument
     *
     * The main method calls the subsequent methods for finding and displaying
     * the combination, if any, of buckets that can be used to fill the empty 
     * bucket perfectly.
     */
    public static void main(String[] args){

        int[] bucketsGiven = {1,1,2,4,5,6};
        int bucketToFill = 6;

        System.out.println("Bucket to fill: " + bucketToFill+"L");
        /* checks if the total volume of water available is enough to fill 
         * the empty bucket */
        if ( ! enoughWater(bucketsGiven, bucketToFill)){
            System.out.println("Not Possible!");
            return;
        }


        // function to find the power set is called
        int[][] allCombinations = {};
        int[] currentComb = {};
        int[][] powerSet = subsets(bucketsGiven, 0, currentComb, allCombinations);

        // all the combinations that can be used to fill the empty bucket
        // (sum of combination = volume of empty bucket)
        int[][] validCombs = validCombinations(powerSet, bucketToFill);

        /* if command line argument is provided, the smallest valid combination
         (minimum buckets) is printed else the largest valid combination 
         (maximum buckets) is printed */
        if (args.length > 0){
            getMinBuckets(validCombs);
        }
        else{
            getMaxBuckets(validCombs);
        }
    }

    /**
     * @param bucketsGiven     - set of available filled buckets.
     * @param index            - starting position for the iteration.
     * @param currentComb      - the combination obtained during the current 
     *                           iteration.
     * @param allCombinations  - used to store all the combinations of the 
     *                           buckets i.e. power set.
     *
     * This method finds all the possible combinations and returns the power 
     * set of the buckets available.
     */
    public static int[][] subsets(int[] bucketsGiven, int index, 
    		                      int[] currentComb, int[][] allCombinations){

        // add the current combination to the power set
        allCombinations = Arrays.copyOf(allCombinations,
        		                        allCombinations.length+1);
        allCombinations[allCombinations.length-1] = currentComb;

        // loops from 'index' position to the end of bucketsGiven array
        for (int i = index; i < bucketsGiven.length; i++){
        	
            /* now we will simulate both, adding the ith bucket to the current 
        	combination and skipping it. Next statement adds ith bucket to the
        	current combination */
        	
            currentComb = Arrays.copyOf(currentComb, currentComb.length+1);
            currentComb[currentComb.length-1] = bucketsGiven[i];
            // simulates both, adding and skipping, the next bucket in the array
            allCombinations = subsets(bucketsGiven, i+1, currentComb,
            		                  allCombinations);
            // removes the ith bucket from the current combination
            currentComb = Arrays.copyOf(currentComb, currentComb.length-1);

        }
        // returns an array of all the combinations i.e. power set
        return allCombinations;
    }

    /**
     * @param bucketsGiven     - set of available filled buckets.
     * @param bucketToFill     - volume of empty bucket
     *
     * This method checks if the total volume of water available is
     * enough to fill the empty bucket.
     */
    public static boolean enoughWater(int[] bucketsGiven, int bucketToFill){
        int sumOfBuckets = 0;
        for (int i:bucketsGiven){
            sumOfBuckets += i;
        }
        if (sumOfBuckets < bucketToFill){
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * @param powerSet         - all possible combinations of the buckets given
     * @param bucketToFill     - volume of empty bucket
     *
     * This method  returns all combinations from the power set that
     * fill up the empty bucket perfectly.
     */
    public static int[][] validCombinations(int[][] powerSet, int bucketToFill){
        int[][] validCombs = {};
        for (int i = 0; i < powerSet.length; i++){
            int combSum = 0;
            for (int val: powerSet[i]){
                combSum += val;
            }
            if (combSum == bucketToFill){
                validCombs = Arrays.copyOf(validCombs, validCombs.length+1);
                validCombs[validCombs.length-1] = powerSet[i];
            }
        }
        return validCombs;
    }

    /**
     * @param validCombs       - all combinations from the power set that
     *                           fill up the empty bucket perfectly.
     *
     * This method prints the smallest valid combination when command line 
     * argument is provided.
     */
    public static void getMinBuckets(int[][] validCombs){
        int[] shortest = validCombs[0];
        for (int[] comb : validCombs) {
            if (comb.length < shortest.length) {
                shortest = comb;
            }
            System.out.println("Yes - " + Arrays.toString(shortest));
        }
    }

    /**
     * @param validCombs       - all combinations from the power set that
     *                           fill up the empty bucket perfectly.
     *
     * This method prints the largest valid combination when no command line
     * argument is provided.
     */
    public static void getMaxBuckets(int[][] validCombs){
        int[] longest = validCombs[0];
        for (int[] comb: validCombs){
            if (comb.length > longest.length){
                longest = comb;
            }
        }
        System.out.println("Yes - " + Arrays.toString(longest));
    }
}
