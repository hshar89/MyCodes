import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.Mnemonic;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GridPaneLayout extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Label user_name=new Label("User Name");  
        Label password=new Label("Password");  
        TextField tf1=new TextField();  
        PasswordField tf2=new PasswordField(); 
        tf2.setPromptText("Enter Password");
        
        /*Button b1 = new Button("Take Screenshot");
        b1.setMnemonicParsing(true);
		KeyCombination kc = new KeyCodeCombination(KeyCode.P, KeyCombination.SHIFT_DOWN);
		Mnemonic mn = new Mnemonic(b1, kc);
		//b1.setOnKeyPressed(e->{
		//	System.out.println("Combination was used");
		//});
		b1.setOnAction(e->{
			System.out.println("Combination was used");
		});*/
        
        Button Submit=new Button ("Submit");  
        Submit.setOnAction(e->System.out.println("UserId: "+ tf1.getText()+" Password: "+tf2.getText()));
        GridPane root= new GridPane();
        Scene scene = new Scene(root,300,300);
        
        Button btn2 = new Button("Button 2");
		btn2.setOnAction(e -> System.out.println("Button 2 clicked!"));
		KeyCombination kc = new KeyCodeCombination(KeyCode.Q, KeyCombination.ALT_DOWN);
		Mnemonic mnemonic = new Mnemonic(btn2, kc);
		scene.addMnemonic(mnemonic);
		
        root.addRow(0, user_name,tf1);
        root.addRow(1, password,tf2);
        root.addColumn(1,Submit);
        root.add(btn2,0,4);
        root.setHgap(20);
        root.setVgap(20);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Test");
        primaryStage.setIconified(false);
        primaryStage.show();
        //setSaveAccelerator(b1);
	}
	 // sets the save accelerator for a button to the Ctrl+S key combination.
	  private void setSaveAccelerator(final Button button) {
	    Scene scene = button.getScene();
	    if (scene == null) {
	      throw new IllegalArgumentException("setSaveAccelerator must be called when a button is attached to a scene");
	    }

	    scene.getAccelerators().put(
	      new KeyCodeCombination(KeyCode.P, KeyCombination.SHIFT_DOWN), 
	      new Runnable() {
	        @Override public void run() {
	        	System.out.println("Button clicked");
	          //fireButton(button);
	        }
	      }
	    );
	  }

	  // fires a button from code, providing visual feedback that the button is firing.
	  private void fireButton(final Button button) {
	    button.arm();
	    PauseTransition pt = new PauseTransition(Duration.millis(300));
	    pt.setOnFinished(new EventHandler<ActionEvent>() {
	      @Override public void handle(ActionEvent event) {
	        button.fire();
	        button.disarm();
	      }
	    });
	    pt.play();
	  }

}
