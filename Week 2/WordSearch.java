package com.rit.assignment2;

/**
 * Filename - WordSearch.java
 * 
 * Problem Statement - To design an algorithm that can take a list of words and 
 *                     search for them forwards, backwards, upwards, or 
 *                     downwards in an array of words.
 *                              
 * @author Abhijeet Mulik      - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 * 
 */
public class WordSearch {

	/**
	 * @param args - default main argument
	 * 
	 * This method will call the subsequent methods to search the puzzle array 
	 * for given list of words.
	 */
	public static void main(String[] args) {

		String[] puzzle = createPuzzle();
		String wordsToSearch[] = { "to", "me", "ma", "on" };
		displayPuzzle(puzzle);
		wordSearch(wordsToSearch, puzzle);
	}

	/**
	 * @param wordsToSearch - Array of words to search in puzzle
	 * @param puzzle - Array of n*n words 
	 * 
	 * This method will call functions that will check the wordsToSearch in the 
	 * puzzle array in forward, backward, upwards and downwards way.
	 */
	public static void wordSearch(String[] wordsToSearch, String[] puzzle) {

		for (int i = 0; i < wordsToSearch.length; i++) {
			String search = wordsToSearch[i];
			System.out.println("Searching for: " + search);
			forward(puzzle, search);
			backward(puzzle, search);
			downwards(puzzle, search);
			upward(puzzle, search);

		}
	}

	/**
	 * @param puzzle - Array of words
	 * @param search - Word to search in puzzle array
	 * 
	 * This method will search for desired words in forward fashion.
	 */
	public static void forward(String[] puzzle, String search) {

		for (int i = 0; i < puzzle.length; i++) {
			if (puzzle[i].contains(search)) {
				System.out.println("Found " + "\"" + search + "\"" + " in row "
			                       + i + " - " + puzzle[i] + "\n");
				break;
			}
		}
	}

	/**
	 * @param puzzle - Array of words
	 * @param search - Word to search in puzzle array
	 * 
	 * This method will search for desired words in downward fashion.
	 */
	public static void downwards(String[] puzzle, String search) {

		for (int i = 0; i < puzzle.length; i++) {
			String verticalString = verticalString(puzzle, i);
			if (verticalString.contains(search)) {
				System.out.println("Found " + "\"" + search + "\"" + 
			                       " in column " + i + " - " + verticalString +
			                       "\n");
				break;
			}
		}

	}

	/**
	 * @param puzzle - Array of words
	 * @param search - Word to search in puzzle array
	 * 
	 * This method will search for desired words in upward fashion.
	 */
	public static void upward(String[] puzzle, String search) {
		for (int i = 0; i < puzzle.length; i++) {
			String verticalString = verticalString(puzzle, i);
			String reverse = reverseString(verticalString);
			if (reverse.contains(search)) {
				System.out.println("Found " + "\"" + search + "\"" +
			                       " in column " + i + " - " + reverse + "\n");
			}
		}
	}

	/**
	 * @param puzzle - Array of words
	 * @param search - Word to search in puzzle array
	 * 
	 * This method will search for desired words in backward fashion.
	 */
	public static void backward(String[] puzzle, String search) {

		for (int i = 0; i < puzzle.length; i++) {
			String reverse = reverseString(puzzle[i]);
			if (reverse.contains(search)) {
				System.out.println("Found " + "\"" + search + "\"" + " in row " 
			                        + i + " - " + reverse + "\n");
			}
		}
	}

	/**
	 * @param puzzle - Array of words
	 * @param index  - Column index
	 * @return       - New string created from the ith index of each column 
	 *                 of n*n words. 
	 * 
	 * This method will create a vertical string column wise to search the 
	 * desired words in the puzzle.
	 */
	public static String verticalString(String[] puzzle, int index) {
		String vertical = "";

		for (int i = 0; i < puzzle.length; i++) {
			vertical = vertical.concat(puzzle[i].substring(index, index + 1));
		}
		return vertical;
	}

	/**
	 * @param word - ith value from the puzzle array
	 * @return       - reverse of the input string
	 * 
	 * This method will reverse the input string.
	 */
	public static String reverseString(String word) {
		String reverse = "";
		for (int i = word.length() - 1; i >= 0; i--) {

			reverse = reverse.concat(String.valueOf(word.charAt(i)));
		}
		return reverse;
	}

	/**
	 * @param puzzle - Array of words
	 * 
	 * This method will display the n*n puzzle being used.
	 */
	public static void displayPuzzle(String[] puzzle) {

		for (int i = 0; i < puzzle.length; i++) {
			System.out.println(i + " " + puzzle[i]);
		}
		System.out.println("\n");
	}
	

	/**
	 * @return - array of words
	 * 
	 * This method is to create a n*n puzzle.
	 */
	public static String[] createPuzzle() {

		return new String[] { "tomato", // 6 x 6
				               "omelet",
				               "carrot", 
				               "onions", 
				               "garlic", 
				               "bagels" 
				            };
	}
}
