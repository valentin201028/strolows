/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

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

public class EmailService {
    
    
    public String Email(String data){
        try{
            EmailService.sendMail(data);
            return "Az email sikeresen elküldve a " + data + " címre.";
        }catch(Exception ex){
            return ex.toString();
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
                message.setText("Üdv");
                
                return message;
             } catch (Exception e) {
                Logger.getLogger(EmailService.class.getName()).log(Level.SEVERE,null,e);
            }
            return null;
    }
    
    
}
