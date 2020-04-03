package com.ScreenShot.Layout;

import com.ScreenShot.Launcher.MainApp;
import com.ScreenShot.constants.Views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LaunchView {
	
   private Button next;
   
   private final GridPane view;
   
   public LaunchView() {
		
	   view = createOnLoadFormPane();
		
		 // Add UI controls to the registration form grid pane
       addUIControls(view);
       // Create a scene with registration form grid pane as the root node
	}
	
    public Parent getView() {
    	return view;
    }
	private GridPane createOnLoadFormPane() {

		// Instantiate a new Grid Pane
		GridPane gridPane = new GridPane();

		// Position the pane at the center of the screen, both vertically and
		// horizontally
		gridPane.setAlignment(Pos.CENTER);

		// Set a padding of 20px on each side
		gridPane.setPadding(new Insets(40, 40, 40, 40));

		// Set the horizontal gap between columns
		gridPane.setHgap(10);

		// Set the vertical gap between rows
		gridPane.setVgap(10);

		// columnOneConstraints will be applied to all the nodes placed in column one.
		ColumnConstraints columnOneConstraints = new ColumnConstraints(200, 200, Double.MAX_VALUE);
		columnOneConstraints.setHalignment(HPos.RIGHT);

		// columnTwoConstraints will be applied to all the nodes placed in column two.
		ColumnConstraints columnTwoConstrains = new ColumnConstraints(200, 200, Double.MAX_VALUE);
		columnTwoConstrains.setHgrow(Priority.ALWAYS);

		gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

		return gridPane;
	}
    
	private void addUIControls(GridPane gridPane) {

		// Add Header
		Label headerLabel = new Label("Chose An Option");
		headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		gridPane.add(headerLabel, 0, 0, 2, 1);
		GridPane.setHalignment(headerLabel, HPos.LEFT);
		GridPane.setMargin(headerLabel, new Insets(20, 0, 10, 0));
		
		ToggleGroup group = new ToggleGroup(); 
		RadioButton button1 = new RadioButton("Upload an Existing File");  
		button1.setPrefHeight(40);
		button1.setToggleGroup(group);
		
	    RadioButton button2 = new RadioButton("Create a New Docx File"); 
	    button2.setPrefHeight(40);
	    button2.setToggleGroup(group);
	    GridPane.setHalignment(button1, HPos.LEFT);
	    GridPane.setHalignment(button2, HPos.LEFT);
		
		gridPane.add(button1, 0,1);
		
		gridPane.add(button2, 0,2);
		
		next = new Button("Next");
		next.setPrefHeight(30);
		next.setDefaultButton(true);
		next.setPrefWidth(80);
		next.setDisable(true);
        next.setOnAction(event -> {
        	view.getScene().setRoot(MainApp.getInstance());
        });
        button1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
			
				next.setDisable(false);
				MainApp.currentView = Views.UPLOAD;
			}
			
		});
        button2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				next.setDisable(false);
				MainApp.currentView = Views.CREATE;
			}
			
		});
        gridPane.add(next, 0, 3, 2, 1);
        GridPane.setHalignment(next, HPos.RIGHT);
        GridPane.setMargin(next, new Insets(20, 20,20,0));
	}

}
