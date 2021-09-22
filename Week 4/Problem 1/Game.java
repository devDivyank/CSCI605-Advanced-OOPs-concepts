

import java.util.Scanner;

public class Game {
	
	Display display = new Display();

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
	public Player playerGame( boolean turn,
			                        Scanner sc, 
			                        Player player) {

		int imageLength = player.getPlayerImage().elementAt(1).length();

		while (turn) {

			System.out.println(player.getPlayerInfo() + "'s turn , Enter your guess : " + 
					player.getDisplayName());
			String playerInput = sc.nextLine();

			if (player.getName().contains(playerInput.toLowerCase())) {

				player.setDisplayName(display.displayGuess(player.getDisplayName(), player.getSuperHeroName(),
					      playerInput));
				player.setName(player.getName().replaceAll(playerInput.toLowerCase(), ""));

				System.out.println(Constants.CORRECT);

				int charOccurrence = countOccurrence(playerInput.charAt(0),
						             player.getSuperHeroName());
				for (int i = 0; i < charOccurrence; i++) {
					player.setPlayerGuess(player.getPlayerGuess().concat(playerInput)); 
				}

				if (player.getPlayerGuess().length() == player.getSuperHeroName().length()) {

					System.out.println(player.getPlayerInfo() + Constants.WINNER);
					System.out.println(Constants.CORRECT + " - " + player.getSuperHeroName().toUpperCase());
					for (String element : player.getPlayerImage()) {
						System.out.println(element);
					}

					System.exit(0);

				}

				for (int i = 0; i < charOccurrence; i++) {
					player.setVisibilityArray(display.display(imageLength, player.getSuperHeroName(), 
					          player.getVisibilityArray(), player.getPlayerImage().size()));
				}
				display.revealImage(player.getVisibilityArray(), player.getPlayerImage());
				System.out.println(
                        "\n\n\n");

			} else {

				System.out.println(Constants.INCORRECT);
				turn = false;
			}
		}
		return player;
	}
	
	/**
	 * @param playerInput   - the character that player has guessed
	 * @param superHeroName - the string that playerInput is compared with
	 *
	 * This method returns the number of times the playerInput occurs in the
	 * string 'superHeroName'.
	 */
	public int countOccurrence(char playerInput, String superHeroName) {
		int count = 0;
		for (int i = 0; i < superHeroName.length(); i++) {
			if (superHeroName.charAt(i) == playerInput) {
				count++;
			}
		}
		return count;
	}

}
