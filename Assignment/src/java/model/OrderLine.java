/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 *
 * @author eric
 */
public class OrderLine implements Serializable{
    private static int numberOfOrderLine = 0;
    private int orderlineID;
    private int orderID;
    private int quantity;
    private int productID;
    private String productName;
    private double totalPrice;
    private double price;
    
    
    public OrderLine() {
    }

    
    //Constructor to create a new order with the provided values
    public OrderLine(int orderID, int quantity, int productID, String productName, double price) {
        this.orderlineID = OrderLine.numberOfOrderLine;
        this.orderID = orderID;
        this.quantity = quantity;
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.totalPrice = quantity * price;
        
        OrderLine.numberOfOrderLine++;
    }
    
    
    // Constructor to create an orderLine with the provided values
    public OrderLine(int orderlineID, int orderID, int quantity, int productID, String productName, double totalPrice, double price) {
        this.orderlineID = orderlineID;
        this.orderID = orderID;
        this.quantity = quantity;
        this.productID = productID;
        this.productName = productName;
        this.totalPrice = totalPrice;
        this.price = price;
    }

    
    // Getters and setters
    public int getOrderlineID() {
        return orderlineID;
    }

    public void setOrderlineID(int orderlineID) {
        this.orderlineID = orderlineID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public void addQuantity() {
        // Increase the quantity of the order line by 1 and update the total price
        this.quantity++;
        this.totalPrice = this.totalPrice + (quantity*price);
    }

    public int decreaseQuantity() {
         // Decrease the quantity of the order line by 1 and update the total price
        this.quantity--;
        this.totalPrice = this.totalPrice - (quantity*price);
        return this.quantity;
    }
    
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice() {
        this.totalPrice = this.price * this.quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
    
}

