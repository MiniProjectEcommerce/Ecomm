package ecomm;

public class Book extends Product
{
    public Book(String name, int price, int quantity)
    {
        this.unique_name = name;
        this.price = price;
        this.quantity = quantity;
        this.id = product_id;
        product_id++;
    }
    public String getName(){
        return this.unique_name;
    }
    public float getPrice(){
        return this.price;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public int getProductID(){
        return this.id;
    }
    public Globals.Category getCategory(){
        return Globals.Category.Book;
    }

}