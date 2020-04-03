package com.ScreenShot.Launcher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.ScreenShot.Layout.CreateFileView;
import com.ScreenShot.Layout.LaunchView;
import com.ScreenShot.Layout.ScreenShotView;
import com.ScreenShot.Layout.UploadView;
import com.ScreenShot.constants.Views;
import com.ScreenShot.controller.ScreenShotController;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.Mnemonic;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

public class MainApp extends Application {

	public static Views currentView = Views.LAUNCH;

	public static Stage primaryStage;

	private static FileChooser fileChooser;

	private static DirectoryChooser dir_chooser;

	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;

		primaryStage.setTitle("ClickIt");

		Scene scene = new Scene(getInstance(), 500, 250);
		Stage st = new Stage();
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.DECORATED);
		primaryStage.show();
	}

	public static Parent getInstance() {

		Parent newView = null;

		switch (currentView) {
		case CREATE:
			newView = new CreateFileView().getView();
			break;
		case LAUNCH:
			newView = new LaunchView().getView();
			break;
		case SCREENSHOT:
			newView = new ScreenShotView().getView();
			break;
		case UPLOAD:
			newView = new UploadView().getView();
			break;
		default:
			newView = new LaunchView().getView();
			break;
		}
		return newView;
	}

	public static void openFileChooser() {
		fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Docx Files", "*.docx"));
		File file = fileChooser.showOpenDialog(primaryStage);

		if (file != null) {
			String fileName = file.getName();
			if (!validateFileName(fileName)) {
				showAlert(AlertType.ERROR, primaryStage, "Wrong File Format", "Only Docx format is allowed");
			} else {
				String path = file.getPath();
				System.out.println("File Name: " + file.getAbsolutePath());
				ScreenShotController.getInstance().setFilePath(path.substring(0, path.lastIndexOf("\\") + 1));
				ScreenShotController.getInstance().setFileName(fileName);
				Parent sroot = primaryStage.getScene().getRoot();
				ObservableList<Node> rootChilds = ((GridPane) sroot).getChildren();
				currentView = Views.SCREENSHOT;
				for (Node node : rootChilds) {
					if (node instanceof TextField) {
						((TextField) node).setText(fileName);
					}
					if (node instanceof Button && node.getId() == "next") {
						node.setDisable(false);
					}
				}
			}

		}
	}

	public static void openDirectoryChooser() {
		dir_chooser = new DirectoryChooser();
		dir_chooser.setInitialDirectory(new File("c:\\"));
		File file = dir_chooser.showDialog(primaryStage);

		if (file != null) {
			String path = file.getAbsolutePath();
			ScreenShotController.getInstance().setFilePath(path);
			System.out.println("Folder path: " + path);
			Parent sroot = primaryStage.getScene().getRoot();
			ObservableList<Node> rootChilds = ((GridPane) sroot).getChildren();
			currentView = Views.SCREENSHOT;
			for (Node node : rootChilds) {
				if (node instanceof TextField) {
					if (node.getId() == "dir1") {
						((TextField) node).setText(path);
					} else if (node.getId() == "dir2") {
						((TextField) node).setDisable(false);
					}
				}
			}
		}

	}

	public static void addMnemonic() {
		ScreenShotController ssc = ScreenShotController.getInstance();
		System.out.println("SSc instance is present");
		primaryStage.getScene().addMnemonic(ssc.mnemonicScreenShotButton);
		ssc.initializeFile();
	}

	public static void createFile(String filePath, String fileName) {

		XWPFDocument docx = new XWPFDocument();
		FileOutputStream out = null;
		boolean success = true;
		String errorMessage = "Expection Happened during file creation. Please contact your admin.";
		try {
			out = new FileOutputStream(filePath + "\\" + fileName + ".docx");
			docx.write(out);
		} catch (FileNotFoundException e) {
			success = false;
			errorMessage = e.getMessage();
		} catch (IOException e) {
			success = false;
			errorMessage = e.getMessage();
		} finally {
			try {
				out.flush();
				out.close();
			} catch (IOException e) {
				success = false;
				errorMessage = e.getMessage();
			}
		}
		if (success) {
			showAlert(AlertType.CONFIRMATION, primaryStage, "Success", "File was created Successfully!!");
			Parent sroot = primaryStage.getScene().getRoot();
			ObservableList<Node> rootChilds = ((GridPane) sroot).getChildren();
			currentView = Views.SCREENSHOT;
			for (Node node : rootChilds) {
				if (node instanceof Button && node.getId() == "nextCreate") {

					node.setDisable(false);
				}
			}
		} else {
			showAlert(AlertType.ERROR, primaryStage, "File Not Created", errorMessage);
		}
	}

	public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(owner);
		alert.show();
	}

	private static boolean validateFileName(String fileName) {
		if (fileName.isEmpty()) {
			return false;
		}
		if (fileName.contains(".docx")) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		launch(args);

	}

}
