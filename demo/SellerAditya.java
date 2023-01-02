package demo;
import java.util.*;
import ecomm.Seller;
import ecomm.Product;
import ecomm.Globals;
import ecomm.Platform;

public class SellerAditya extends Seller {

    private ArrayList<Product> temp = new ArrayList<>();

    public SellerAditya(String id){
        super(id);
    }

    public void addPlatform(Platform platform){
        platform.addSeller(this);
    }

    public ArrayList<Product> findProducts(Globals.Category whichOne){

        for(int i=0; i<products.size();i++){
            if(products.get(i).getCategory() == whichOne){
                temp.add(products.get(i));
            }
        }
        
        return temp;
    }  

    public boolean buyProduct(int id, int qty){
        boolean flag = false;
        for(int i=0; i<products.size();i++){
            if(products.get(i).getProductID() == id){
                if(products.get(i).getQuantity() >= qty){
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    } 

}
