package com.rit.hw.assignment10;

//original from: http://rosettacode.org/wiki/Pi_set#Java
//modified for color

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Visual extends JFrame {

	private final int LENGTH_OF_SQUARE = 3;
	private final int LENGTH = 330;
	private final int LENGTH_OF_WINDOW = LENGTH * LENGTH_OF_SQUARE;
	private BufferedImage theImage;
	private String fileName = null;
	Reader input;

	public Visual() {
		super("Visual");

		setBounds(100, 100, LENGTH_OF_WINDOW, LENGTH_OF_WINDOW);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public Visual(String fileName) {
		this();
		this.fileName = fileName;
	}

	private char nextDigit(BufferedReader input) {
		char buf[] = new char[1];
		try {
			buf = String.valueOf(input.read()).toCharArray();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return buf[0];
	}

	private void saveImage(BufferedImage theImage) {
		String suffix = "png";
		String outputFileName = fileName == null ? "output" : fileName + "_output" + "." + suffix;
		try {
			File outputfile = new File(outputFileName);
			ImageIO.write(theImage, suffix, outputfile);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void fillSquare(int xOrig, int yOrig, int color) {
		for (int x = 0; x < LENGTH_OF_SQUARE; x++)
			for (int y = 0; y < LENGTH_OF_SQUARE; y++)
				theImage.setRGB(xOrig + x, yOrig + y, color);
	}

	public void createImage() {
		theImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		int red = Color.GREEN.getRGB(); // you might like to change the colors if you like
		int blue = Color.YELLOW.getRGB(); // you might like to change the colors if you like
		int colorUsed;

		// String file = " ";

		try (BufferedReader input = (fileName.endsWith("gz")
				? new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(fileName))))
				: new BufferedReader(new InputStreamReader(new FileInputStream(fileName))))) {
			for (int y = 0; y < getHeight(); y += LENGTH_OF_SQUARE) {
				for (int x = 0; x < getWidth(); x += LENGTH_OF_SQUARE) {
					char digit = nextDigit(input);
					fillSquare(x, y, digit % 2 == 0 ? red : blue);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		repaint();
		saveImage(theImage);
		// System.exit(0);
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(theImage, 0, 0, this);
	}

	public static void main(String[] args) {

		String fileName = "";

		if (args.length <= 0) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter filename : - ");
			fileName = sc.nextLine();
			sc.close();
		} else {
			fileName = args[0];
		}

		Visual aVisual = new Visual(fileName); 
		aVisual.setVisible(true);
		aVisual.createImage();
	}
}
