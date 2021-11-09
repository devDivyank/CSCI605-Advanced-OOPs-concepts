/**
 * Filename - PasswordWriter.java
 *
 * Problem Statement - Writes a password object to file 1234.ser
 *
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */

import java.io.*;

public class PasswordWriter {

    public void writePassword(Password passwordObj) throws IOException {
        try {
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("1234.ser"));
            writer.writeObject(passwordObj);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

    }
}
