import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class EventsFilterDemo1 extends Application{
    
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Label l1 = new Label("Press Any Key ");  
        Label l2 = new Label("Filtering Event ");  
        l1.setTranslateX(100);  
        l1.setTranslateY(100); 
        
        l2.setTranslateX(100);  
        l2.setTranslateY(150);  
        
        TextField tf1 = new TextField();  
        TextField tf2 = new TextField();  
          
        tf1.setTranslateX(250);  
        tf1.setTranslateY(100);  
        tf2.setTranslateX(250);  
        tf2.setTranslateY(150);
        
        //Creating Events
        
        EventHandler<KeyEvent> ev = new EventHandler<>() {

			@Override
			public void handle(KeyEvent ke) {
				tf2.setText("Event: "+ke.getEventType());
				tf1.setText(ke.getText());
				ke.consume();
			}
        	
        };
        tf1.addEventFilter(KeyEvent.ANY, ev);
        //To remove Event filter when no longer required
        //tf1.removeEventFilter(KeyEvent.ANY, ev);
        Group root = new Group();
        root.getChildren().addAll(l1,l2,tf1,tf2);
        
        Scene scene = new Scene(root,500,300,Color.ORANGE); 
        
        primaryStage.setScene(scene);  
        primaryStage.setTitle("Adding Event Filter");  
        primaryStage.show();  
        
		
	}

}
