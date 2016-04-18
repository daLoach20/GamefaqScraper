package com.dham.faqscraper;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ScraperGui extends Application{
	
	private int mode = -1;
	private String url;
	
	// http://www.gamefaqs.com/ps2/197344-final-fantasy-x/faqs

	@Override
	public void start(Stage primaryStage) throws Exception {
		
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
		Button gameModeBtn = new Button(gameModeString);
		grid.add(gameModeBtn, 0, 0);
		
		//Button
		Button consoleModeBtn = new Button(consoleModeString);
		grid.add(consoleModeBtn, 1, 0);
		
		//Label
		Label urlLbl = new Label("URL:");
		grid.add(urlLbl, 0, 2);
		
		//TextField
		final TextField urlTxtField = new TextField();
		grid.add(urlTxtField, 1, 2);
		
		//Button
		Button sendBtn = new Button(sendString);
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(sendBtn);
		grid.add(hbBtn, 1, 3);
		
		gameModeBtn.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				mode = 0;
			}
			
		});
		
		consoleModeBtn.setOnAction(new EventHandler<ActionEvent>(){

			public void handle(ActionEvent arg0) {
				mode = 1;
			}
			
		});
		
		sendBtn.setOnAction(new EventHandler<ActionEvent>(){

			public void handle(ActionEvent arg0) {
				
				boolean modeBool = mode == 0 || mode == 1;
				
				if(modeBool && urlTxtField.getText().toLowerCase().contains("http")){
					url = urlTxtField.getText();
					getPages(url, mode);
				}
				else{
					//Display Error
				}
			}
			
		});
		
		//grid.setGridLinesVisible(true);
		
		Scene scene = new Scene(grid, 300, 300);
		primaryStage.setTitle("GameFAQs Scraper");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args){
		launch(args);
	}
	
	private static void getPages(String url, int mode){
		
		if(mode == 1){
			System.out.println("This feature not yet implemented.");
		}
		else if(mode == 0){
			
			Game g = new Game(url);
			
			System.out.println("Done Getting!");
			
			g.saveFiles();
			
			System.out.println("Done Saving!");
		}
		else System.out.println("Invalid selection.");
		
	}

}