/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;
import uts.isd.model.dao.*;
/**
 *
 * @author eric
 */
public class Cart extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     @Override  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
      
        HttpSession session = request.getSession();
        int productID = Integer.parseInt(request.getParameter("productID").toString());
        int userID = Integer.parseInt(session.getAttribute("userID").toString());
        String productName = request.getParameter("productName");
        int orderID = Integer.parseInt(session.getAttribute("orderID").toString());
        double price =  Double.parseDouble(request.getParameter("price"));
        DBOrderLineManager manager = (DBOrderLineManager) session.getAttribute("orderLineManager");
        DBOrderManager orderManager = (DBOrderManager) session.getAttribute("orderManager");
        OrderLine orderLine = new OrderLine();
        
        
          
        try {
            orderLine = manager.findOrderLine(orderID, productID);
            if (orderLine == null) {
                orderLine = new OrderLine(orderID, 1, productID, productName, price);
                int orderLineID = orderLine.getOrderlineID();
                manager.addOrderLine(orderLineID,orderID,1,productID,productName, price, price);
                Order order = orderManager.findOrder(orderID, userID);
                order.updatePrice(price, 1);
                request.getRequestDispatcher("product.jsp").include(request, response);
            }
            else {
                int orderLineID = orderLine.getOrderlineID();
                orderLine.addQuantity();
                manager.updateOrder(orderLineID, orderID, orderLine.getQuantity(), productID, productName, orderLine.getTotalPrice(), price);
                Order order = orderManager.findOrder(orderID, userID);
                order.updatePrice(price, orderLine.getQuantity());
                request.getRequestDispatcher("device.jsp").include(request, response);
            }
            
            
        
        } catch (SQLException ex) {
            Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
        } 
            
            
           
        
        
        }
 }
 

