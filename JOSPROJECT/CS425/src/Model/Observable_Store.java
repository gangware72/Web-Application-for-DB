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
public interface Observable_Store extends Store {
    public ObservableValue<String> sidProperty();
   
}
