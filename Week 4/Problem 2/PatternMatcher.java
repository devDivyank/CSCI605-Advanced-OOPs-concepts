/**
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 *
 * Filename - PatterMatcher.java
 *
 * Problem Statement - PatternMatcher object runs all the pattern checks on a string
 */

public class PatternMatcher {
    String inputWord = "";

    // string to be checked
    public PatternMatcher(String input){
        this.inputWord = input;
    }

    // pattern = ^ab$
    public static boolean patternOne(String inputWord){
        int state = 0;
        char[] inputChars = inputWord.toCharArray();
        for (char inputChar : inputChars) {
            if (inputChar != 'a' && inputChar != 'b'){
                return false;
            }
            if (state == 0) {
                if (inputChar == 'a') {
                    state = 2;
                } else {
                    state = 3;
                }
            }
            else if (state == 2) {
                if (inputChar == 'b') {
                    state = 1;
                } else {
                    state = 3;
                }
            }
            else if (state == 1) {
                state = 3;
                break;
            }
        }
        return (state == 1);
    }

    // pattern = .a+b.
    public static boolean patternTwo(String inputWord){
        int state = 0;
        char[] inputChars = inputWord.toCharArray();
        for (char inputChar : inputChars){
            if (state == 0){
                state = 1;
            }
            else if (state == 1){
                if (inputChar == 'a'){
                    state = 2;
                }
            }
            else if (state == 2){
                if (inputChar == 'b'){
                    state = 3;
                } else if (inputChar == 'a'){
                    state = 2;
                } else {
                    state = 1;
                }
            }
            else if (state == 3){
                state = 4;
            }
        }
        return (state == 4);
    }

    // pattern = .ab.
    public static boolean patternThree(String inputWord){
        return patternTwo(inputWord);
    }

    // pattern = ^[ab]c$
    public static boolean patternFour(String inputWord){
        int state = 0;
        char[] inputChars = inputWord.toCharArray();
        for (char inputChar : inputChars){
            if (inputChar != 'a' && inputChar != 'b' && inputChar != 'c'){
                return false;
            }
            if (state == 0){
                if (inputChar == 'a' || inputChar == 'b'){
                    state = 1;
                } else {
                    state = 3;
                }
            }
            else if (state == 1){
                if (inputChar == 'c'){
                    state = 2;
                } else {
                    state = 3;
                }
            }
            else if (state == 2){
                state = 3;
            }
        }
        return state == 2;
    }

    // pattern = ˆ(bab|aba)$
    public static boolean patternFive(String inputWord){
        int state = 0;
        char[] inputChars = inputWord.toCharArray();
        for (char inputChar : inputChars){
            if (inputChar != 'a' && inputChar != 'b'){
                return false;
            }
            if (state == 0){
                if (inputChar == 'b'){
                    state = 1;
                } else {
                    state = 2;
                }
            }
            else if (state == 1){
                if (inputChar == 'a'){
                    state = 3;
                } else {
                    return false;
                }
            }
            else if (state == 2){
                if (inputChar == 'b'){
                    state = 4;
                } else {
                    return false;
                }
            }
            else if (state == 3){
                if (inputChar == 'b'){
                    state = 5;
                } else {
                    return false;
                }
            }
            else if (state == 4){
                if (inputChar == 'a'){
                    state = 5;
                } else {
                    return false;
                }
            }
            else if (state == 5){
                return false;
            }
        }
        return (state == 5);
    }

    // pattern = ^..12$
    public static boolean patternSix(String inputWord) {
        int state = 0;
        if (inputWord.length() > 4) {
            return false;
        }
        char[] inputChars = inputWord.toCharArray();
        for (int i = 0; i < inputChars.length; i++){
            if (state == 0){
                state = 1;
            }
            else if (state == 1){
                state = 2;
            }
            else if (state == 2){
                if (inputChars[i] == inputChars[0]){
                    state = 3;
                }
            }
            else if (state == 3){
                if (inputChars[i] == inputChars[1]){
                    state = 4;
                }
            }
        }
        return (state == 4);
    }

    // pattern = ^..21$
    public static boolean patternSeven(String inputWord) {
        int state = 0;
        if (inputWord.length() > 4) {
            return false;
        }
        char[] inputChars = inputWord.toCharArray();
        for (int i = 0; i < inputChars.length; i++){
            if (state == 0){
                state = 1;
            }
            else if (state == 1){
                state = 2;
            }
            else if (state == 2){
                if (inputChars[i] == inputChars[1]){
                    state = 3;
                }
            }
            else if (state == 3){
                if (inputChars[i] == inputChars[0]){
                    state = 4;
                }
            }
        }
        return (state == 4);
    }

    // runs all the above functions
    public void runCheck(){
        if (patternOne(this.inputWord)){
            System.out.println("^ab$ : " + this.inputWord);
        }
        if (patternTwo(this.inputWord)){
            System.out.println(".a+b. : " + this.inputWord);
        }
        if (patternThree(this.inputWord)){
            System.out.println(".ab. : " + this.inputWord);
        }
        if (patternFour(this.inputWord)){
            System.out.println("^[ab]c$ : " + this.inputWord);
        }
        if (patternFive(this.inputWord)){
            System.out.println("ˆ(bab|aba)$ : " + this.inputWord);
        }
        if (patternSix(this.inputWord)){
            System.out.println("^..12$ : " + this.inputWord);
        }
        if (patternSeven(this.inputWord)){
            System.out.println("^..21$ : " + this.inputWord);
        }
    }
}
