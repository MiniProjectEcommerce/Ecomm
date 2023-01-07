package demo.IMT2021545;

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
    public String getName(){  // Returns name of product
        return this.unique_name;
    }
    public float getPrice(){    // Returns price of product
        return this.price;
    }
    public int getQuantity(){   // Returns quantity of product
        return this.quantity;
    }
    public String getProductID(){   // Returns product id of product
        return this.id;
    }
    public Globals.Category getCategory(){  // Returns category
        return Globals.Category.Book;
    }
    public void setQuantity(int quantity){  // Sets the quantity of a product
        this.quantity = quantity;
    }

}