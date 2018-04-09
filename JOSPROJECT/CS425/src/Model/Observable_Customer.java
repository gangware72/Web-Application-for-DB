/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.beans.value.ObservableValue;

/**
 *
 * @author danmo
 */
public interface Observable_Customer extends Customer {
    public ObservableValue<String> cidProperty(); 
    public ObservableValue<String> nameProperty();
    public ObservableValue<String> emailProperty();     
    public ObservableValue<String> creditProperty();  
    public ObservableValue<String> phoneProperty();
    public ObservableValue<String> addrProperty();
}
