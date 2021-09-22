

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class FileReader {
	
	/**
	 * @param fileName - the name of the ASCII art file to be used.
	 * @throws FileNotFoundException
	 *
	 * This method reads the file and stores and returns it as a vector.
	 */
	public Vector<String> readFile(String fileName)
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

}
