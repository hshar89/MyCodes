import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FlowPaneLayout extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Flow Pane Example");
		
		FlowPane root = new FlowPane();
		root.setVgap(60);
		root.setHgap(50);
		root.setPrefWrapLength(250);
		root.getChildren().add(new Button("Start"));  
        root.getChildren().add(new Button("Stop"));  
        root.getChildren().add(new Button("Reset"));
        Scene scene = new Scene(root,300,200);  
        
        primaryStage.setScene(scene);  
        primaryStage.show();  
		
	}

}
