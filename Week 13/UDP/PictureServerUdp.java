package com.rit.assignment.C;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.StringTokenizer;

/**
 * Filename - PictureServerUdp.java
 * 
 * @param args - default main argument
 * @throws FileNotFoundException
 *
 * Problem Statement - UDP server.
 * 
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */

public class PictureServerUdp {

	public static void main(String[] args) throws SocketException {

		try (DatagramSocket socket = new DatagramSocket(5000)) {
			while (true) {
				byte buffer[] = new byte[50];
				DatagramPacket dgp = new DatagramPacket(buffer, buffer.length);
				socket.receive(dgp);

				String inputFromClient = new String(buffer, 0, dgp.getLength());

				System.out.println("text received from client is : " + inputFromClient);

				if (inputFromClient.equals("exit")) {
					System.out.println("Bye ! Server out.");
					break;
				}

				byte[] buffer2 = readFile(inputFromClient);

				InetAddress address = dgp.getAddress();
				int port = dgp.getPort();

				dgp = new DatagramPacket(buffer2, buffer2.length, address, port);
				socket.send(dgp);

			}

		} catch (SocketException e) {
			System.out.println("Socket exception encountered: " + e.getMessage());

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static byte[] readFile(String fileName) throws FileNotFoundException {

		System.out.println("Reading the file " + fileName);
		StringBuffer buffer = new StringBuffer();
		String line;

		BufferedReader in = new BufferedReader(new FileReader(fileName));
		try {
			while ((line = in.readLine()) != null) {
				buffer.append(line);
			}
		} catch (IOException e) {
			System.out.println("IOExcception :" + e.getMessage());
		}

		StringTokenizer tokenizer = new StringTokenizer(buffer.toString(), ",");
		while (tokenizer.hasMoreElements()) {
			System.out.println(tokenizer.nextToken());
		}
		return buffer.toString().getBytes();

	}

}
