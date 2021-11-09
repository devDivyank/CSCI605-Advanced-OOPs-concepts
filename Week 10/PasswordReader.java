/**
 * Filename - PasswordReader.java
 *
 * Problem Statement - Reads a password object from file 1234.ser
 *
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */

import java.io.*;

public class PasswordReader {

    public void readPassword(){
        Password pass = null;
        // reads the password object in file 1234.ser
        try {
            ObjectInputStream reader = new ObjectInputStream(new FileInputStream("1234.ser"));
            pass = (Password) reader.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("File not found!");
        }
        assert pass != null;

        // checks if file has been changed or not
        // prints password only if file was untouched
        String rev = "";
        for (int i = 0; i < pass.password_rev.length(); i++){
            rev = pass.password_rev.charAt(i) + rev;
        }
        if (! pass.password.equals(rev)){
            System.out.println("ERROR! File has been tampered with. Self-destruct in 10, 9, 8....");
        } else {
            System.out.println("The password is: " + pass.password);
        }
    }

}
