/**
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 *
 * Filename - Grep.java
 *
 * Problem Statement - a program which checks a string against a number of patterns
 *                     and prints the patterns that match.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Grep {
    /**
     * @param args -  file name (optional)
     * @throws FileNotFoundException
     *
     * The main method calls the subsequent methods for matching the
     * input file/string against the patterns.
     */
    public static void main(String[] args) throws FileNotFoundException {
        // if no commandline argument is given input is taken from user
        if (args.length == 0){
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the string to test: ");
            String inputLine = sc.next();
            // PatternMatcher object is created, which runs the check on the input
            PatternMatcher myString = new PatternMatcher(inputLine);
            myString.runCheck();
        } else {
            // commandline argument is given (file name)
            File file = new File(args[0]);
            Scanner sc = new Scanner(file);
            // loops through the strings in file input
            while (sc.hasNextLine()){
                String inputLine = sc.nextLine();
                // PatternMatcher object is created, which runs the check on the input
                PatternMatcher myString = new PatternMatcher(inputLine);
                myString.runCheck();
                System.out.println("___________________________________\n");
            }
        }
    }
}
