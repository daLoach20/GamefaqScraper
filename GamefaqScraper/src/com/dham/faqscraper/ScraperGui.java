package com.dham.faqscraper;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

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
 * TODO: CONSOLE, CLEAN UP GUI
 * 
 * 
 */

public class ScraperGui extends Application{
	
	public Button gameModeBtn;
	public Button consoleModeBtn;
	public Button sendBtn;
	
	private TextField urlTxtField;
	
	
	// http://www.gamefaqs.com/ps2/197344-final-fantasy-x/faqs

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		 urlTxtField = new TextField();
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		//System.out.print("0: Game Mode.\n1: Console Mode (Broken)\n>");
		//System.out.print("What is the URL of the game?\n>");
		String gameModeString = "Game Mode";
		String consoleModeString = "Console Mode";
		String sendString = "Send";
		
		//Button
		gameModeBtn = new Button(gameModeString);
		grid.add(gameModeBtn, 0, 0);
		
		//Button
		consoleModeBtn = new Button(consoleModeString);
		grid.add(consoleModeBtn, 1, 0);
		
		//Label
		Label urlLbl = new Label("URL:");
		grid.add(urlLbl, 0, 2);
		
		//TextField
		grid.add(urlTxtField, 1, 2);
		
		//Button
		sendBtn = new Button(sendString);
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(sendBtn);
		grid.add(hbBtn, 1, 3);
		
		//grid.setGridLinesVisible(true);
		
		Scene scene = new Scene(grid, 300, 300);
		primaryStage.setTitle("GameFAQs Scraper");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public String getURLText(){
		
		return urlTxtField.getText();
	}
	
	public void setURLText(String newText){
		urlTxtField.setText(newText);
	}

}