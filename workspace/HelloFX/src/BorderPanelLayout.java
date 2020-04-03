import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPanelLayout extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane bPane = new BorderPane();
		bPane.setTop(new Label("This will be top"));
		bPane.setLeft(new Label("This will be left"));
		bPane.setRight(new Label("This will be right"));
		bPane.setCenter(new Label("This will be centre"));
		bPane.setBottom(new Label("This will be bottom"));
		Scene scene = new Scene(bPane,400,400);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
