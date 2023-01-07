package demo.IMT2021010;

import java.util.*;
import ecomm.Seller;
import ecomm.Globals;
import ecomm.Platform;
import demo.DemoProduct;
import ecomm.Product;

public class SellerRaj extends Seller {

    private ArrayList<DemoProduct> products;

    public SellerRaj(String id) 
    {
        super(id);
        products = new ArrayList<>();
        products.add(new Mobile("Samsung", 10000, 10));
        products.add(new Book("Apsara", 120, 20));
        products.add(new Book("Doms", 100, 15));
        products.add(new Mobile("Nokia", 7000, 17));
    }

    public void addPlatform(Platform pform) 
    {
        pform.addSeller(this);
    }

    public ArrayList<Product> findProducts(Globals.Category whichOne) 
    {
        ArrayList<Product> arr2 = new ArrayList<>();
        for (DemoProduct pro : products) 
        {
            if (pro.getCategory() == whichOne) 
            {
                arr2.add(pro);
            }
        }

        return arr2;
    }

    public boolean buyProduct(String id, int qty) 
    {
        boolean result = false;
        for (DemoProduct pro : products) 
        {
            if (pro.getProductID().equals(id)) 
            {
                if (pro.getQuantity() >= qty) 
                {
                    result = true;
                    pro.setQuantity(pro.getQuantity() - qty);
                    break;
                }
            }
        }
        return result;
    }
}
