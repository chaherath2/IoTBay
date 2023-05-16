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
public class CustomerOrderServlet extends HttpServlet {

    public void init() {
        
    }
    
    @Override   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
        HttpSession session = request.getSession();
        int userID = Integer.parseInt(session.getAttribute("userID").toString());
        
        DBOrderManager manager = (DBOrderManager) session.getAttribute("orderManager");
        Order order = new Order(userID);
        int orderID = order.getOrderID();
        try {
            manager.addOrder(orderID, userID);
        } 
        catch (SQLException ex) {
            Logger.getLogger(CustomerOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        session.setAttribute("orderID", orderID);
        request.getRequestDispatcher("main.jsp").include(request, response);
        
    }

}
