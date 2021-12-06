package com.rit.assignment.B;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Filename - PictureServer.java
 * 
 * @param args - default main argument
 * @throws FileNotFoundException
 *
 * Problem Statement - TCP server.
 * 
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */

public class PictureServer {

	public static void main(String[] args) {
		try (ServerSocket serverSocket = new ServerSocket(Integer.valueOf(args[1]))) {
//		try (ServerSocket serverSocket = new ServerSocket(5000)) {
			Socket socket = serverSocket.accept();
			System.out.println("Client is Connected");
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
			while (true) {
				String inputFromClient = input.readLine();
				System.out.println("Input received from client is : " + inputFromClient);

				if (inputFromClient.equals("exit")) {
					System.out.println("Bye !, Server out. ");
					break;
				}

				List<String> playerImage = readFile(inputFromClient);
				output.println(playerImage);
			}

		} catch (IOException e) {
			System.out.println("Server encountered exception " + e.getMessage());
		}
	}

	public static List<String> readFile(String fileName) throws FileNotFoundException {

		System.out.println("Reading the file " + fileName);
		String data = " ";
		List<String> playerImage = new ArrayList<>();
		File file = new File(fileName);

		Scanner reader = new Scanner(file);
		while (reader.hasNextLine()) {
			data = reader.nextLine();
			playerImage.add(data);
		}
		reader.close();

		for (String img : playerImage) {
			System.out.println(img);
		}

		return playerImage;
	}
}
