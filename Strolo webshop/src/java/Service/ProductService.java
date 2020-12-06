
package Service;

import Model.Order;
import Model.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//ITT VANNAK AZOK A FÜGGVÉNYEK, MELYEK FELTÖLTIK A 'WEBSHOP' ÉS A 'PRODUCT' LAYOUTOT
public class ProductService {
    
    //EZ A FÜGGVÉNY KÉRI LE, ÉS ADJA VISSZA ANNAK A TERMÉKNEK AZ ADATAIT, MELYNEK ID-JÁT MEGADTUK NEKI (STRING ->PRODUCT)
    public String ProductFill(){
        String datas = "a";
        //ide jön a lekérdezés id megadásával lehívja a termék adatait.
        return datas;
        
    }
    
    
    //EZ A FÜGGVÉNY OLVASSA KI, HOGY A 'WEBSHOP' LAYOUTON MELY TÍPUS ÉS NEM VAN BEÁLLÍTVA
    //EZ ALAPJÁN KIOLVASSA EZEKET AZ ÉRTÉKEKET AZ ADATBÁZISBÓL, MAJD VISSZAADJA A CONTROLLERNEK
    public List<String> webshopFill(String type,String sex){
        
        Connection conn = null;
        String names = "Terméknevek: \n ";
        List<String> productList = new ArrayList<>();
        
        try{
            String gender = "ULF";
            if(null != sex)switch (sex) {
            case "0":{
                gender = "U";
                break;
            }
            case "1":{
                gender = "F";
                    break;
                }
            case "2":{
                gender = "L";
                    break;
                }
            default:
                break;
            }
            
            Statement stmt;
            ResultSet rs;
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/strolo?useSSL=false&allowPublicKeyRetrieval=true","admin","admin");
            if(conn != null){
                System.out.println("Connected!");
                
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

               rs = stmt.executeQuery("SELECT productName,gender from Product");

               
               while(rs.next()){
                   
                    if( !"U".equals(gender) && rs.getString("gender").equals(gender)){
                        
                        productList.add(rs.getString("id"));
                        productList.add(rs.getString("productName"));
                        productList.add(rs.getString("price"));
                        productList.add(rs.getString("photo"));
                        
                        
                    }
                    
                    else if("U".equals(gender)){
                        
                        productList.add(rs.getString("id"));
                        productList.add(rs.getString("productName"));
                        productList.add(rs.getString("price"));
                        productList.add(rs.getString("photo"));
                    }
                    
                   }
               
               conn.close();
               
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return productList;
    }
    
    
    
}
