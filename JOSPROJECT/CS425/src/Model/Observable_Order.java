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
public interface Observable_Order extends Order{
    public ObservableValue<String> pidProperty();
    public ObservableValue<String> cidProperty();
    public ObservableValue<String> sidProperty();
    
}
