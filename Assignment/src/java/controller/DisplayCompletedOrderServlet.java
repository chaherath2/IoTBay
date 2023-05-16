/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
public class DisplayCompletedOrderServlet extends HttpServlet {

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int orderID = Integer.parseInt(session.getAttribute("orderID").toString());
        int userID = Integer.parseInt(session.getAttribute("userID").toString());
        DBOrderManager orderManager = (DBOrderManager)session.getAttribute("orderManager");
           // Retrieve the billing address and shipping address from the request parameters
        String billingAddress = request.getParameter("billingAddress");
        String shippingAddress = request.getParameter("shippingAddress");
        try {
            // Find the order associated with the order ID and user ID
            Order order = orderManager.findOrder(orderID, userID);
            //setter
            order.setShippingAddress(shippingAddress);
            order.setBillingAddress(billingAddress);
            
            // Set the current date and time as the order date
            String date = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());

            order.setOrderDate(date);
            // Update the order in the database with the new shipping address, billing address, and order date
            orderManager.updateOrder(orderID, userID, date, order.getTax(), order.getTotalPrice(), shippingAddress, billingAddress);
            // Set the updated order object in the HttpSession
            session.setAttribute("order", order);
            request.getRequestDispatcher("CompletedOrder.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DisplayCompletedOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
