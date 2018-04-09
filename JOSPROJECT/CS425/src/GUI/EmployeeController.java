/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class EmployeeController {
    

    @FXML
    private Button LoginButton;

    @FXML
    private TextField login;

    @FXML
    private PasswordField pWordField;
    
    @FXML 
    private Text pFail;
    
    @FXML
    private Button backButton;

    

    @FXML
    void backButtonFired(ActionEvent event) throws Exception {
         Stage stage;
        Parent root2;
        
        stage=(Stage) backButton.getScene().getWindow();
        //a query goes here to get the customer information based on the CID number
        
        
        
        //load up OTHER FXML document
        FXMLLoader customer = new FXMLLoader(getClass().getResource("JABMenu.fxml"));
        customer.setController(new JABMenuController());
        root2 = customer.load();
      
     
        //create a new scene with root and set the stage
        Scene scene = new Scene(root2);
        stage.setScene(scene);
        stage.show();
    }

    
    @FXML
    void clearPText (ActionEvent event) throws Exception
    {
        pFail.setText("");
    }
    
    @FXML
    void LoginButtonFired (ActionEvent event) throws Exception {
        
        //Stage stage; 
        //Parent root2;
        //System.out.println("There it goes");
        //System.out.println(login.getText());
        String password = pWordField.getText();
        String uName=login.getText();
        
        //System.out.println(password + " " + uName);
        System.out.println("Login Button Fired");
        if(password.equals("Daniel") && uName.equals("Moctezuma"))
        {
            System.out.println("Success!");
            Stage stage;
            Parent root2;
        
            stage=(Stage) LoginButton.getScene().getWindow();
            //a query goes here to get the customer information based on the CID number
       
        
        
            //load up OTHER FXML document
            FXMLLoader customer = new FXMLLoader(getClass().getResource("EmployeeMenu2.fxml"));
            customer.setController(new EmployeeMenuController());
            root2 = customer.load();
      
     
            //create a new scene with root and set the stage
            Scene scene = new Scene(root2);
            stage.setScene(scene);
            stage.show();
        }
        
        else
        {
            pWordField.setText("");
            pWordField.requestFocus();
            pFail.setText("Incorrect Password, please try again");
        }

    }

}

    

