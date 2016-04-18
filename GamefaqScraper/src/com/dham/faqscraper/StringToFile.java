package com.dham.faqscraper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/*
 * This class is used to take the guide text,
 * create a file, and put the guide text into
 * the file.
 * 
 */

public class StringToFile {

	private String guide;
	private String title;
	private String game;

	public StringToFile(String title, String guide, String game){
		this.guide = guide;
		this.title = title;
		this.game = game;
	}

	public void saveFile(){
		Writer writer;
		
		title = title.replace("/", " or ");
		title= title.trim();

		try{
			File file = new File(game + "\\ ");
			if(!file.exists()) file.mkdir();
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(game + "\\ " + title + ".txt"), "utf-8"));
			writer.write(guide);
			writer.flush();
			writer.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
			//System.exit(1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e){
			System.out.println(title + ": NPE");
		}
	}

}
