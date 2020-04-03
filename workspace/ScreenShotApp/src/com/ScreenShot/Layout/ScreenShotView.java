package com.ScreenShot.Layout;

import com.ScreenShot.Launcher.MainApp;
import com.ScreenShot.controller.ScreenShotController;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.Mnemonic;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ScreenShotView {

	private final GridPane view;

	public ScreenShotView() {
		view = createAppLayout();
		addUIControls();
	}

	private void addUIControls() {

		Label headerLabel = new Label("Add Screen-Shots to File");
		headerLabel.setFont(Font.font("Arial", FontWeight.MEDIUM, 18));
		view.add(headerLabel, 0, 0, 2, 1);
		GridPane.setHalignment(headerLabel, HPos.LEFT);
		GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 20));

		Button takeScreenshot = new Button();
		ScreenShotController ssc = ScreenShotController.getInstance();
		KeyCombination kc = new KeyCodeCombination(KeyCode.Q, KeyCombination.ALT_DOWN);
		ssc.mnemonicScreenShotButton = new Mnemonic(takeScreenshot, kc);
		Image img = new Image("Resources/ClickitIcon.jpg",false);
		ImageView imageView = new ImageView(img);
		imageView.setFitHeight(30);
		imageView.setFitWidth(30);
		takeScreenshot.setGraphic(imageView);
		
		takeScreenshot.setOnAction(e -> {
			System.out.println("Combination was used");
			MainApp.primaryStage.hide();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			ScreenShotController.getInstance().clickScreenShot();
			MainApp.primaryStage.show();
		});
		GridPane.setHalignment(takeScreenshot, HPos.LEFT);
		GridPane.setMargin(takeScreenshot, new Insets(0, 0, 10, 20));
		Label addMessageLabel = new Label("Add Message");
		TextField addMessageTextField = new TextField();
        
		Button saveScreenshotButton = new Button("Save Screenshots");
		saveScreenshotButton.setOnAction(e -> {
			if(ScreenShotController.getInstance().getIsScreenShotTaken()) {
			ScreenShotController.getInstance().closeOutputStream();
			}else {
				MainApp.showAlert(AlertType.INFORMATION, MainApp.primaryStage,
						"No ScreenShot Available", "You have not taken any screenshot to be saved in the file.");
			}
		});
		GridPane.setHalignment(saveScreenshotButton, HPos.RIGHT);
        Button addMessageButton = new Button("Add Message To File");
        addMessageButton.setOnAction(e->{
        	ScreenShotController.getInstance().addScreenshotCommentToFile(addMessageTextField.getText());
        	addMessageTextField.clear();
        });
        view.add(addMessageButton, 2, 2);
		view.add(saveScreenshotButton, 0, 5, 2, 1);
		GridPane.setHalignment(saveScreenshotButton, HPos.LEFT);
		GridPane.setMargin(saveScreenshotButton, new Insets(20, 20, 20, 20));
		
		view.add(addMessageLabel, 0, 2);
		view.add(addMessageTextField, 1, 2);
		view.add(takeScreenshot, 0, 1);
	}
    
	
	private GridPane createAppLayout() {
		// Instantiate a new Grid Pane
		GridPane gridPane = new GridPane();

		// Position the pane at the center of the screen, both vertically and
		// horizontally
		gridPane.setAlignment(Pos.CENTER);

		// Set a padding of 20px on each side
		gridPane.setPadding(new Insets(20, 20, 20, 20));

		// Set the horizontal gap between columns
		gridPane.setHgap(10);

		// Set the vertical gap between rows
		gridPane.setVgap(10);

		// columnOneConstraints will be applied to all the nodes placed in column one.
		ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
		columnOneConstraints.setHalignment(HPos.RIGHT);

		// columnTwoConstraints will be applied to all the nodes placed in column two.
		ColumnConstraints columnTwoConstrains = new ColumnConstraints(200, 200, Double.MAX_VALUE);
		columnTwoConstrains.setHgrow(Priority.ALWAYS);

		gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

		return gridPane;
	}

	public Parent getView() {
		return view;
	}

}
