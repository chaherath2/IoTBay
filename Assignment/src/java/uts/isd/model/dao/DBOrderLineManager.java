/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.OrderLine;

/**
 *
 * @author User
 */
public class  DBOrderLineManager{
        private Statement st; //used to execute SQL queries within java code
    
    public DBOrderLineManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
    
    public OrderLine findOrderLine(int oID, int pID) throws SQLException {
        String fetch = "select * from IOTBAY.ORDERLINE where orderID = " + oID + " and productID="+pID+"";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {  // reads every row in USERS table and gets the result by index and stores them into Strings
            
            int orderID = rs.getInt(2);
            int productID = rs.getInt(4);
            if (orderID == oID && productID==pID) {
                
                int orderLineID = rs.getInt(1);
                int quantity = rs.getInt(3);
                String productName = rs.getString(5);
                double totalPrice = rs.getDouble(6);
                double price = rs.getDouble(7);
                return new OrderLine(orderLineID, orderID, quantity, productID, productName, totalPrice, price);
                
            }
            
        }
        return null;
    }
        // Insert a new row into the ORDERLINE table with the provided values
    public void addOrderLine(int orderLineID, int orderID, int quantity, int productID, String productName, double totalPrice, double price) throws SQLException {
        st.executeUpdate("INSERT INTO IOTBAY.ORDERLINE " + "VALUES (" +orderLineID+", " +orderID+", "+quantity+", "+productID+", '"+productName+"', "+totalPrice+", "+ price+")");
    }
    
    
    // Update an existing row in the ORDERLINE table with the provided values based on the orderLineID
    public void updateOrder(int orderLineID, int orderID, int quantity, int productID, String productName, double totalPrice, double price) throws SQLException {
        st.executeUpdate("UPDATE IOTBAY.ORDERLINE SET orderID="+orderID+",quantity="+quantity+",productID="+productID+",productName='"+
                productName+"',totalPrice="+totalPrice+", price="+price+" WHERE orderLineID="+orderLineID+"");
    }
    // Delete a row from the ORDERLINE table based on the orderLineID
    public void deleteOrder(int orderLineID) throws SQLException {
        st.executeUpdate("DELETE FROM IOTBAY.ORDERLINE WHERE orderLineID=" +orderLineID+"");
    }
    
    public ArrayList<OrderLine> fetchOrders(int orderID) throws SQLException {
        // Fetch all order lines associated with a specific orderID from the ORDERLINE table
        String fetch = "select * from IOTBAY.ORDERLINE where orderID="+orderID+"";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<OrderLine> temp = new ArrayList<OrderLine>();
        
        while (rs.next()) {
             // Retrieve the column values from the ResultSet and create OrderLine objects
            int orderLineID = rs.getInt(1);
            int quantity = rs.getInt(3);                
            int productID = rs.getInt(4);
            String productName = rs.getString(5);
            double totalPrice = rs.getDouble(6);
            double price = rs.getDouble(7);
            temp.add(new OrderLine(orderLineID, orderID, quantity, productID, productName, totalPrice, price));
        }
        return temp;
    }
    public void delete(int orderID) throws SQLException {
         // Delete all order lines associated with a specific orderID from the ORDERLINE table
        st.executeUpdate("DELETE FROM IOTBAY.ORDERLINE WHERE ORDERID="+orderID);
    }
}

