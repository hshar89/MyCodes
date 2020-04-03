import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HBoxLayout extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button bn1 = new Button("Button 1");
		Button bn2 = new Button("Button 2");
		
		HBox root = new HBox();
		Scene scene = new Scene(root,400,400);
		root.getChildren().addAll(bn1,bn2);
		root.setSpacing(40);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
   
}
