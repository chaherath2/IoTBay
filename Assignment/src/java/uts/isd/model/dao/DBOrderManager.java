/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;
import model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.Date;

import java.sql.Date;
import java.sql.Timestamp;
/**
 *
 * @author eric
 */
public class DBOrderManager {
    private final Statement statement;
    private final Connection conn;
    public DBOrderManager(Connection connection) throws SQLException {
    this.conn = connection;
    statement = connection.createStatement();
    }
       public void addOrder(String customerEmail, String paymentMethod, int deviceID, Timestamp dateOrdered, double totalPrice,
        double shipmentPrice, String shipmentType, String status, String streetAddress, String unitNumber, String city,
        String state, String postalCode, String phoneNumber) throws SQLException {
        
       //create the order for sql
       String query = "insert into customerorder (customerEmail, paymentMethod, deviceID, dateOrdered, totalPrice, shipmentPrice, shipmentType, status,unitNumber, streetAddress, city, state, postalCode, phoneNumber ) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
       PreparedStatement addStatement = conn.prepareStatement(query);
       //placing all parameters into the query
        addStatement.setString(1, customerEmail);
        addStatement.setString(2, paymentMethod);
        addStatement.setInt(3, deviceID);
        addStatement.setTimestamp(4, dateOrdered);
        addStatement.setDouble(5, totalPrice);
        addStatement.setDouble(6, shipmentPrice);
        addStatement.setString(7, shipmentType);
        addStatement.setString(8, status);
        addStatement.setString(9, unitNumber);
        addStatement.setString(10, streetAddress);
        addStatement.setString(11, city);
        addStatement.setString(12, state);
        addStatement.setString(13, postalCode);
        addStatement.setString(14, phoneNumber);
        addStatement.executeUpdate();
    }
       
       public void updateCustomerOrder(int orderID, String customerEmail, String paymentMethod, int deviceID, 
                                                                Timestamp dateOrdered, double totalPrice, double shipmentPrice, String shipmentType, String status, 
                                                                String streetAddress, String unitNumber, String city, String state, String postalCode, 
                                                                String phoneNumber) throws SQLException{
                String query = "UPDATE IOTUSER.customerOrder set customerEmail=?, paymentMethod=?, deviceID=?, dateOrdered=?, totalPrice=?, shipmentPrice=?, shipmentType=?, status=?, streetAddress=?, unitNumber=?, city=?, state=?. postalCode=?, phoneNumber=?";
                PreparedStatement updateStatement = conn.prepareStatement(query);
                        updateStatement.setString(1, customerEmail);
                        updateStatement.setString(2, paymentMethod);
                        updateStatement.setInt(3, deviceID);
                       updateStatement.setTimestamp(4, dateOrdered);
                        updateStatement.setDouble(5, totalPrice);
                        updateStatement.setDouble(6, shipmentPrice);
                        updateStatement.setString(7, shipmentType);
                        updateStatement.setString(8, status);
                        updateStatement.setString(9, unitNumber);
                       updateStatement.setString(10, streetAddress);
                       updateStatement.setString(11, city);
                        updateStatement.setString(12, state);
                        updateStatement.setString(13, postalCode);
                        updateStatement.setString(14, phoneNumber);
                        updateStatement.executeUpdate();
                        updateStatement.close();
       }
       
    public void deleteOrder(int orderID) throws SQLException {
        statement.executeUpdate("DELETE FROM IOTUSER.CUSTOMERORDER WHERE ORDERID=" + orderID + "");
    }
    
}
