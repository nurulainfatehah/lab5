package exercise1_2;
import java.io.Serializable;
import java.util.ArrayList;

public class ItemProduct implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int itemProductID;
	private String name;
	private float price;
	
	
	public void setItemProductID(int itemProductID) {
		this.itemProductID = itemProductID;
	}
	
	public int getItemProductID() {
		return itemProductID;
	}
	
	public void setName(String name) {
		
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public float getPrice() {
		return price;
	}
	
	
	

}
