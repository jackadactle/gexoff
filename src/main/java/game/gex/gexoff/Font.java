package game.gex.gexoff;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Font {
	
	static LinkedList<BufferedImage> font = new LinkedList<BufferedImage>();
	static LinkedList<BufferedImage> font01 = new LinkedList<BufferedImage>();
	
	static String[] CharIDs = {};
	
	public static void init() {
		initFont1();
		initFont2();
	}
	
	private static void initFont1() {
		String data = "";
		try {
			Scanner reader = new Scanner(new File("Resources/FontData.xml"));
			while (reader.hasNextLine()) {
				data += reader.nextLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String list = data.split("<data>")[1].split("</data>")[0];
		String[] characters = list.split("<character>");
		
		try {
			BufferedImage imageFont = ImageIO.read(new File("Resources/Font.png"));
			
			for (int i = 1; i < characters.length; i++) {
				String charData = characters[i];
				String name = charData.split("<name>")[1].toString().split("</name>")[0];
				int x = Integer.parseInt(charData.split("<x>")[1].toString().split("</x>")[0]);
				int y = Integer.parseInt(charData.split("<y>")[1].toString().split("</y>")[0]);
				int width = Integer.parseInt(charData.split("<width>")[1].toString().split("</width>")[0]);
				int height = Integer.parseInt(charData.split("<height>")[1].toString().split("</height>")[0]);
				
				BufferedImage letter = imageFont.getSubimage(x, y, width, height);
				font.add(letter);
				
				CharIDs = Arrays.copyOf(CharIDs, CharIDs.length + 1);
				CharIDs[CharIDs.length - 1] = name;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void initFont2() {
		String data = "";
		try {
			Scanner reader = new Scanner(new File("Resources/FontData01.xml"));
			while (reader.hasNextLine()) {
				data += reader.nextLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String list = data.split("<data>")[1].split("</data>")[0];
		String[] characters = list.split("<character>");
		
		try {
			BufferedImage imageFont = ImageIO.read(new File("Resources/Font01.png"));
			
			for (int i = 1; i < characters.length; i++) {
				String charData = characters[i];
				int x = Integer.parseInt(charData.split("<x>")[1].toString().split("</x>")[0]);
				int y = Integer.parseInt(charData.split("<y>")[1].toString().split("</y>")[0]);
				int width = Integer.parseInt(charData.split("<width>")[1].toString().split("</width>")[0]);
				int height = Integer.parseInt(charData.split("<height>")[1].toString().split("</height>")[0]);
				
				BufferedImage letter = imageFont.getSubimage(x, y, width, height);
				font01.add(letter);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static BufferedImage text01(String text) {
		int w = 0;
		
		
		String[] letters = text.toLowerCase().split("");
		
		for (int i = 0; i < letters.length; i++) {
			
			String letter = letters[i];
			for (int h1 = 0; h1 < CharIDs.length; h1++) {
				
				if (CharIDs[h1].equals(letter)) {
					
					BufferedImage img = font.get(h1);
					w += img.getWidth();
					
				}
				
			}
			
		}
		int h = 85;
		int nextLocation = 0;
		
		BufferedImage textImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		
		Graphics g = textImage.getGraphics();
	
		for (int i = 0; i < letters.length; i++) {
			
			String letter = letters[i];
			for (int h1 = 0; h1 < CharIDs.length; h1++) {
				
				if (CharIDs[h1].equals(letter)) {
					
					BufferedImage img = font.get(h1);
					g.drawImage(img, nextLocation, 0, null);
					nextLocation += img.getWidth();
					
				}
				
			}
			
		}
		
		return textImage;
	}
	
	public static BufferedImage text02(String text) {
		int w = 20;
		
		String[] letters = text.toLowerCase().split("");
		
		for (int i = 0; i < letters.length; i++) {
			
			String letter = letters[i];
			for (int h1 = 0; h1 < CharIDs.length; h1++) {
				
				if (CharIDs[h1].equals(letter)) {
					
					BufferedImage img = font.get(h1);
					w += img.getWidth();
					
				}
				
			}
			
		}
		int h = 85;
		int nextLocation = 0;
		
		BufferedImage textImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		
		Graphics g = textImage.getGraphics();
	
		for (int i = 0; i < letters.length; i++) {
			
			String letter = letters[i];
			for (int h1 = 0; h1 < CharIDs.length; h1++) {
				
				if (CharIDs[h1].equals(letter)) {
					
					BufferedImage img = font01.get(h1);
					g.drawImage(img, nextLocation, 0, null);
					nextLocation += img.getWidth();
					
				}
				
			}
			
		}
		
		return textImage;
	}
	
}
