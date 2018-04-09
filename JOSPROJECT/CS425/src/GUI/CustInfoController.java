/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author danmo
 */
import Model.Customer_Stub;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CustInfoController implements Initializable {
    Customer_Stub user;
    Connection con1; 
    boolean isEdited =false;
    
    public CustInfoController(Customer_Stub usern)
    {
        this.user=usern;
    }

    @FXML
    private Text name;

    @FXML
    private TextField address;

    @FXML
    private TextField phone;

    @FXML
    private TextField email;

    @FXML
    private Button editButton;

    @FXML
    private TextField creditCard;
    
    @FXML
    private Button signOutButton;

    @FXML
    private Button backButton;
    
    @FXML
    private Button confirm;
    
    @FXML
    private Text updateConfirm;
    
    @Override
    public void initialize(URL url, ResourceBundle rsrcs)
    {
       
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
      
       email.setText(user.getEmail());
       email.setEditable(false);
       name.setText(user.getName());
       address.setText(user.getAddr());
       address.setEditable(false);
       phone.setText(user.getPhone());
       phone.setEditable(false);
       confirm.setDisable(true);
       System.out.println(confirm.isArmed());
    }

    @FXML
    void backButtonFired(ActionEvent event) throws Exception {
        Stage stage;
        Parent root2;
        
        stage=(Stage) backButton.getScene().getWindow();
        //a query goes here to get the customer information based on the CID number
        
        
        
        //load up OTHER FXML document
        FXMLLoader customer = new FXMLLoader(getClass().getResource("CustomerMenu.fxml"));
        customer.setController(new CustomerController(user));
        root2 = customer.load();
      
     
        //create a new scene with root and set the stage
        Scene scene = new Scene(root2);
        stage.setScene(scene);
        stage.show();
    }
        

    @FXML
    void signOutFired(ActionEvent event) throws Exception {
        Stage stage;
        Parent root2;
        
        stage=(Stage) signOutButton.getScene().getWindow();
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
    void editButtonFired(ActionEvent event) {
        address.setEditable(true);
        email.setEditable(true);
        creditCard.setEditable(true);
        phone.setEditable(true);
        confirm.setDisable(false);
    }
    
    @FXML
    void confirmFired(ActionEvent event)
    {
        
        String newAdr = address.getText();
        String newE = email.getText();
        String newCC = creditCard.getText();
        String newPhone = phone.getText();
        
        Customer_Stub newone = new Customer_Stub(user.getName(),user.getCID(),newE, newPhone, newAdr, newCC );
        
       try
        {
            if(newCC.equals("")){
                 String query = "UPDATE CUSTOMER " +
                    "SET ADDRESS= '" + newAdr + "'" +
                    ", EMAIL= '" + newE + "'" +
                    ", TELEPHONE= '" + newPhone + "'" +
                    " WHERE CID= '" + user.getCID() + "'";

            ResultSet rs = null;
            Statement stmt = con1.createStatement();
            //stmt.setString(1, CustID);
            rs = stmt.executeQuery(query);
            }
            else
            {
            //PreparedStatement stmt;
            String query = "UPDATE CUSTOMER " +
                    "SET ADDRESS= '" + newAdr + "'" +
                    ", EMAIL= '" + newE + "'" +
                    ", TELEPHONE= '" + newPhone + "'" +
                    ", CCN= '" + newCC + "'" +
                    " WHERE CID= '" + user.getCID() + "'";

            ResultSet rs = null;
            Statement stmt = con1.createStatement();
            //stmt.setString(1, CustID);
            rs = stmt.executeQuery(query);
            /*while(rs.next())
            {
                addr = rs.getString("ADDRESS");
                check = rs.getString("NAME");                
                email = rs.getString("EMAIL");
                phone = rs.getString("TELEPHONE");
                
                
            }
            System.out.println(check);
            */
            }
        }
        catch (SQLException ex2 ){
            System.out.println("No result in table.");
            ex2.printStackTrace();
        } 
       creditCard.setText("");
       updateConfirm.setText("Update Confirmed!");
       user=newone;
    }

}
