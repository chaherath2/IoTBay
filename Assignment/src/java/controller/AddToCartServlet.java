/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import model.*;
import uts.isd.assignment.*;
import uts.isd.model.dao.*;
/**
 *
 * @author user
 */
public class CreateBuyOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //retrieve session
    HttpSession session = request.getSession();
    DBDeviceManager deviceManager = (DBDeviceManager) session.getAttribute("deviceManager");
    int deviceID = Integer.parseInt(request.getParameter("id"));
    System.out.println("Device ID= " + deviceID);
        try {
            Device selectedDevice = deviceManager.selectOneDeviceID(deviceID);
            if (selectedDevice != null){
                
                session.setAttribute("purchaseDevice", selectedDevice);
                RequestDispatcher v = request.getRequestDispatcher("/createBuyOrder.jsp");
                 v.forward(request, response);
            }
                
            

        } catch (SQLException ex) {
            Logger.getLogger(CreateBuyOrder.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //get session
        HttpSession session = request.getSession();
        DBOrderManager orderManager = (DBOrderManager) session.getAttribute("orderManager");
        DBDeviceManager deviceManager = (DBDeviceManager) session.getAttribute("deviceManager");
        //retrieve the product from deviceID passed in the doGet in from the request
        Device selectedDevice = (Device) session.getAttribute("purchaseDevice");
        if (selectedDevice == null) {
            response.sendRedirect("/");
        }
        //retrieve delivery address
        String unitNumber = request.getParameter("unitnumber");
        String streetAddress = request.getParameter("streetaddress");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String postcode = request.getParameter("postcode");
        String phoneNumber = request.getParameter("phonenumber");
        double deviceCost = selectedDevice.getPrice();
        double totalCost = deviceCost;
        

        //set status
        String savedStatus = "SAVED";
        String submittedStatus = "SUBMITTED";
        String orderStatus = "";
        
        Customer loggedInCustomer = (Customer) session.getAttribute("customer");
        //anon stuff
        String userEmail = "";
        String shipmentType = "Express";
        double shipmentPrice = totalCost + 99;
        Timestamp timeNow = new Timestamp(new Date().getTime());

        if (loggedInCustomer == null){
            userEmail = "anonymous@anonymous.com";
            if (orderStatus.equals("SAVED")){
                try {
                        orderManager.addOrder(userEmail, null, selectedDevice.getDeviceId(), timeNow, totalCost, shipmentPrice, shipmentType, orderStatus,unitNumber, streetAddress, city, state, postcode, phoneNumber );
                        
                        
                } catch (SQLException ex) {
                    Logger.getLogger(CreateBuyOrder.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else {
            userEmail = loggedInCustomer.getEmail();
            if (orderStatus.equals("SAVED")){
                try {
                    orderManager.addOrder(userEmail, null, selectedDevice.getDeviceId(), timeNow, totalCost, shipmentPrice, shipmentType, orderStatus,unitNumber, streetAddress, city, state, postcode, phoneNumber);
                } catch (SQLException ex) {
                    Logger.getLogger(CreateBuyOrder.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}