package com.ScreenShot.Layout;

import javax.swing.event.ChangeListener;

import com.ScreenShot.Launcher.MainApp;
import com.ScreenShot.controller.ScreenShotController;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CreateFileView {
	
	private final GridPane view;
	
	private Button next;
    
    public CreateFileView() {
    	view = createAppLayout();
    	addUIControls();
    }
    
	private void addUIControls() {
		
		Label headerLabel = new Label("Create New File");
		headerLabel.setFont(Font.font("Arial", FontWeight.MEDIUM, 18));
		view.add(headerLabel, 0, 0, 2, 1);
		GridPane.setHalignment(headerLabel, HPos.LEFT);
		GridPane.setMargin(headerLabel, new Insets(20, 0, 10, 0));
		
		Button chooseDirectory = new Button("Choose Folder");
		chooseDirectory.setOnAction(e->{
			MainApp.openDirectoryChooser();
		});
		chooseDirectory.setPrefWidth(100);
		Label selectedDirectoryLabel = new Label("Selected Directory");
		TextField selectedDirectoryTextField = new TextField();
		selectedDirectoryTextField.setId("dir1");
		selectedDirectoryTextField.setDisable(true);
		selectedDirectoryTextField.setPrefWidth(40);
	    GridPane.setMargin(selectedDirectoryTextField, new Insets(0,20,0,0));
	    
	    view.add(chooseDirectory, 2, 1);
	    view.add(selectedDirectoryLabel, 0, 1);
	    view.add(selectedDirectoryTextField, 1, 1);
	    
	    TextField createdFileName = new TextField();
	    Button createFileButton = new Button("Create File");
	    createFileButton.setDisable(true);
	    createFileButton.setOnAction(e->{
	    	MainApp.createFile(selectedDirectoryTextField.getText(),createdFileName.getText());
	    });
	    createFileButton.setPrefWidth(100);
	    Label enterFileNameLabel = new Label("Enter File Name");    
	    createdFileName.setId("dir2");
	    createdFileName.setDisable(true);
	    createdFileName.setPrefWidth(100);
	    
	    GridPane.setMargin(createdFileName, new Insets(0,20,0,0));
	    createdFileName.setOnAction(e->{
	    	System.out.println("Text Change event");
	    	String text = createdFileName.getText();
	    	if(!text.isEmpty()) {
	    		ScreenShotController.getInstance().setFileName(text+".docx");
	    		System.out.println("Text Value: "+text);
	    		createFileButton.setDisable(false);
	    	}
	    });
	    
	    view.add(enterFileNameLabel, 0, 2);
	    view.add(createdFileName, 1, 2);
	    view.add(createFileButton, 2, 2);
	    
	    next = new Button("Next");
		next.setPrefHeight(30);
		next.setDefaultButton(true);
		next.setPrefWidth(80);
		next.setDisable(true);
		next.setId("nextCreate");
        next.setOnAction(event -> {
        	System.out.println("=======>Next clicked: "+MainApp.getInstance());
        	view.getScene().setRoot(MainApp.getInstance());
        	MainApp.addMnemonic();
        });
        
        view.add(next, 2, 5, 2, 1);
        GridPane.setHalignment(next, HPos.RIGHT);
        GridPane.setMargin(next, new Insets(20, 20,20,0));
		
	}
	private GridPane createAppLayout() {
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
			gridPane.setVgap(5);

			// columnOneConstraints will be applied to all the nodes placed in column one.
			ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
			columnOneConstraints.setHalignment(HPos.RIGHT);

			// columnTwoConstraints will be applied to all the nodes placed in column two.
			ColumnConstraints columnTwoConstrains = new ColumnConstraints(200, 200, Double.MAX_VALUE);
			columnTwoConstrains.setHgrow(Priority.ALWAYS);

			gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

			return gridPane;
     }

	/*private VBox createAppLayout() {
		view = new VBox(20);
		Label l1 = new Label("Create New File");
		view.setAlignment(Pos.CENTER);
		view.setPadding(new Insets(40, 40, 40, 40));
		view.getChildren().add(l1);
		return view;
	}*/
	
	public Parent getView() {
		return view;
	}

}
