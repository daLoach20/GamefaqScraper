package com.dham.faqscraper;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;


public class ScraperController extends Application{
	
	private static int mode;
	private static ScraperGui view;
	private static String url;
	
	public static void main(String[] args){
		
		launch();		
		
	}
	
private static void getPages(String url, int mode){
		
		if(mode == 1){
			//System.out.println("This feature not yet implemented.");
			view.setURLText("Feature Not Yet Implemented.");
		}
		else if(mode == 0){
			
			view.setURLText("Working...");
			
			Game g = new Game(url);
			
			//System.out.println("Done Getting!");
			
			g.saveFiles();
			
			//System.out.println("Done Saving!");
			view.setURLText("Done!");
		}
		//else System.out.println("Invalid selection.");
		
	}

@Override
public void start(Stage stage) throws Exception {
	view = new ScraperGui();
	view.start(stage);
	
	view.gameModeBtn.setOnAction(new EventHandler<ActionEvent>() {

		public void handle(ActionEvent arg0) {
			mode = 0;
		}
		
	});
	
	view.consoleModeBtn.setOnAction(new EventHandler<ActionEvent>(){

		public void handle(ActionEvent arg0) {
			mode = 1;
		}
		
	});
	
	view.sendBtn.setOnAction(new EventHandler<ActionEvent>(){

		public void handle(ActionEvent arg0) {
			
			boolean modeBool = mode == 0 || mode == 1;
			
			if(modeBool && view.getURLText().toLowerCase().contains("http")){
				url = view.getURLText();
				//System.out.println(url);
				getPages(url, mode);
				
			}
			else{
				//Display Error
			}
		}
		
	});
}

}
