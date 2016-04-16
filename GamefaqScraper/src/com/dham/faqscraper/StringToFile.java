package com.dham.faqscraper;

import java.io.BufferedWriter;
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

	public StringToFile(String title, String guide){
		this.guide = guide;
		this.title = title;
	}

	public void saveFile(){
		Writer writer;
		
		title = title.replace("/", " or ");

		try{
			writer = new BufferedWriter(	new OutputStreamWriter(
					new FileOutputStream(title + ".txt"), "utf-8"));
			writer.write(guide);
			writer.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
			System.exit(1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e){
			System.out.println(title + ": NPE");
		}
	}

}
