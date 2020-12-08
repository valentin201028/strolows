/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Service.EmailService;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Valentin
 */
@WebServlet(name = "EmailController", urlPatterns = {"/EmailController"})
public class EmailController extends HttpServlet {
 EmailService eSrv = new EmailService();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try{
           PrintWriter out = response.getWriter();
           
            if(request.getParameter("task")!=null){
                if(request.getParameter("task").equals("dataInput")){
                    String email = request.getParameter("email");
                    String nev1 = request.getParameter("fname");
                    String nev2 = request.getParameter("name");
                    String varos = request.getParameter("adresse1");
                    String cim = request.getParameter("adresse2");
                    String telefon = request.getParameter("phoneNumber");
                    String kp0 = request.getParameter("payCash");
                    boolean kp = Boolean.parseBoolean(kp0);
                    String ok0 = request.getParameter("agreement");
                    boolean ok = Boolean.parseBoolean(ok0);
                    
                    
                    
                    
                    String uzenet = "hiba";
                    Integer s = 0;
                    if(email.length() == 0 || nev1.length() == 0 || nev2.length() == 0 || varos.length() == 0 || cim.length() == 0 || telefon.length() == 0 ){
                        uzenet="Kérem, töltsön ki minden mezőt";
                        s++;
                    }
                    if(!kp){
                        uzenet = "Csak készpénzes fizetés lehetséges!";
                        s++;
                    }
                    if(!ok){
                        uzenet = "Kérem, fogadja ez az ÁSzF-et!";
                        s++;
                    }
                    if(s == 0){
                        EmailService.DatasToModel(email,nev1,nev2,varos,cim,telefon);
                        
                        if(EmailService.Email(email)){
                            uzenet = "Az e-mail sikeresen elküldve.";
                        }
                       
                    }
                    
                    out.write(uzenet);
                    out.checkError();
                    out.flush();
                    
                }
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
