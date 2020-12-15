/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Service.ProductService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Valentin
 */
@WebServlet(name = "ProductController", urlPatterns = {"/ProductController"})
public class ProductController extends HttpServlet {
    ProductService Psrv = new ProductService();

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
        try {
            PrintWriter out = response.getWriter();
            if(request.getParameter("task")!=null){
                if(request.getParameter("task").equals("allproduct")){
                    String type = request.getParameter("type");
                    String sex = request.getParameter("sex");
                    
                    List<String> lista = new ArrayList<>();
                    lista = Psrv.webshopFill(type,sex);
                    String lista1 = "";

                    for(int i = 0; i < lista.size(); i++ ){
                        lista1 += lista.get(i) + "|";
                    }
                    
                    out.write(lista1);
                    out.close();
                    
                }
                
                if(request.getParameter("task").equals("cProduct")){
                    String number0 = request.getParameter("number");
                    Integer number = Integer.parseInt(number0);
                    List<String> lista = new ArrayList<>();
                    lista = Psrv.ProductFill(number);
                    String lista1 = "";
                    
                    for(int i = 0; i < lista.size(); i++ ){
                        lista1 += lista.get(i) + "|";
                    }
                    
                    out.write(lista1);
                    out.close();
                }
                
            }
           
        }catch(IOException e){
            e.toString();
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
