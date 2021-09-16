package com.rit.csci.assignment3.c;

/**
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 *
 * Filename - MissingNumberReadFromFile.java
 *
 * Problem Statement - Read a file with a sequence of numbers
 *                     to check the number missing in it.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MissingNumberReadFromFile {
	/**
	 * @param args -  bit limit, file name
	 * @throws FileNotFoundException
	 *
	 * The main method calls the subsequent methods for checking for the
	 * missing number in a file
	 */
	public static void main(String[] args) throws FileNotFoundException {
		int previousNumber = 0;
		int currentNumber = 0;
		File file = new File(args[3]);
		int limit = Integer.parseInt(args[1]);

		findMissingNumber(file, limit, previousNumber, currentNumber);
	}

	/**
	 * @param fileName       - fileName
	 * @param limit          - bit limit
	 * @param previousNumber - current-1 number read from the file
	 * @param currentNumber  - current number read from file
	 *
	 * @throws FileNotFoundException
	 *
	 * This method scans the file for a missing number inside a sequence of
	 * numbers and display it.
	 */
	public static void findMissingNumber(File fileName, double limit, 
			                   int previousNumber, int currentNumber)
			                   throws FileNotFoundException {

		limit = Math.pow(2, limit);
		Scanner reader = new Scanner(fileName);
		while (reader.hasNextInt()) {
			currentNumber = reader.nextInt();
			int result = (currentNumber - previousNumber == 1) ? 
					     (previousNumber = currentNumber) : (currentNumber - 1);
			if (!(result == currentNumber)) {
				System.out.println("Missing number is : " +
			                       String.valueOf(currentNumber - 1));
				System.exit(0);
			}
		}

		if (currentNumber == previousNumber && currentNumber == (int) limit - 1)
		{
			System.out.println("Missing number is : " + (int) limit);
		}
		reader.close();
	}
}
