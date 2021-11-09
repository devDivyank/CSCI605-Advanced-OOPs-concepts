import java.io.IOException;

public class PasswordMain {

    public static void main(String[] args) throws IOException {
        Password p1 = new Password("hello");
        PasswordWriter passwordWriter = new PasswordWriter();
        passwordWriter.writePassword(p1);
        new PasswordReader().readPassword();

        p1.setPassword("bye");
        passwordWriter.writePassword(p1);

        new PasswordReader().readPassword();
    }
}
