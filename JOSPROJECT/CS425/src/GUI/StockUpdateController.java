/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StockUpdateController {
    
    Connection con1;
    String store = "34ue";

    @FXML
    private Button updateButton;
    
    @FXML
    private Text maxquantity;

    @FXML
    private TextField product;

    @FXML
    private Text pFail;

    @FXML
    private TextField quantity;
    
    @FXML
    private Button backButton;

    @FXML
    private Button signOut;

    @FXML
    void backButtonFired(ActionEvent event) throws Exception {
        Stage stage;
        Parent root2;
        
        stage=(Stage) backButton.getScene().getWindow();
        //a query goes here to get the customer information based on the CID number
        
        
        
        //load up OTHER FXML document
        FXMLLoader employee = new FXMLLoader(getClass().getResource("EmployeeMenu2.fxml"));
        employee.setController(new EmployeeMenuController());
        root2 = employee.load();
      
     
        //create a new scene with root and set the stage
        Scene scene = new Scene(root2);
        stage.setScene(scene);
        stage.show();
    }
    

    @FXML
    void signOutFired(ActionEvent event) throws Exception {
        Stage stage;
        Parent root2;
        
        stage=(Stage) signOut.getScene().getWindow();
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
    void updateButtonFired(ActionEvent event) {
        String quantities = quantity.getText();
        System.out.println(quantities);
        int amount = Integer.parseInt(quantities);
        String number = "";
        int stock;
        String input = product.getText();
        String product="";
        
         try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            con1 = DriverManager.getConnection("jdbc:oracle:thin:@fourier.cs.iit.edu:1521:orcl", "DMOCTEZUMA", "123456");

            if(con1 != null){
                System.out.println("Connection success!");
            }
            //connect = true;

        } catch (Exception sqle) {
            System.out.println("An error occurred.");
            sqle.printStackTrace();
        } 
        
        try
       {           
            //PreparedStatement stmt;            
            String query = "select STOCK " +
                    "from INVENTORY" +
                    " where UPC_CODE= '" + input + "' AND" +
                    " SID= '" + store + "'";
            System.out.println(query);
            ResultSet rs = null;
            Statement stmt = con1.createStatement();
            //stmt.setString(1, CustID);
            rs = stmt.executeQuery(query);
            while(rs.next())
            {
                             
                stock= rs.getInt("STOCK");
                amount = stock + amount;
                
            }
            System.out.println(amount);
            if(amount < 100)
            {
                String query2 = "UPDATE inventory " +
                        "SET stock = " + amount +
                        "WHERE UPC_Code =" + "'" + input + "'" + " AND" +
                        " SID= '" + store + "'";
                Statement stmt2 = con1.createStatement();
                rs =stmt2.executeQuery(query2);
            }
            else
            {
                maxquantity.setText("Max Quantity reached.");
            }
       }
        catch (SQLException ex2 ){
            System.out.println("No result in table.");
            ex2.printStackTrace();
        } 
         
        
        

    }

}
