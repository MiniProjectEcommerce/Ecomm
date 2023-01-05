package demo.IMT2021010;

import ecomm.Globals;
import demo.DemoProduct;

public class Book extends DemoProduct
{
    public Book(String name, int price, int quantity)
    {
        this.unique_name = name;
        this.price = price;
        this.quantity = quantity;
        product_id++;         // Assigning new DemoProduct id
        String str = String.valueOf(product_id);
        this.id = str;
    }
    public String getName(){    // To get the name of a product
        return this.unique_name;
    }
    public float getPrice(){    // To get the price of a product
        return this.price;
    }
    public int getQuantity(){ // To get the quantity of the remaining product
        return this.quantity;
    }
    public String getProductID(){ // To get product id
        return this.id;
    }
    public Globals.Category getCategory(){  // To get category of product
        return Globals.Category.Book;
    }
    public void setQuantity(int quantity){  // To update quantity
        this.quantity = quantity;
    }

}