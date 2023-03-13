// Michael Ly
// CS2450
// Assignment 2
// 3-12-2023
 

package application;
	
import java.util.Hashtable;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Label deckLabel = new Label("Select a Deck");
			ListView<String> deckListView = new ListView<>();
			deckListView.getItems().addAll("The Master Thrasher: $60", "The Dictator: $45", "The Street King: $50");
			
			
			Label truckLabel = new Label("Select a Truck");
			ListView<String> truckListView = new ListView<>();
			truckListView.getItems().addAll("7.75-inch axle: $35", "8-inch axle: $40", "8.5-inch axle: $45");
			
			Label wheelLabel = new Label("Select a wheel");
			ListView<String> wheeListView = new ListView<>();
			wheeListView.getItems().addAll("51 mm: $20", "55 mm: $22", "58 mm: $24", "61 mm: $28");
			
			Label miscLabel = new Label("Miscellaneous");
			ListView<String> miscListView = new ListView<>();
			miscListView.getItems().addAll("Grip tape: $10", "Bearings: $30", "Riser pads: $2", "Nuts & bolts kit: $3");
			
			Label subTotalLabel = new Label("Subtotal: ");
			Label subTotal = new Label();
			
			Label salesTaxLabel = new Label("Sales Tax: ");
			Label salesTax = new Label();
			
			Label totaLabel = new Label("Total: ");
			Label total = new Label();
			
			//declare hashTable to make price calculations easier
			Hashtable<String, Integer> prices = new Hashtable<>();
			
			//decks
			prices.put("The Master Thrasher: $60", 60);
			prices.put("The Dictator: $45", 45);
			prices.put("The Street King: $50", 50);
			
			//trucks
			prices.put("7.75-inch axle: $35", 35);
			prices.put("8-inch axle: $40", 40);
			prices.put("8.5-inch axle: $45", 45);
			
			//wheels
			prices.put("51 mm: $20", 20);
			prices.put("55 mm: $22", 22);
			prices.put("58 mm: $24", 24);
			prices.put("61 mm: $28", 28);
			
			//misc
			prices.put("Grip tape: $10", 10);
			prices.put("Bearings: $30", 30);
			prices.put("Riser pads: $2", 2);
			prices.put("Nuts & bolts kit: $3", 3);
			
			
			Button calcButton = new Button("Calculate Price");
			calcButton.setOnAction(event -> {
				int subTotalInt = 0; 
				
				if (deckListView.getSelectionModel().getSelectedItem() != null) 
					subTotalInt += prices.get(deckListView.getSelectionModel().getSelectedItem()).intValue();
				
				if (truckListView.getSelectionModel().getSelectedItem() != null) 
					subTotalInt += prices.get(deckListView.getSelectionModel().getSelectedItem()).intValue();
				
				if (wheeListView.getSelectionModel().getSelectedItem() != null) 
					subTotalInt += prices.get(deckListView.getSelectionModel().getSelectedItem()).intValue();
				
				if (miscListView.getSelectionModel().getSelectedItem() != null) 
					subTotalInt += prices.get(deckListView.getSelectionModel().getSelectedItem()).intValue();
				
				subTotal.setText(String.format("$%.2f", subTotalInt)); //Error Here
				salesTax.setText(String.format("$%.2f", subTotalInt * 0.07));
				total.setText(String.format("$%.2f", subTotalInt * 1.07)); 
			});
			
			GridPane root = new GridPane();
			root.setPadding(new Insets(30));
			root.setHgap(30);
			root.setVgap(30);
			
			//first row
			root.add(deckLabel, 0, 0);
			root.add(truckLabel, 1, 0);
			root.add(wheelLabel, 2, 0);
			root.add(miscLabel, 3, 0);
			
			//second row
			root.add(deckListView, 0, 1);
			root.add(truckListView, 1, 1);
			root.add(wheeListView, 2, 1);
			root.add(miscListView, 3, 1);
			
			//third row
			root.add(calcButton, 0, 2);
			
			//4th row 
			root.add(subTotalLabel, 0, 3);
			root.add(salesTaxLabel, 1, 3);
			root.add(totaLabel, 2, 3);
			
			//5th row 
			root.add(subTotal, 0, 4);
			root.add(salesTax, 1, 4);
			root.add(total, 2, 4);
			
			Scene scene = new Scene(root,700,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Skate Shop");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
