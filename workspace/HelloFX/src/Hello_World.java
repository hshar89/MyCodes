
import javafx.application.Application;  
import javafx.event.ActionEvent;  
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;  
import javafx.scene.control.Button;  
import javafx.stage.Stage;  
import javafx.scene.layout.StackPane;  

public class Hello_World extends Application{  
  
    @Override  
    public void start(Stage primaryStage) throws Exception {  
        // TODO Auto-generated method stub  
        Button btn1=new Button("Say, Hello World"); 
        Button btn2 = new Button("This is button2");
        btn2.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent ae) {
        		System.out.println("Button 2");
        	}
        });
        btn1.setOnAction(new EventHandler<ActionEvent>() {  
              
            @Override  
            public void handle(ActionEvent arg0) {  
                // TODO Auto-generated method stub  
                System.out.println("hello world");  
            }  
        });  
        StackPane root=new StackPane();  
        root.getChildren().addAll(btn1,btn2);  
        root.setAlignment(Pos.BASELINE_LEFT);
        Scene scene=new Scene(root,600,400);      
        primaryStage.setTitle("First JavaFX Application");  
        primaryStage.setScene(scene);  
        primaryStage.show(); 
    }  
    public static void main (String[] args)  
    {  
        launch(args);  
    }  
  
} 
