package com.rit.assignment11.C;

/**
 * Filename - GrabIt.java
 * 
 * Problem Statement - Implement a game. n humans are sitting around a silver 
 *                     plate. For every round, at an unknown moment in time,
 *                     a marble appears on the plate visible for all player at 
 *                     the same time. Every player tries to grab the marble and 
 *                     if successful takes it from the table. Only one player 
 *                     will be able to take the marble from the table.
 *                              
 * @author Abhijeet Mulik      - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GrabIt {
	public static void main(String[] args) throws InterruptedException {
		try {

			int noOfPlayers = 10;
			int noOfRounds = 100;
			List<Player> playerList = new ArrayList<>();
			for (int i = 0; i < noOfPlayers; i++) {
				playerList.add(i, new Player());
			}
			ExecutorService executor = Executors.newFixedThreadPool(noOfPlayers);
			for (int i = 0; i < noOfRounds; i++) {
				Player.marbleObj.generateMarble();
				for (Player player : playerList) {
					executor.execute(player);
				}
				executor.awaitTermination(10, TimeUnit.MILLISECONDS);
			}
			executor.shutdown();

			for (int i = 0; i < playerList.size(); i++) {
				System.out
						.println("Player " + (i + 1) + " grabbed " +
				playerList.get(i).getMarbleCount() + " marbles.");
			}

		} catch (InterruptedException e) {
			System.out.println("Exception occured " + e.getMessage());
		}

	}
}
