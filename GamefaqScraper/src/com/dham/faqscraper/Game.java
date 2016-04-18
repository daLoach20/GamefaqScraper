package com.dham.faqscraper;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * This class creates an object with the page
 * of a specific game on the GameFAQS website.
 * Each game has multiple guides, and this class
 * creates a list of pages for each guide.
 * 
 */

public class Game {
	
	private String url;
	private Document doc;
	private Elements urlList;
	private ArrayList<Page> pages;
	
	public Game(String url){
		this.url = url;
		pages = new ArrayList<Page>();
		init();
	}
	
	private void init(){
		try {
			doc = Jsoup.connect(url)
					.userAgent("Mozilla")
					.get();
			
			urlList = doc.select("a[href]");
			
			System.out.print("Gathering Pages...");
			//System.out.println(urlList.size());
			for(Element e : urlList){
				/*
				System.out.print("href: " + e.attr("href"));
				System.out.print(" ---- ");
				System.out.println("ClassName: " + e.attr("href").contains("/faqs/"));
				*/
				
				//System.out.println("AbsHref: " + e.absUrl("href"));
				
				if(e.attr("href").contains("/faqs/")){
					//System.out.println(e.text());
					
					pages.add(new Page(e.absUrl("href")));
					System.out.print(".");
				}
				
			}
			
			//System.out.println(pages.size() + " " + count);
			
			/*
			int i = 0, j = 0;
			while(j < 20){
				if(urlList.get(i).attr("href").contains("/faqs/")){
					pages.add(new Page(urlList.get(i).absUrl("href")));
					j++;
					System.out.print(".");
				}
				i++;
			}*/
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e){
			//This catch is for an invalid URL for the game class
			System.out.println("Invalid Argument");
			System.exit(1);
		}
	}
	
	public void saveFiles(){
		
		/*
		 * This function iterates through the list
		 * of pages, and tells each page to save itself
		 * to the disk.
		 * 
		 */
		
		//System.out.println("Game.java: pages.size() = " + pages.size());
		
		/*
		for(int i = 0; i <5; i++){
			pages.get(i).saveFile();
		}
		*/
		
		System.out.print("Saving Files...");
		
		for(Page p : pages){
			p.saveFile();
			System.out.print(".");
		}
		System.out.println();
	}
	
}
