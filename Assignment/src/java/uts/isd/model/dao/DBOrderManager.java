package uts.isd.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import model.*;
import uts.isd.assignment.*;
/**
 * 
 * @author eric
 */
public class DBOrderManager {
    private Statement st; //used to execute SQL queries within java code
    
    public DBOrderManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
    
    public Order findOrder(int oID, int uID) throws SQLException {
        String fetch = "select * from IOTBAY.ORDERS where orderID = " + oID + " and userID='" + uID + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {  // reads every row in USERS table and gets the result by index and stores them into Strings
            int orderID = rs.getInt(1);
            int userID = rs.getInt(2);
            if (orderID == oID && userID == uID) {
                String orderDate = rs.getString(3);
                double tax = rs.getInt(4);
                double totalPrice = rs.getDouble(5);
                String shippingAddress = rs.getString(6);
                String billingAddress = rs.getString(7);
                return new Order(orderID, userID, orderDate, tax, totalPrice, shippingAddress, billingAddress);
                
            }
            
        }
        return null;
    }
    
    public void addOrder(int orderID, int userID) throws SQLException {
        st.executeUpdate("INSERT INTO IOTBAY.ORDERS VALUES ("+orderID+", '" +userID+"', null, null, null, null, null)");
              
        
          
    }
    
    public void updateOrder(int orderID, int userID, String orderDate, double tax, double totalPrice, String shippingAddress, String billingAddress) throws SQLException {
        st.executeUpdate("UPDATE IOTBAY.ORDERS SET ORDERDATE='"+orderDate+"',TAX="+tax+",TOTALPRICE="+totalPrice+",SHIPPINGADDRESS='"+shippingAddress+"',BILLINGADDRESS='"+billingAddress+"' WHERE ORDERID="+orderID + " AND USERID='"+userID+"'");
    }
    
    public void deleteOrder(int orderID) throws SQLException {
        st.executeUpdate("DELETE FROM IOTBAY.ORDERS WHERE ORDERID=" +orderID+"");
    }
    
    public ArrayList<Order> fetchOrders(int userID) throws SQLException {
        String fetch = "select * from ORDERS where USERID='"+userID+"'";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Order> temp = new ArrayList();
        
        while (rs.next()) {
            int orderID = rs.getInt(1);
            String orderDate = rs.getString(3);
            double tax = rs.getDouble(4);
            double totalPrice = rs.getDouble(5);
            String shippingAddress = rs.getString(6);
            String billingAddress = rs.getString(7);
            temp.add(new Order(orderID, userID, orderDate, tax, totalPrice, shippingAddress, billingAddress));
        }
        return temp;
    }
    
    
    
}