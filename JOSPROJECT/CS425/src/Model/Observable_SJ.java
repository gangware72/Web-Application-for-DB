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
public interface Observable_SJ extends Sport_Jacket{
    public ObservableValue <String> brandProperty();
    public ObservableValue <String> chestProperty();
    public ObservableValue <String> lengthProperty();
    public ObservableValue <String> fitProperty();
    public ObservableValue <String> colorProperty();
    public ObservableValue <String> skuProperty(); 
    
}
