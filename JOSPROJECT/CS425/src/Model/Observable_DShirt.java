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
public interface Observable_DShirt extends Dress_Shirt {
    public ObservableValue<String> brandProperty();
    public ObservableValue<String> N_SizeProperty();
    public ObservableValue<String> S_LengthProperty();
    public ObservableValue<String> fitProperty();
    public ObservableValue<String> colorProperty();
    public ObservableValue<String> skuProperty();
    
}
