Program compilation and execution starts from PasswordMain.java.

      javac PasswordMain.java
      java PasswordMain

A password object holds the password and its reverse string.

PasswordWriter object takes a Password object and writes it into the file 1234.ser.
If the password in the Password object is changed and written into the file,
the reverse of the original password is still unchanged.

PasswordReader object reads the Password object in the file 1234.ser.
It then checks if the reverse of the current password and the reverse of the original
password are equal and prints it if true.