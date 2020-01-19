package a3;

import java.io.Serializable;
import java.util.ArrayList;

public class ShoesBean implements Serializable{
	
	private int itemId;
	private String itemName;
	private String category;
	private double shoeSize;
	private double price;

	private static final long serialVersionUID = 1L;
	
	public ShoesBean(){
		super();
		};

public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getShoeSize() {
		return shoeSize;
	}
	public void setShoeSize(double shoeSize) {
		this.shoeSize = shoeSize;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}



}
