package com.rit.hw.assignment10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

/**
 * Filename - NumberCounter.java
 * 
 * Problem Statement - Design and implement a program which can determine the
 * distribution of the numbers between 1 and 80 in this file.
 * 
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 * 
 */

public class NumberCounter {
	public static void main(String[] args) throws IOException {
		Integer[] occurrence_count = new Integer[80];

		String fileName = args[0];// "C:/Users/nik/eclipse-workspace/Lottery_Pick_10_Winning_Numbers__Beginning_1987.csv.gz";

		List<String> content = readFile(fileName);
		start_count(occurrence_count, content);

		for (int i = 0; i < 80; i++) {
			System.out.println(i + 1 + " : " + occurrence_count[i]);
		}

	}

	/**
	 * This function will count the number of occurrences in the list and increment
	 * the count in array
	 * 
	 * @param occurrence - Integer array
	 * @param str        - List<String>
	 */
	public static void start_count(Integer[] occurrence, List<String> str) {
		for (String s : str) {
			String[] nums = s.split(" ");
			for (String num : nums) {
				int number = Integer.parseInt(num);
				if (occurrence[number - 1] == null) {
					occurrence[number - 1] = 1;
				} else {
					occurrence[number - 1] += 1;
				}
			}
		}
	}

	/**
	 * This function will read the file and store the contents in List<String>
	 * 
	 * @param file - name of file
	 * @return -
	 * @throws IOException
	 */
	public static List<String> readFile(String file) throws IOException {
		List<String> content = new ArrayList<>();
		try (BufferedReader br = (file.endsWith("gz")
				? new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(file))))
				: new BufferedReader(new InputStreamReader(new FileInputStream(file))))) {
			br.readLine(); // skip first line as it's header
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] arrOfStr = line.split(",", 2);
				content.add(arrOfStr[1]);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());

		}
		return content;
	}
}
