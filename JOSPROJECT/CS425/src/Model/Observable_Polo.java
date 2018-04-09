package model;

import javafx.beans.value.ObservableValue;

public interface Observable_Polo extends Polo
{ 
	public ObservableValue <String> brandProperty();
	public ObservableValue <String> sizeProperty();
	public ObservableValue <String> fitProperty();
	public ObservableValue <String> colorProperty();
	public ObservableValue <String> skuProperty();
}