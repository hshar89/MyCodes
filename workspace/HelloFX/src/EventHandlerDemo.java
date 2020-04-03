import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class EventHandlerDemo extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Circle c = new Circle(100,100,50);
		c.setFill(Color.AQUA);
		c.setStroke(Color.BLACK);
		
		Button bn1 = new Button("Play");
		bn1.setTranslateX(125);
		bn1.setTranslateY(200);
		
		Button bn2 = new Button("Pause");
		bn2.setTranslateX(175);
		bn2.setTranslateY(200);
		
		//Instantiating TranslateTransition class to create the animation   
	    TranslateTransition trans = new TranslateTransition();  
	    
	  //setting attributes for the TranslateTransition  
	    trans.setAutoReverse(true);
	    trans.setByX(200);
	    trans.setCycleCount(100);
	    trans.setDuration(Duration.millis(200));  
	    trans.setNode(c);  
	    
	    EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if(event.getSource() == bn1) {
					trans.play();
				}
				if(event.getSource() == bn2) {
					trans.pause();
				}
				event.consume();
				
			}
	    };
	    bn1.setOnMouseClicked(handler);
	    bn2.setOnMouseClicked(handler);
	    
	  //Creating Group and scene   
	    Group root = new Group();  
	    root.getChildren().addAll(c,bn1,bn2);  
	    Scene scene = new Scene(root,420,300,Color.WHEAT);  
	    primaryStage.setScene(scene);  
	    primaryStage.setTitle("EventHandler example");  
	    primaryStage.show();  
	}

}
