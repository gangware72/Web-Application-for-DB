/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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



public class JABMenuController {
    
    
    @FXML
    private TextField CustomerID;
    
    @FXML
    private Button EmployeeButton;

    @FXML
    private Button enterButton;

    @FXML
    void EmpButtonFired(ActionEvent event) throws Exception {
        
        Stage stage;
        Parent root2;
        
        stage=(Stage) EmployeeButton.getScene().getWindow();
        //load up OTHER FXML document
        FXMLLoader employee = new FXMLLoader(getClass().getResource("EmployeeMenu.fxml"));
        employee.setController(new EmployeeController());
        root2 = employee.load();
      
     
        //create a new scene with root and set the stage
        Scene scene = new Scene(root2);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void enterButtonFired(ActionEvent event) throws Exception {
        Stage stage;
        Parent root2;
        Connection con1=null;
        boolean connect =false;
        String check="";
        String addr ="";
        String email="";
        String phone="";
        
        
        stage=(Stage) enterButton.getScene().getWindow();
        //a query goes here to get the customer information based on the CID number
        //making a prepared statement
        
        
        
        //establish connection
        try {
           
           
           

            Class.forName("oracle.jdbc.driver.OracleDriver");

            con1 = DriverManager.getConnection("jdbc:oracle:thin:@fourier.cs.iit.edu:1521:orcl", "DMOCTEZUMA", "123456");

            if(con1 != null){
                System.out.println("Connection success!");
            }
            connect = true;

        } catch (Exception sqle) {
            System.out.println("An error occurred.");
            sqle.printStackTrace();
        }  
        
        //once connection is established, get the customer number        
        String CustID = CustomerID.getText();       
        System.out.println(CustID);
        //now make query to see if that customer id exists
        //if customer ID is true, move on to next page...
        //else send error message
        
        try
        {
            
            //PreparedStatement stmt;
            String query = "select * " +
                    "from CUSTOMER" +
                    " where CID= " + CustID;

            ResultSet rs = null;
            Statement stmt = con1.createStatement();
            //stmt.setString(1, CustID);
            rs = stmt.executeQuery(query);
            while(rs.next())
            {
                addr = rs.getString("ADDRESS");
                check = rs.getString("NAME");                
                email = rs.getString("EMAIL");
                phone = rs.getString("TELEPHONE");
                
                
            }
            System.out.println(check);
        }
        catch (SQLException ex2 ){
            System.out.println("No result in table.");
            ex2.printStackTrace();
        } 
        
        
        
        
        //do this and set up the customer info
        if (connect==false || check.equals(""))
        {
            System.out.println("Something happened.");
        }
        else
        {
            FXMLLoader customer = new FXMLLoader(getClass().getResource("CustomerMenu.fxml"));
            customer.setController(new CustomerController(new Customer_Stub(check, CustID,email,phone, addr)));
            root2 = customer.load();
      
     
            //create a new scene with root and set the stage
            Scene scene = new Scene(root2);
            stage.setScene(scene);
            stage.show();
        }
    }
    
    

}

    

