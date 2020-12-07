
package Service;

//ITT VANNAK A KOSÁRRAL KAPCSOLATOS FÜGGVÉNYEK

import Model.Order;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BasketService {
    
    //HOZZÁADÁS A KOSÁRHOZ
    public void addToBasket(Integer number, Integer id){
        //egy for ciklus lefut annyiszor, ahányas számot kap, tehát annyiszor rakja bele 
        // az id-t az 'Order.productList'-be
        List <Integer> basket = new ArrayList<>();
        for(int i = 0 ; i < number; i++){
             basket.add(id);
        }
        Order.setProductList(basket);
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
