/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Order;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import Service.ProductService;

public class EmailService {
    
    public static void DatasToTheEmail(String email,String nev1,String nev2,String varos,String cim,String telefon){
        Order.setuEmail(email);
        Order.setuFirstName(nev1);
        Order.setuLastName(nev2);
        Order.setuCity(varos);
        Order.setuAddress(cim);
        Order.setuPhone(telefon);
        
        
    }
    
    
    public static Boolean Email(String data){
        try{
            EmailService.sendMail(data);
            EmailService.sendMail("strolowebshop@gmail.com");
            return true;
        }catch(Exception ex){
            return false;
        }
        
    }

    public static void sendMail(String recepient) throws Exception{
        System.out.println("felkészülés");
        Properties properties = new Properties();
        
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.ssl.trust","smtp.gmail.com");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        
        
            String myAccountEmail = "strolowebshop@gmail.com";
            String password = "strolo2020";
        
        
        Session session = Session.getInstance(properties, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail,password);
                        }
         });
        Message message = prepareMessage(session,myAccountEmail, recepient);
        try{
        Transport.send(message);
        System.out.println("elküldve!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Hibás felhasználónév, vagy jelszó!");
        }
        
    }
        
        private static Message prepareMessage(Session session, String myAccountEmail, String recipient){
            try {
                
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(myAccountEmail));
                message.setRecipient(Message.RecipientType.TO,new InternetAddress(recipient));
                message.setSubject("levél");
                
                
                String adat = "nem jó valami";
                ProductService PSrv = new ProductService();
                adat = PSrv.kapcsolat("1","2");
                
                
                
                message.setContent(
                        
                        "<body>"
                            +"<div style='background-color:powderblue;'>"
                                + "<h1 style='text-align:center;padding:20px' >Strolo</h1>"
                                + "<h3 style='padding:20px' >Köszönjük, hogy webshopunkat választotta.<br>"
                                + "Ne ijedjen meg, ha a rendelés utáni 100 évben nem kapja meg a termékeket, mivel ez nem egy valódi webshop!</h3>"
                                + "<div style='padding:40px;padding-top:20px; '>"
                                    + "E-mail-cím: "+ Order.getuEmail() + "<br>"
                                    + "Vezetéknév: "+ Order.getuFirstName() + "<br>"
                                    + "Kersztnév: "+ Order.getuLastName() + "<br>"
                                    + "Város: "+ Order.getuCity() + "<br>"
                                    + "Cím: "+ Order.getuAddress() + "<br>"
                                    + "Telefonszám: "+ Order.getuPhone() + "<br>"
                                   
                                    + adat
                                + "</div>"
                                + "<h3 style='padding:20px' >További kérdései esetén kérjük, vegye fel velünk a kapcsolatot telefonon, vagy e-mail-ben, melyeket megtalál az Információ menüpontban!<br>"
                                        
                            +"</div>"    
                      + "</body>",
                    
                    "text/html"
                );
                
               
                return message;
             } catch (Exception e) {
                Logger.getLogger(EmailService.class.getName()).log(Level.SEVERE,null,e);
            }
            return null;
    }
    
    
}
