package demo;
import ecomm.Product;

public abstract class DemoProduct extends Product {
	// common queries to get category, unique name, price, and number available
	public abstract void setQuantity(int quantity);
}
