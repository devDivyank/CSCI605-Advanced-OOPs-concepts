package com.rit.assignment.C;

/**
 * Filename - RelayRace.java
 * 
 * Problem Statement - implement a simulation of a relay race.
 * 
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 * 
 */

public class RelayRace {
	public static void main(String[] args) {
		int noOfRunners = Integer.parseInt(args[0]); // args[0]
		int noOfRaces = Integer.parseInt(args[1]); // args[1]
		Race race = new Race(noOfRaces);

		for (int i = 0; i < noOfRunners; i++) {
			Runner runner = new Runner(i + 1);
			runner.setTeamSize(noOfRunners);
			race.runners.add(runner);
		}
		new Thread(race).start();
	}
}
