/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Order;
import Service.BasketService;
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
@WebServlet(name = "BasketController", urlPatterns = {"/BasketController"})
public class BasketController extends HttpServlet {

    BasketService Bsrc = new BasketService();
    ProductService Psrc = new ProductService();
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
                if(request.getParameter("task").equals("addToBasket")){
                    String Squantity = request.getParameter("quantity");
                    Integer quantity = Integer.parseInt(Squantity);
                    String Sid = request.getParameter("productId");
                    Integer productId = Integer.parseInt(Sid);
                    
                    Bsrc.addToBasket(productId,quantity);
                    
                    List<Integer> lista = new ArrayList<>();
                    lista = Order.getProductList();
                    String list = "";
                    for(int i = 0; i<lista.size();i++){
                        list += lista.get(i) + " : "; 
                    }
                    out.write(list);
                    
                    out.close();
                }
                
                if(request.getParameter("task").equals("showProduct")){
                    
                    List<Integer> lista = new ArrayList<>();
                    lista = Bsrc.basketProducts();
                    
                    
                    List<Integer> lista2 = new ArrayList<>();
                    for(int i = 0; i < lista.size(); i=i+2){
                        if(i+1 > 0){
                            lista2.add(lista.get(i));
                        }
                    }
                    
                    String lista5 = " ";
                    List<String> lista3 = Psrc.orderProducts(lista2);
                   
                    
                    List<Integer> dbLista = new ArrayList<>();
                    for(int i = 0; i < lista.size(); i++){
                        if(i%2 != 0){
                            dbLista.add(lista.get(i));
                        }
                    }
                    
                    int a = 0;
                    int b = 0;
                    
                    for(int i = 0; i< dbLista.size(); i++){
                        lista5 += dbLista.get(a) + "|";
                        a++;
                        lista5 += lista3.get(b) + "|";
                        b++;
                        lista5 += lista3.get(b) + "|";
                        b++;
                        lista5 += lista3.get(b) + "|";
                        b++;
                    }
                    
                    out.write(lista5);
                    out.close();
                }
            
            
            }
            
        }catch(Exception e){
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
