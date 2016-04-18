package com.dham.faqscraper;

import java.io.IOException;
import java.net.MalformedURLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * This class takes in a URL as a String and
 * scrapes the page for the guide text. The text
 * is then put into variable guideText.
 */

public class Page {
		
	private String url;
	private Document doc;
	private String title;
	private String gameTitle;
	private String guideText;
	
	
	public Page(String url){
		this.url = url;
		init();
	}
	
	private void init(){
		try {
			doc = Jsoup.connect(url)
					.userAgent("Mozilla")
					.get();
			
			title = doc.title();
			Element texts = doc.getElementById("faqtext");
			Elements headers;
			Element eGameTitle;
			headers = doc.select("h1.page-title");
			eGameTitle = headers.last();
			eGameTitle = eGameTitle.child(0);
			guideText = texts.text();
			gameTitle = eGameTitle.text();
			
			//System.out.println(guideText);
			//System.out.println(title);
			//System.out.println(guideText.length());
			
			
		}
		catch (NullPointerException e){
		}
		catch (MalformedURLException e){
			e.printStackTrace();
		}
		catch (IllegalArgumentException e){
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void saveFile(){
		/*
		 * This function passes the title and guide
		 * if it is not null to the StringToFile
		 * object to save it to disk.
		 * 
		 */
		String output = "";
		
		if(guideText != null){
			output = getTitle();
			StringToFile saver = new StringToFile(output, guideText, gameTitle);
			saver.saveFile();
		}
		
	}
	
	public String getTitle(){
		/*
		 * This function gets the title of
		 * the guide. There will be multiple
		 * general walkthrough guides, so if
		 * the title contains 'walkthrough', we
		 * put the author in the file name.
		 * 
		 * If it's not a walkthrough, we want
		 * the 'idea' of the guide to be the file
		 * name.
		 * 
		 */
		String value = "";
		
		if(title.toLowerCase().contains("walkthrough")){
			value = "FAQ - ";
			value += title.substring(title.indexOf("by ")+3);
		}
		else{
			int beginIndex, endIndex;
			endIndex = title.indexOf(" for ");
			beginIndex = title.indexOf(gameTitle) + gameTitle.length() + 1;
			value = title.substring(beginIndex, endIndex);
		}
		
		return value;
	}
}
