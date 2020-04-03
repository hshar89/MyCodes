package com.ScreenShot.Launcher;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.animation.Animation;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class TestApp extends Application{
   
	BorderPane rootPane;
    TranslateTransition animation;

    @Override
    public void start(Stage primaryStage) {

        Rectangle rect = new Rectangle(50, 50, 50, 50);
        rect.setFill(Color.CORAL);

        animation = createAnimation(rect);

        Button snapshotButton = new Button("Take snapshot");

        Pane pane = new Pane(rect);
        pane.setMinSize(600, 150);

        rootPane = new BorderPane(pane, null, null, snapshotButton, new Label("This is the main scene"));

        snapshotButton.setOnAction(e -> {
            // html file being shown in webview
            File htmlFile = new File ("generated/template.html");
            // the resulting snapshot png file
            File aboutFile = new File ("generated/about.png");
            generate(htmlFile, aboutFile, 1280, 720);
        });

        BorderPane.setAlignment(snapshotButton, Pos.CENTER);
        BorderPane.setMargin(snapshotButton, new Insets(5));
        Scene scene = new Scene(rootPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private TranslateTransition createAnimation(Rectangle rect) {
        TranslateTransition animation = new TranslateTransition(Duration.seconds(1), rect);
        animation.setByX(400);
        animation.setCycleCount(Animation.INDEFINITE);
        animation.setAutoReverse(true);
        animation.play();
        return animation;
    }

    public void generate(File htmlFile, File outputFile, double width, double height) {
        animation.pause();
        // rootPane is the root of original scene in an FXML controller you get this when you assign it an id
        rootPane.setEffect(new GaussianBlur());
        Stage primaryStage = (Stage)rootPane.getScene().getWindow();
        // creating separate webview holding same html content as in original scene
        WebView webView = new WebView();
        // with the size I want the snapshot
        webView.setPrefSize(width, height);
        AnchorPane snapshotRoot = new AnchorPane(webView);
        webView.getEngine().load(htmlFile.toURI().toString());
        Stage popupStage = new Stage(StageStyle.TRANSPARENT);
        popupStage.initOwner(primaryStage);
        popupStage.initModality(Modality.APPLICATION_MODAL);
        // this popup doesn't really show anything size = 1x1, it just holds the snapshot-webview
        popupStage.setScene(new Scene(snapshotRoot, 1, 1));
        // pausing to make sure the webview/picture is completely rendered
        PauseTransition pt = new PauseTransition(Duration.seconds(2));
        pt.setOnFinished(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
                WritableImage image = webView.snapshot(null, null);
                // writing a png to outputFile
                // writing a JPG like this will result in a pink JPG, see other posts
                // if somebody can scrape me simple code to convert it ARGB to RGB or something
                String format = "png";
                try {
                    ImageIO.write(SwingFXUtils.fromFXImage(image, null), format, outputFile);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    rootPane.setEffect(null);
                    popupStage.hide();
                    animation.play();
                }
            }
        });
        // pausing, after pause onFinished event will take + write snapshot
        pt.play();
        // GO!
        popupStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
