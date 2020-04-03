import java.io.File;
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class UiControls extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		StackPane root = new StackPane();
		FileInputStream input = new FileInputStream("C:\\Users\\harshsharma3\\Pictures\\Test1.png");
		Image image = new Image(input);
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(10);
		imageView.setFitWidth(10);
		
		DropShadow shadow = new DropShadow();
		
		Button bn1 = new Button("Do Something",imageView);
		bn1.setWrapText(true);
		bn1.setEffect(shadow);
		Label l1 = new Label("This is icon");
		Scene scene1 = new Scene(root,300,300);
		scene1.setFill(Color.BLACK);
		root.getChildren().addAll(l1,bn1);
		//Scene 2
		ToggleGroup tg = new ToggleGroup();
		RadioButton b1 = new RadioButton("Test 1");
		RadioButton b2 = new RadioButton("Test 2");
		RadioButton b3 = new RadioButton("Test 3");
		RadioButton b4 = new RadioButton("Test 4");
		b1.setToggleGroup(tg);
		b2.setToggleGroup(tg);
		b3.setToggleGroup(tg);
		b4.setToggleGroup(tg);
		
		VBox root2 = new VBox();
		root2.setSpacing(10);
		root2.getChildren().addAll(b1,b2,b3,b4);
		Scene scene2 = new Scene(root2,200,200);
		//Ends
		
		//Scene 3
		Label l2 = new Label("What do you listen!");
		CheckBox c1 = new CheckBox("Radio mirchi");
		CheckBox c2 = new CheckBox("Radio mirchi");
		CheckBox c3 = new CheckBox("Radio mirchi");
		CheckBox c4 = new CheckBox("Radio mirchi");
		
		HBox root3 = new HBox();
		root3.setSpacing(10);
		root3.getChildren().addAll(l2,c1,c2,c3,c4);
		Scene scene3=new Scene(root3,800,200);  
		//Ends
		
		//Scene 4
		Hyperlink hp = new Hyperlink("http://www.javatpoint.com");
		hp.setGraphic(imageView);
		StackPane root4 = new StackPane();  
		hp.setOnAction(e->System.out.println("Link Clicked"));
		root4.getChildren().add(hp);
		Scene scene4 = new Scene(root4,400,100);
		//Ends
		
		//Scene 5
		Slider slider = new Slider(1,100,20);
		StackPane root5 = new StackPane();
		root5.getChildren().add(slider);
		Scene scene5 = new Scene(root5,300,200);
		//Ends
		
		//Scene 6
		ProgressIndicator PI=new ProgressIndicator();  
        PI.setProgress(0.75);
        StackPane root6 = new StackPane();  
        root6.getChildren().add(PI);  
        Scene scene6 = new Scene(root6,300,200);  
		//Ends
		
        //Scene 7
        ScrollBar s = new ScrollBar();  
        s.setOrientation(Orientation.VERTICAL);
        s.setMin(0);
        s.setMax(100);
        s.setValue(50);
        s.setUnitIncrement(10);
        s.setBlockIncrement(20);
        StackPane root7 = new StackPane();  
        root7.getChildren().add(s);  
        Scene scene7 = new Scene(root7,300,200);  
        //Ends
        
        //Scene 8
        Label l3 = new Label("File:");
        TextField tf = new TextField();
        Button bn = new Button("Browse");
        bn.setOnAction(e->{
        	FileChooser f = new FileChooser();
        	 f.setTitle("Open File");
        	 f.showOpenDialog(primaryStage);
        });
        
        Button bn2 = new Button("Save");
        bn2.setOnAction(e->{
        	FileChooser file = new FileChooser();  
            file.setTitle("Save Image");  
            File file1 = file.showSaveDialog(primaryStage);  
            System.out.println(file1);  
        });
        HBox root8 = new HBox();
        root8.getChildren().addAll(l3,tf,bn,bn2);
        root8.setSpacing(20);
        
        Scene scene8 = new Scene(root8,350,200);
        //Ends
        
        //Scene 9
        BorderPane root9 = new BorderPane();  
        Scene scene9 = new Scene(root9,200,300);  
        MenuBar menubar = new MenuBar();  
        
        Menu FileMenu = new Menu("File");  
        MenuItem filemenu1=new MenuItem("new");  
        MenuItem filemenu2=new MenuItem("Save");  
        MenuItem filemenu3=new MenuItem("Exit"); 
        FileMenu.getItems().addAll(filemenu1,filemenu2,filemenu3);  
        
        Menu EditMenu=new Menu("Edit");  
        MenuItem EditMenu1=new MenuItem("Cut");  
        MenuItem EditMenu2=new MenuItem("Copy");  
        MenuItem EditMenu3=new MenuItem("Paste");  
        EditMenu.getItems().addAll(EditMenu1,EditMenu2,EditMenu3);  
        
        root9.setTop(menubar);  

        menubar.getMenus().addAll(FileMenu,EditMenu);  
        //Ends
		primaryStage.setScene(scene9);  
        primaryStage.setTitle("Example Application");  
        primaryStage.show();
	}

}
