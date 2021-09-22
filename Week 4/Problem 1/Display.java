

import java.util.Random;
import java.util.Vector;

public class Display {
	
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
	public void revealImage(int[][] visibilityArray, 
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
	public int[][] display(int imageLength, String superHeroName, 
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
     * @param displayName   - the number being checked for the desired property
     * @param superHeroName - the correct string that the input is compared with
     * @param playerInput   - the character guessed by the player
     * @return              - all characters that player has guessed correctly
     *
     * This method displays what the player has guessed.
     */
	public String displayGuess(String displayName, String superHeroName,
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

}
