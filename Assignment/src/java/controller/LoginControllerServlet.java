/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author eric
 */


import java.io.IOException;

import java.sql.SQLException;

import java.util.logging.Level;

import java.util.logging.Logger;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import uts.isd.model.dao.DBManager;
import uts.isd.assignment.Customer;
import uts.isd.assignment.Staff;

/**
* 
* @author eric
*/

public class LoginControllerServlet extends HttpServlet {


@Override   

protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       

    //1- retrieve the current session
    HttpSession session = request.getSession();
    //2- create an instance of the Validator class    
    Validator validator = new Validator();
    //3- capture the posted email      
    String email = request.getParameter("email");
    //4- capture the posted password    
    String password = request.getParameter("password");
    //5- retrieve the manager instance from session      
    DBManager manager = (DBManager) session.getAttribute("manager");
    
    session.setAttribute("customer", null);
    session.setAttribute("staff", null);



try {       
    //6- find user by email and password
    Customer customer = manager.findCustomer(email, password);
    Staff staff = manager.findUser(email, password);


} catch (SQLException ex) {           

      Logger.getLogger(LoginControllerServlet.class.getName()).log(Level.SEVERE, null, ex);       

}


if (     /*7-   validate email  */   ) {           

 //8-set incorrect email error to the session           

 //9- redirect user back to the login.jsp     

} else if ( /*10-   validate password  */ ) {                  

 //11-set incorrect password error to the session           

 //12- redirect user back to the login.jsp          

} else if (user != null) {                     

 //13-save the logged in user object to the session           

 //14- redirect user to the main.jsp     

} else {                       

 //15-set user does not exist error to the session           

 //16- redirect user back to the login.jsp       

}   

}
