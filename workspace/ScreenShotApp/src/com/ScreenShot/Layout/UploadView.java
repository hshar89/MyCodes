package com.ScreenShot.Layout;

import com.ScreenShot.Launcher.MainApp;
import com.ScreenShot.constants.Views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;

public class UploadView {

	private final GridPane view;

	private Button next;

	public UploadView() {
		view = createGridLayout();

		addUIControls();
	}

	private void addUIControls() {
		// Add Header
		Label headerLabel = new Label("Upload an Existing Docx File");
		headerLabel.setFont(Font.font("Arial", FontWeight.MEDIUM, 18));
		view.add(headerLabel, 0, 0, 2, 1);
		GridPane.setHalignment(headerLabel, HPos.LEFT);
		GridPane.setMargin(headerLabel, new Insets(20, 0, 10, 0));

		Button uploadFileButton = new Button("Upload File");
		uploadFileButton.setOnAction(e -> {
			MainApp.openFileChooser();
		});

		Label selectedFileLabel = new Label("Selected File");
		TextField selectedFileTextField = new TextField();
		selectedFileTextField.setDisable(true);
		selectedFileTextField.setPrefWidth(200);
		
		GridPane.setHalignment(selectedFileLabel, HPos.LEFT);
		view.add(selectedFileLabel, 0, 1);
		
		GridPane.setHalignment(uploadFileButton, HPos.LEFT);
		view.add(uploadFileButton, 2, 1);	
		
		GridPane.setHalignment(selectedFileTextField, HPos.LEFT);
		view.add(selectedFileTextField, 1, 1);

		next = new Button("Next");
		next.setPrefHeight(30);
		next.setDefaultButton(true);
		next.setPrefWidth(80);
		next.setDisable(true);
		next.setId("next");
		next.setOnAction(event -> {
			view.getScene().setRoot(MainApp.getInstance());
			MainApp.addMnemonic();
		});

		view.add(next, 2, 3, 2, 1);
		GridPane.setHalignment(next, HPos.RIGHT);
		GridPane.setMargin(next, new Insets(20, 20, 20, 0));

	}

	private GridPane createGridLayout() {

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

		return gridPane;
	}

	public Parent getView() {
		return view;
	}

}
