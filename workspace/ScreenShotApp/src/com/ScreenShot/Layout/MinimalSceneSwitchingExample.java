package com.ScreenShot.Layout;
import java.util.stream.IntStream;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MinimalSceneSwitchingExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        LoginView loginView = new LoginView();
        Scene scene = new Scene(loginView.getView(), 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static class LoginView {

        private final IntegerProperty loginAttempts;

        private final GridPane view ;

        public LoginView() {

            view = new GridPane();

            TextField usernameTF = new TextField("user");
            TextField passwordTF = new TextField("pass");

            // Login button switches to main view:
            Button loginButton = new Button("Login");
            loginButton.setOnAction(event -> {
                if (usernameTF.getText().equalsIgnoreCase("user") 
                    && passwordTF.getText().equalsIgnoreCase("pass")) {

                    // *** Switch to main view: ***

                    Parent mainView = new MainView().getView();
                    view.getScene().setRoot(mainView);

                } else {
                   // loginAttempts.set(loginAttempts.get()+1);
                }
            });

            // just set up login UI... irrelevant to this example:


            loginAttempts = new SimpleIntegerProperty();

            usernameTF.setPromptText("Hint: user");
            passwordTF.setPromptText("Hint: pass");

            view.addRow(0, new Label("Username:"), usernameTF);
            view.addRow(1, new Label("Password:"), passwordTF);

            Label loginErrorMessage = new Label();

            loginErrorMessage.textProperty().bind(
                    Bindings.when(loginAttempts.isEqualTo(0))
                    .then("")
                    .otherwise(Bindings.format("Login incorrect (Attempts: %d)", 
                            loginAttempts)));

            view.add(loginErrorMessage, 0, 2, 2, 1);

            view.add(loginButton, 0, 3, 2, 1);

            ColumnConstraints leftCol = new ColumnConstraints();
            leftCol.setHgrow(Priority.NEVER);
            leftCol.setHalignment(HPos.RIGHT);
            ColumnConstraints rightCol = new ColumnConstraints();
            rightCol.setHgrow(Priority.ALWAYS);
            rightCol.setHalignment(HPos.LEFT);

            view.getColumnConstraints().addAll(leftCol, rightCol);
            GridPane.setHalignment(loginErrorMessage, HPos.CENTER);
            GridPane.setHalignment(loginButton, HPos.CENTER);

            view.setHgap(10);
            view.setVgap(16);

            view.setAlignment(Pos.CENTER);
        }

        public Parent getView() {
            return view ;
        }

    }

    public static class MainView {

        private BorderPane view ;

        public MainView() {

            view = new BorderPane();

            // *** logout button switches back to a login view: ***

            Button logoutButton = new Button("Log out");
            logoutButton.setOnAction(event -> 
                view.getScene().setRoot(new LoginView().getView()));

            // Arbitrary UI, irrelevant to this example:

            SplitPane splitPane = new SplitPane();
            ListView<String> listView = new ListView<>();
            IntStream.rangeClosed(1, 10)
                .mapToObj(Integer::toString)
                .map("Item "::concat)
                .forEach(listView.getItems()::add);

            Label bigLabel = new Label();
            bigLabel.textProperty().bind(
                    listView.getSelectionModel().selectedItemProperty());
            bigLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
            BorderPane.setAlignment(bigLabel, Pos.CENTER);
            BorderPane.setMargin(bigLabel, new Insets(10));

            Label details = new Label();
            details.textProperty().bind(
                Bindings.when(
                        listView.getSelectionModel().selectedItemProperty().isNull())
                    .then("")
                    .otherwise(Bindings.format("This is where you would display "
                        + "all sorts of details about %1$s. "
                        + "If %1$s were really a model object, you "
                        + "might have a GridPane displaying all its "
                        + "properties, for example.", 
                        listView.getSelectionModel().selectedItemProperty())));

            details.setWrapText(true);

            BorderPane detailsPane = new BorderPane(details, bigLabel, null, null, null);

            splitPane.getItems().addAll(listView, detailsPane);

            view.setCenter(splitPane);
            view.setBottom(logoutButton);
            BorderPane.setAlignment(logoutButton, Pos.CENTER);
            BorderPane.setMargin(logoutButton, new Insets(8));
            BorderPane.setMargin(splitPane, new Insets(16));
        }

        public Parent getView() {
            return view ;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
