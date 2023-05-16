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
public class CustomerCartServlet extends HttpServlet {

    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
        HttpSession session = request.getSession();
        
        // Retrieve the product ID, user ID, product name, order ID, and price from the request parameters
        int productID = Integer.parseInt(request.getParameter("productID").toString());
        int userID = Integer.parseInt(session.getAttribute("userID").toString());
        String productName = request.getParameter("productName");
        int orderID = Integer.parseInt(session.getAttribute("orderID").toString());
        double price =  Double.parseDouble(request.getParameter("price"));
      
         // Retrieve the DBOrderLineManager and DBOrderManager objects from the HttpSession
        DBOrderLineManager manager = (DBOrderLineManager) session.getAttribute("orderLineManager");
        DBOrderManager orderManager = (DBOrderManager) session.getAttribute("orderManager");
        OrderLine orderLine = new OrderLine();
        
        
          
        try {
             // Find the existing OrderLine object for the given order ID and product ID
            orderLine = manager.findOrderLine(orderID, productID);
            if (orderLine == null) {
                orderLine = new OrderLine(orderID, 1, productID, productName, price);
                int orderLineID = orderLine.getOrderlineID();
                manager.addOrderLine(orderLineID,orderID,1,productID,productName, price, price);
                Order order = orderManager.findOrder(orderID, userID);
                order.updatePrice(price, 1);
                request.getRequestDispatcher("device.jsp").include(request, response);
            }
            else {
                int orderLineID = orderLine.getOrderlineID();
                orderLine.addQuantity();
                manager.updateOrder(orderLineID, orderID, orderLine.getQuantity(), productID, productName, orderLine.getTotalPrice(), price);
                Order order = orderManager.findOrder(orderID, userID);
                order.updatePrice(price, orderLine.getQuantity());
                request.getRequestDispatcher("main.jsp").include(request, response);
            }
            
            
        
        } catch (SQLException ex) {
            Logger.getLogger(CustomerCartServlet.class.getName()).log(Level.SEVERE, null, ex);
        } 
            
            
           
        
        
        }
}
