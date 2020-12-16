
package Service;

//ITT VANNAK A KOSÁRRAL KAPCSOLATOS FÜGGVÉNYEK

import Model.Order;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BasketService {
    
    //HOZZÁADÁS A KOSÁRHOZ
    public void addToBasket(Integer id , Integer quantity){
        //id és hozzá tartozó darabszám belerakása a kosárba
        try{
            List<Integer> basket = new ArrayList<>();
            basket = Order.getProductList();
            boolean sameId = false;
            
            for(int i = 0; i<basket.size(); i=i+2){
                if(Objects.equals(id, basket.get(i))){
                   basket.set(i+1, quantity);
                   sameId = true;
                }
            }
            if(!sameId){
                basket.add(id);
                basket.add(quantity);
                
            }
            Order.setProductList(basket);
        }
        catch(Exception e){
            e.toString();
        }
    }
    
    //VISSZAADJA A KOSÁR TELJES TARTALMÁT (PRODUCT-ID-KET)
    public List<Integer> basketProducts(){
        List <Integer> basket = new ArrayList<>();
        basket = Order.getProductList();
        return basket;
        
    }
    //KITÖRLÉS A KOSÁRBÓL
    public void deleteFromBasket(Integer id){
        List <Integer> basket = new ArrayList<>();
        basket = Order.getProductList();
        for(int i = 0; i<basket.size();i++){
            if(Objects.equals(id, basket.get(i))){
                basket.remove(i);
            }
        Order.setProductList(basket);
        }
    }
    
    
}
