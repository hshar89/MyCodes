import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VBoxLayout extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button btn1 = new Button("Button 1");  
        Button btn2 = new Button("Button 2");  
        VBox root = new VBox();  
        Scene scene = new Scene(root,200,200);  
        root.getChildren().addAll(btn1,btn2);
        root.setSpacing(45.4);
        root.setAlignment(Pos.TOP_LEFT);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
