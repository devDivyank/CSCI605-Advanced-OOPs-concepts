package com.rit.csci.assignment3.b;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Picture {

	/**
	 * Filename - Picture.java
	 * 
	 * @param args - default main argument
	 * @throws FileNotFoundException
	 *
	 * Problem Statement - The main method calls the subsequent methods
	 *                     for setting up and running the two-player
	 *                     guessing game.
	 * 
	 * @author Abhijeet Mulik - am6492@rit.edu
	 * @author Divyank Kulshrestha - dk9924@rit.edu
	 */
	public static void main(String[] args) throws FileNotFoundException {

		// storing ASCII files in two different Vectors
		Vector<String> playerOneImage = readFile(args[1]);
		Vector<String> playerTwoImage = readFile(args[4]);
		
		// correct strings that the players must guess to win
		String superHeroP1 = args[2].toLowerCase();
		String superHeroP2 = args[5].toLowerCase();
		playerOneImage.remove(0);
		playerTwoImage.remove(0);

		 // Prompt to start the game
		System.out.println("IT'S GUESSING GAME TIME !");
		System.out.println("You have to guess the superhero's, let's go - \n");

		String playerInfoP1 = "PLAYER 1";
		 // arrays of 0s and 1s that control the percentage of image displayed
		int[][] visiblityArrayP1 = new int[playerOneImage.size()]
				                   [playerOneImage.elementAt(1).length() + 1];
		String displayNameP1 = ".";
		displayNameP1 = displayNameP1.repeat(superHeroP1.length());
		String playerGuessP1 = "";
		String nameP1 = superHeroP1;
		Scanner sc = new Scanner(System.in);

		String playerInfoP2 = "PLAYER 2";
		 // arrays of 0s and 1s that control the percentage of image displayed
		int[][] visiblityArrayP2 = new int[playerTwoImage.size()]
				                   [playerTwoImage.elementAt(1).length() + 1];
		String displayNameP2 = ".";
		displayNameP2 = displayNameP2.repeat(superHeroP2.length());
		String playerGuessP2 = "";
		String nameP2 = superHeroP2;

		// each player has 50 guesses to win the games
		for (int limit = 0; limit < 50; limit++) {

			displayNameP1 = playerGame(superHeroP1, true, playerOneImage, 
					        visiblityArrayP1, sc, displayNameP1,
					        playerGuessP1, nameP1, playerInfoP1);
			String[] combineP1 = displayNameP1.split("@", 5);
			displayNameP1 = combineP1[0];
			nameP1 = combineP1[1];
			playerGuessP1 = combineP1[2];

			displayNameP2 = playerGame(superHeroP2, true, playerTwoImage, 
					        visiblityArrayP2, sc, displayNameP2,
					        playerGuessP2, nameP2, playerInfoP2);
			String[] combineP2 = displayNameP2.split("@", 5);
			displayNameP2 = combineP2[0];
			nameP2 = combineP2[1];
			playerGuessP2 = combineP2[2];

			// if nobody wins in 50 guesses, game ends in a draw
			if (limit == 49) {
				System.out.println("THIS GAME ENDS AS A DRAW, NEITHER PLAYER 1"
						            + " OR PLAYER 2 COULD GUESS CORRECTLY");
				System.out.println(superHeroP1.toUpperCase() + " IS THE CORRECT"
					                               	+ " ANSWER FOR PLAYER 1");
				System.out.println(superHeroP2.toUpperCase() + 
						                " IS THE CORRECT ANSWER FOR PLAYER 2");
				System.out.println("GOOD BYE !");
			}
		}

		sc.close();
	}

    /**
     * @param displayName   - the number being checked for the desired property
     * @param superHeroName - the correct string that the input is compared with
     * @param playerInput   - the character guessed by the player
     * @return              - all characters that player has guessed correctly
     *
     * This method displays what the player has guessed.
     */
	public static String displayGuess(String displayName, String superHeroName,
			                          String playerInput) {

		char[] name = displayName.toCharArray();

		for (int index = superHeroName.indexOf(playerInput.charAt(0)); 
				         index >= 0; index = superHeroName
				.indexOf(playerInput.charAt(0), index + 1)) {
			name[index] = playerInput.charAt(0);
			System.out.println(String.valueOf(name));
		}
		return String.valueOf(name);

	}

	/**
	 * @param superHeroName   - the correct string that the input is compared 
	 *                          with
	 * @param turn            - if True, respective player will continue to play
	 * @param playerImage     - the vector that stores the ASCII art file that 
	 *                          is
	 *                          displayed on every guess for player 1
	 * @param visibilityArray - array of 0s and 1s that controls the percentage
	 *                          of
	 *                          ASCII art displayed on every guess
	 * @param displayName     - the correct guesses that have been made by the
	 *                          player
	 * @param sc              - Scanner object to take user input
	 * @param playerGuess     - User guess
	 * @param name            - Used to check if user input is valid or not
	 * @return                - Combined string of displayName, name and 
	 *                          playerGuess
	 *
	 * This method simulates the game for Players.
	 */
	public static String playerGame(String superHeroName, boolean turn,
			                        Vector<String> playerImage,
			                        int[][] visibilityArray, Scanner sc, 
			                        String displayName, String playerGuess,
			                        String name,
		                         	String playerInfo) {

		int imageLength = playerImage.elementAt(1).length();

		while (turn) {

			System.out.println(playerInfo + "s turn , Enter your guess : " + 
			                  displayName);
			String playerInput = sc.nextLine();

			if (name.contains(playerInput.toLowerCase())) {

				displayName = displayGuess(displayName, superHeroName,
						      playerInput);
				name = name.replaceAll(playerInput.toLowerCase(), "");

				System.out.println("You guessed correctly !");

				int charOccurrence = countOccurrence(playerInput.charAt(0),
						             superHeroName);
				for (int i = 0; i < charOccurrence; i++) {
					playerGuess = playerGuess.concat(playerInput);
				}

				if (playerGuess.length() == superHeroName.length()) {

					System.out.println(playerInfo + " WON !!!");
					System.out.println(superHeroName.toUpperCase() +
							           " IS THE CORRECT ANSWER");
					for (String element : playerImage) {
						System.out.println(element);
					}

					System.exit(0);

				}

				for (int i = 0; i < charOccurrence; i++) {
					visibilityArray = display(imageLength, superHeroName, 
							          visibilityArray, playerImage.size());
				}
				revealImage(visibilityArray, playerImage);
				System.out.println(
                        "\n\n\n");

			} else {

				System.out.println("Your guess was incorrect. ");
				turn = false;
			}
		}
		return displayName + "@" + name + "@" + playerGuess;
	}

	/**
	 * @param visibilityArray - an array of 0s and 1s which corresponds to the
	 *                          points of original ASCII art to be displayed or 
	 *                          not.
	 * @param playerImage     - the vector that stores the ASCII art file that 
	 *                          is displayed on every guess.
	 *
	 *This method prints a percentage of ASCII art depending upon the number of
	 *characters correctly guessed by the player.
	 */
	public static void revealImage(int[][] visibilityArray, 
			                       Vector<String> playerImage) {
		for (int i = 0; i < visibilityArray.length - 1; i++) {
			
			String str = "";

			for (int j = 0; j < playerImage.elementAt(1).length(); j++) {
				if (visibilityArray[i][j] == 0) {
					str = str.concat(".");
				} else if (visibilityArray[i][j] == 1) {
					str = str.concat(String.valueOf(playerImage.elementAt(i)
						  .charAt(j)));
				}
			}
			System.out.println(str);
		}
	}

	/**
	 * @param imageLength     - horizontal length of a line in the ASCII art 
	 *                          file
	 * @param superHeroName   - the correct string that must be guessed to win
	 * @param visibilityArray - an array of 0s and 1s which corresponds to the
	 *                        points of original ASCII art to be displayed.
	 * @param size            - size of the vector storing the ASCII art.
	 *
	 * This method returns an updated visibility array which raises the
	 * percentage ASCII art that will be printed.
	 */
	public static int[][] display(int imageLength, String superHeroName, 
			              int[][] visibilityArray, int size) {
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			int counter = 0;
			while (counter < (imageLength / superHeroName.length())) {
				int index = random.nextInt(imageLength);
				if (visibilityArray[i][index] != 1) {
					visibilityArray[i][index] = 1;
					counter += 1;
				}
			}
		}
		return visibilityArray;
	}

	/**
	 * @param fileName - the name of the ASCII art file to be used.
	 * @throws FileNotFoundException
	 *
	 * This method reads the file and stores and returns it as a vector.
	 */
	public static Vector<String> readFile(String fileName)
			                   throws FileNotFoundException {
		String data = " ";
		Vector<String> playerImage = new Vector<String>();
		File file = new File(fileName);

		Scanner reader = new Scanner(file);
		while (reader.hasNextLine()) {
			data = reader.nextLine();
			playerImage.add(data);
		}
		reader.close();
		return playerImage;
	}

	/**
	 * @param playerInput   - the character that player has guessed
	 * @param superHeroName - the string that playerInput is compared with
	 *
	 * This method returns the number of times the playerInput occurs in the
	 * string 'superHeroName'.
	 */
	public static int countOccurrence(char playerInput, String superHeroName) {
		int count = 0;
		for (int i = 0; i < superHeroName.length(); i++) {
			if (superHeroName.charAt(i) == playerInput) {
				count++;
			}
		}
		return count;
	}
}
