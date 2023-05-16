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
public class ShippingOrderDetailsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int orderID = Integer.parseInt(session.getAttribute("orderID").toString());
        int userID = Integer.parseInt(session.getAttribute("userID").toString());
        double totalPrice = (double)session.getAttribute("totalPrice");
        double tax = (double)session.getAttribute("tax");
        DBOrderManager orderManager = (DBOrderManager)session.getAttribute("orderManager");
        try {
            Order order = orderManager.findOrder(orderID, userID);
            orderManager.updateOrder(orderID, userID, null, tax, totalPrice, null, null);
            //redirect the user to the shipping confirmation webpage page
            request.getRequestDispatcher("ConfirmShipping.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ShippingOrderDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
