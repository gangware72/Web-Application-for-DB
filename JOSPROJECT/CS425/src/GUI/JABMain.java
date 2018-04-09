/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author danmo
 */
public class JABMain extends Application {
    Stage stage;
    String myName;
    Scene scene1;
    Parent root;
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        stage=primaryStage;
        FXMLLoader login = new FXMLLoader(getClass().getResource("JABMenu.fxml")); 
        login.setController(new JABMenuController());
        root = login.load();
        //Parent root2 = FXMLLoader.load(getClass().getResource("Search_FXML.fxml"));
        
        scene1 = new Scene(root,600,400);
        //Scene scene2= new Scene(root2,600,400);
        
        stage.setTitle("Jos.A.Bank");
        stage.setScene(scene1);
        stage.show();
    }   
    
   
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
