
package Service;

import Model.Order;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProductService {
    public static String kiír(){
        return "kiírva";
    }
     
    public String kapcsolat(String type,String sex){
        
        
        Connection conn = null;
        String names = "Terméknevek: ";
        
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
                   
                    if( !"U".equals(gender) || rs.getString("gender").equals(gender)){
                        String name = rs.getString("productName");
                        names += name + "  ";
                        String gen = rs.getString("gender");
                        names += gen;
                    }
                    
                    else if("U".equals(gender)){
                        String name = rs.getString("productName");
                        names += name + "  ";
                        String gen = rs.getString("gender");
                        names += gen;
                    }
                    
                   }
               
               conn.close();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return names;
    }
    
    
    
}
