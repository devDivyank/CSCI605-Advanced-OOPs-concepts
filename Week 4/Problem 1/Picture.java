
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Filename - Picture.java
 * 
 * @param args - default main argument
 * @throws FileNotFoundException
 *
 * Problem Statement - Break Picture game to multiple classes.
 * 
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */
public class Picture {

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
		FileReader fileReader = new FileReader();
		
		player1.setPlayerImage(fileReader.readFile(args[5]));
		player2.setPlayerImage(fileReader.readFile(args[11]));
		
		player1.setSuperHeroName(fileReader.readFile(args[3]).get(0));
		player2.setSuperHeroName(fileReader.readFile(args[9]).get(0));
		
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
		Game game = new Game();
		
		for (int limit = 0; limit < 50; limit++) {

			player1 = game.playerGame(true, sc, player1);
			player2 = game.playerGame(true, sc, player2);

			// if nobody wins in 50 guesses, game ends in a draw
			if (limit == 49) {
				System.out.println(Constants.GAME_DRAW);
				System.out.println(player1.getSuperHeroName().toUpperCase() + 
				Constants.PLAYER_ANSWER + player1.getPlayerInfo());
				System.out.println(player2.getSuperHeroName().toUpperCase() + 
						                " IS THE CORRECT ANSWER FOR PLAYER 2");
				System.out.println(Constants.BYE);
			}
		}

		sc.close();
		
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
		
		player1.setPlayerInfo(args[1]);
		player2.setPlayerInfo(args[7]);
		
		System.out.println("IT'S GUESSING GAME TIME !");
		System.out.println("You have to guess the superhero's, let's go - \n");
		
		player1.setVisibilityArray(new int[player1.getPlayerImage().size()]
		[player1.getPlayerImage().elementAt(1).length() + 1]);
		player2.setVisibilityArray(new int[player2.getPlayerImage().size()]
		[player2.getPlayerImage().elementAt(1).length() + 1]);
		
		player1.setDisplayName(displayLength(player1.getDisplayName(),
		player1.getSuperHeroName()));
		player2.setDisplayName(displayLength(player2.getDisplayName(), 
		player2.getSuperHeroName()));
		
		player1.setName(player1.getSuperHeroName());
		player2.setName(player2.getSuperHeroName());
		
		player1.setPlayerGuess("");
		player2.setPlayerGuess("");
	}

}
