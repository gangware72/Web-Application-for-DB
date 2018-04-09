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
public final class DPant_Stub implements Observable_DPant{
    private final SimpleStringProperty brand;
    private final SimpleStringProperty waist;
    private final SimpleStringProperty rise;
    private final SimpleStringProperty fit;
    private final SimpleStringProperty color;
    private final SimpleStringProperty SKU;
    
    
    public DPant_Stub (String brand, String waist, String rise, String fit, String color, String SKU)
    {
        this.brand = new SimpleStringProperty(brand);
        this.waist = new SimpleStringProperty(waist);
        this.rise = new SimpleStringProperty(rise);
        this.fit = new SimpleStringProperty(fit);
        this.color = new SimpleStringProperty(color);
        this.SKU = new SimpleStringProperty(SKU);
    }
    
    public String getBrand()
    {
        return brand.get();
    }
    
    public String getWaist()
    {
        return waist.get();
    }
    
    public String getRise()
    {
        return rise.get();
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
    
    public ObservableValue<String> waistProperty()
    {
        return waist;
    }
    
    public ObservableValue<String> riseProperty()
    {
        return rise;
    }
    
    public ObservableValue<String> fitProperty()
    {
        return fit;
    }
    
    public ObservableValue<String> colorProperty()
    {
        return color;
    }
    
    public ObservableValue<String> skuProperty()
    {
        return SKU;
    }
    
    
    
}
