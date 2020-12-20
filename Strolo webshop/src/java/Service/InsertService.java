
package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


//ITT VANNAK AZOK A FÜGGVÉNYEK, MELYEK BEÍRJÁK AZ ÉRTÉKEKET AZ ADATBÁZISBA.

public class InsertService {
    
    //EZZEL A FÜGGVÉNNYEL ÍRÓDIK BE EGY ÚJ RENDELÉS AZ 'ORDER' TÁBLÁBA.
    //A RENDELÉS GOMBRA HÍVÓDIK MEG
    public void toOrder(String uFirstName,String uLastName,String uEmail,String uZipCode,String uCity,String uAddress,String uPhone,Integer orderAmount,Integer is_active){
        Connection conn = null;
        
        try{
            Statement stmt;
            ResultSet rs;
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/strolo?useSSL=false&allowPublicKeyRetrieval=true","admin","admin");
            if(conn != null){
                System.out.println("Connected!");
                
                stmt = conn.createStatement();

                //stmt.execute("INSERT INTO order(uFirstName,uLastName,uEmail,uZipCode,uCity,uAddress,uPhone,orderAmount,order.is_active) VALUES ("+ uFirstName + ","+ uLastName +","+ uEmail + "," + uZipCode + ","+ uCity +","+ uAddress + ","+uPhone + ","+ orderAmount +","+ is_active + ");");
                stmt.executeUpdate("INSERT INTO order (order.uFirstName, order.uLastName, order.uEmail, order.uZipCode, order.uCity, order.uAddress, order.uPhone, order.orderAmount, order.is_active)"
                        + " VALUES ('Kovács','Béla','kb@alma.hu','1000','Pecs','Király utca 1.','123456543',2,1)");

                stmt.close();
            }
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
        
    } 
    
    //EZZEL A FÜGGVÉNNYEL ÍRÓDNAK BE AZ ORDERITEM TÁBLÁBA AZ ÉTÉKEK, MELYEKKEL MEGÁLLAPÍTHATÓ,
    //HOGY EGY RENDELÉSHEZ MELY TERMÉKEK TARTOZNAK. 
    //A RENDELÉS GOMBRA HÍVÓDIK MEG    
    public void toOrderitem(Integer orderid, List<Integer> lista){
        Connection conn = null;
        
        
        try{
            Statement stmt;
            ResultSet rs;
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/strolo?useSSL=false&allowPublicKeyRetrieval=true","admin","admin");
            if(conn != null){
                System.out.println("Connected!");
                
                stmt = conn.createStatement();
                
                for(int i = 0; i<lista.size();i++){
                    stmt.execute("INSERT INTO orderItem VALUES("+ lista.get(i) +","+ orderid +");");
                }

                stmt.close();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
