/**
 * Filename - Password.java
 *
 * Problem Statement - Design and implement a password, password reader and password writer
 *                     classes to write to a file and read if file has not been changed
 *
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 *
 */

import java.io.IOException;
import java.io.Serializable;

public class Password implements Serializable {
    String password;
    String password_rev = "";

    public Password(){
    }

    public Password(String str){
        this.password = str;
        for (int i = 0; i < this.password.length(); i++){
            this.password_rev = str.charAt(i) + this.password_rev;
        }
    }

    public void setPassword(String str){
        if (this.password == null){
            this.password = str;
            for (int i = 0; i < this.password.length(); i++){
                this.password_rev = str.charAt(i) + this.password_rev;
            }
        } else {
            this.password = str;
        }
    }

}
