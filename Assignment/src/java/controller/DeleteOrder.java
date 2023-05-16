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
public class DeleteOrder extends HttpServlet {

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    
         // Retrieve the HttpSession object associated with the current request
        HttpSession session = request.getSession();
        // Retrieve the order ID from the HttpSession and convert it to an integer
        int orderID = Integer.parseInt(session.getAttribute("orderID").toString());
        DBOrderLineManager manager = (DBOrderLineManager) session.getAttribute("orderLineManager");
        DBOrderManager orderManager = (DBOrderManager) session.getAttribute("orderManager");
        try {
            // Delete the order line associated with the order ID from the database
            manager.delete(orderID);
            orderManager.deleteOrder(orderID);
            request.getRequestDispatcher("main.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
}

