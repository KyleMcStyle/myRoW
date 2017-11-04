package kyleuml;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class KyleUML extends Application 
{
    @Override
    public void start(Stage primaryStage) 
    {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 800, 800);
        
        
        
        SidePanel sidePanel = new SidePanel();
        CenterPane centerPane = new CenterPane(sidePanel);
        myMenuBar menuBar = new myMenuBar(centerPane);
        
        
        root.setTop(menuBar);
        root.setLeft(sidePanel);
        root.setCenter(centerPane);
        //root.setRight(new Rectangle(45, 50));
        
        
        
        primaryStage.setTitle("Kyle's UML Editor");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        

    }

    public static void main(String[] args) 
    {
        launch(args);
    }
    
    
    
}
