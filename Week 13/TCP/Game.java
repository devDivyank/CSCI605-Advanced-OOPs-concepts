//package com.rit.assignment.B;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Filename - Game.java
 * 
 * @param args - default main argument
 * @throws FileNotFoundException
 *
 * Problem Statement - Implement a Guessing game.
 * 
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */
public class Game {

	  /**
     * @param args - default main argument
     * @throws FileNotFoundException
     *
     * The main method calls the subsequent methods for setting up and running the
     * two-player guessing game.
     */
	public static void main(String[] args) throws FileNotFoundException {
		
		Player player1 = new Player();
		Player player2 = new Player();
		
		clientConnection(args[1], player1, args[4], player2, args);
		
//		clientConnection("superman.txt", player1, "batman.txt", player2, args);
		
		player1.setSuperHeroName(args[2].toLowerCase());
		player2.setSuperHeroName(args[5].toLowerCase());
		
//		player1.setSuperHeroName("superman");
//		player2.setSuperHeroName("batman");
		
		init(player1, player2, args);
		playGame(player1, player2);
		
	}
	
	/**
	 * @param player1 - Player 1 object
	 * @param player2 - Player 2 object
	 * 
	 * This method will start/end the game.
	 */
	public static void playGame(Player player1, Player player2) {
		
		Scanner sc = new Scanner(System.in);
		GameImpl game = new GameImpl();
		
		for (int limit = 0; limit < 50; limit++) {

			player1 = game.playerGame(true, sc, player1);
			player2 = game.playerGame(true, sc, player2);

			// if nobody wins in 50 guesses, game ends in a draw
			if (limit == 49) {
				System.out.println(Constants.GAME_DRAW);
				System.out.println(player1.getSuperHeroName().toUpperCase() + Constants.PLAYER_ANSWER + player1.getPlayerInfo());
				System.out.println(player2.getSuperHeroName().toUpperCase() + 
						                " IS THE CORRECT ANSWER FOR PLAYER 2");
				System.out.println(Constants.BYE);
			}
		}
		sc.close();
	}
	
	
	public static void clientConnection(String fileName1, Player player1, String fileName2, Player player2, String args[]) {
		try (Socket socket = new Socket(args[7], Integer.valueOf(args[9]))) {
//		try (Socket socket = new Socket("localhost", 5000)) {
			BufferedReader echoes = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);

				String response;

				stringToEcho.println(fileName1);
				response = echoes.readLine();
				List<String> image = new ArrayList<>(Arrays.asList(response.split(",")));
				
				for(String a : image) {
					System.out.println(a);
				}

				player1.setPlayerImage(image);
				
				stringToEcho.println(fileName2);
				response = echoes.readLine();
				image = new ArrayList<>(Arrays.asList(response.split(",")));

				player2.setPlayerImage(image);
				stringToEcho.println("exit");

		} catch (IOException e) {
			System.out.println("Client Error: " + e.getMessage());

		}
	}
	
	
	/**
	 * @param displayName   -the correct guesses that have been made by the
	 *                          player
	 * @param superHeroName - the correct string that the input is compared 
	 *                          with
	 * @return              - displayName with length equal to superHeroName
	 *                        as '.'
	 */
	public static String displayLength(String displayName, String superHeroName) {
		displayName =".";
		displayName = displayName.repeat(superHeroName.length());
		return displayName;
	}
	
	
	/**
	 * @param player1 - Player 1 object
	 * @param player2 - Player 2 object
	 * 
	 * This method will initialize the player object with startup values.
	 */
	public static void init(Player player1, Player player2, String[] args) {
				
		player1.setPlayerInfo("Player 1");
		player2.setPlayerInfo("Player 2");
		
		System.out.println("IT'S GUESSING GAME TIME !");
		System.out.println("You have to guess the superhero's, let's go - \n");
		
		player1.setVisibilityArray(new int[player1.getPlayerImage().size()][player1.getPlayerImage().get(0).length() + 1]);
		player2.setVisibilityArray(new int[player2.getPlayerImage().size()][player2.getPlayerImage().get(0).length() + 1]);
		
		player1.setDisplayName(displayLength(player1.getDisplayName(), player1.getSuperHeroName()));
		player2.setDisplayName(displayLength(player2.getDisplayName(), player2.getSuperHeroName()));
		
		player1.setName(player1.getSuperHeroName());
		player2.setName(player2.getSuperHeroName());
		
		player1.setPlayerGuess("");
		player2.setPlayerGuess("");
	}

}
