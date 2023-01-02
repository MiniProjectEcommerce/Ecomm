package demo;
import java.util.*;
import ecomm.Seller;
import ecomm.Product;
import ecomm.Globals;
import ecomm.Platform;

public class SellerRaj extends Seller {

    private ArrayList<Product> arr2 = new ArrayList<>();

    public SellerRaj(String id){
        super(id);
    }

    public void addPlatform(Platform pform)
    {
        pform.addSeller(this);
    }

    public ArrayList<Product> findProducts(Globals.Category whichOne){

        for(int i=0; i<products.size();i++){
            if(products.get(i).getCategory() == whichOne){
                arr2.add(products.get(i));
            }
        }
        
        return arr2;
    }  

    public boolean buyProduct(int id, int qty){
        boolean ans = false;
        for(int i=0; i<products.size();i++){
            if(products.get(i).getProductID() == id){
                if(products.get(i).getQuantity() >= qty){
                    ans = true;
                    break;
                }
            }
        }
        return ans;
    } 

}
