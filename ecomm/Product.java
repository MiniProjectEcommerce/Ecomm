package ecomm;

public abstract class Product {

	// common queries to get category, unique name, price, and number available
	protected String unique_name;
	protected int quantity;
	protected int price;
	protected static int product_id=0;
	protected int id;
	public abstract Globals.Category getCategory();
	public abstract String getName();
	public abstract int getProductID();
	public abstract float getPrice();
	public abstract int getQuantity();
	
}


