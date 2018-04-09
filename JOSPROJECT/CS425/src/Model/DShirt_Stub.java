/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author danmo
 */
public final class DShirt_Stub implements Observable_DShirt{
    private final SimpleStringProperty brand;
    private final SimpleStringProperty N_Size;
    private final SimpleStringProperty S_Length;
    private final SimpleStringProperty fit;
    private final SimpleStringProperty color;
    private final SimpleStringProperty SKU;
    
    public DShirt_Stub(String brand, String Neck, String Sleeve, String fit, String color, String SKU)
    {
        this.brand = new SimpleStringProperty(brand);
        this.N_Size = new SimpleStringProperty(Neck);
        this.S_Length = new SimpleStringProperty(Sleeve);
        this.fit = new SimpleStringProperty(fit);
        this.color = new SimpleStringProperty(color);
        this.SKU = new SimpleStringProperty(SKU);
    }
    
    public String getBrand()
    {
        return brand.get();
    }
    
    public String getNeckSize()
    {
        return N_Size.get();
    }
    
    public String getSleeveLength()
    {
        return S_Length.get();
    }
    
    public String getFit()
    {
        return fit.get();
    }
    
    public String getColor()
    {
        return color.get();
    }
    
    public String getSKU()
    {
        return SKU.get();
    }
    
    public ObservableValue<String> brandProperty()
    {
        return brand;
    }
    
    public ObservableValue<String> N_SizeProperty()
    {
        return N_Size;
    }
    
    public ObservableValue <String> S_LengthProperty()
    {
        return S_Length;
    }
    
    public ObservableValue <String> fitProperty()
    {
        return fit;
    }
    
    public ObservableValue <String> colorProperty()
    {
        return color;
    }
    
    public ObservableValue <String> skuProperty()
    {
        return SKU;
    }
    
    
}
