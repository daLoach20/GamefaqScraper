package com.dham.faqscraper;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	/*
	 * Author: David Hamilton 4/16/2016.
	 * 
	 * We want to build our skills a bit.
	 * To that end, we are going to make a scraper for GameFaqs guides.
	 * 
	 * Elements will be:
	 * 
	 * Page Element to parse the guide to Txt.
	 * Game Element to open each Page
	 * 
	 * Console Element to open each Game.
	 * We'll probably need a way to traverse the multiple pages
	 * that will have the games listed in Alphabetical Order.
	 * 
	 * We want to at least try to use good OOP concepts.
	 * 
	 * TODO: GUI, CONSOLE
	 * 
	 * 
	 */
	
	private static Scanner cin;

	public static void main(String[] args) throws IOException {
		
		String url = "http://www.gamefaqs.com/ps2/197344-final-fantasy-x/faqs/18187";
		
		//THIS ONE DOOOFUS!
		//String url = "http://www.gamefaqs.com/ps2/197344-final-fantasy-x/faqs";
		
		/*
		System.out.print("0: Game Mode.\n1: Console Mode (Broken)\n>");
		int mode = getMode();
		
		if(mode == 1){
			System.out.println("This feature not yet implemented.");
		}
		else if(mode == 0){
			System.out.print("What is the URL of the game?\n>");
			url = getURL();
			
			Game g = new Game(url);
			
			System.out.println("Done Getting!");
			
			g.saveFiles();
			
			System.out.println("Done Saving!");
		}
		else System.out.println("Invalid selection.");
		*/
		
		
		for(int i = 0; i < 20; i++){
		Page p = new Page(url);
		p.saveFile();
		}
		

	}

	private static String getURL() {
		
		cin = new Scanner(System.in);
		
		String value = cin.nextLine();
		
		cin.close();
		
		return value;
	}

	private static int getMode() {
		
		cin = new Scanner(System.in);
		int value = cin.nextInt();
		
		return value;
	}

}
